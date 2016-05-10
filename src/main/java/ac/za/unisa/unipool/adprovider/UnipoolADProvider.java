package ac.za.unisa.unipool.adprovider;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UnipoolADProvider implements AuthenticationProvider {

    private String adProviderURL;
    private String unisaDomain;
    private String authenticationType;

    @Autowired
    public void setAdProviderURL(@Qualifier("adProviderURL") String adProviderURL) {
        this.adProviderURL = adProviderURL;
    }

    @Autowired
    public void setUnisaDomain(@Qualifier("unisaDomain") String unisaDomain) {
        this.unisaDomain = unisaDomain;
    }

    @Autowired
    public void setAuthenticationType(@Qualifier("authenticationType") String authenticationType) {
        this.authenticationType = authenticationType;
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authenticationToken = null;

        try {
            if (authenticateADUser(authentication)) {
                String password = (String) authentication.getCredentials();
                authenticationToken = new UsernamePasswordAuthenticationToken(authentication.getName(), password, populateUnipoolUserRoleAuthorities());
            }
        } catch (Exception ex) {
            Logger.getLogger(UnipoolADProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw new UsernameNotFoundException(ex.getMessage());
        }
        return authenticationToken;
    }

    private boolean authenticateADUser(Authentication authentication) throws NamingException {

        String password = (String) authentication.getCredentials();

        Properties dirContextProperties = new Properties();
        dirContextProperties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        dirContextProperties.setProperty(Context.PROVIDER_URL, adProviderURL);
        dirContextProperties.setProperty(Context.URL_PKG_PREFIXES, "com.sun.jndi.url");
        dirContextProperties.setProperty(Context.REFERRAL, "ignore");
        dirContextProperties.setProperty(Context.SECURITY_AUTHENTICATION, authenticationType);
        dirContextProperties.setProperty(Context.SECURITY_PRINCIPAL, authentication.getName() + "@" + unisaDomain);
        dirContextProperties.setProperty(Context.SECURITY_CREDENTIALS, password);

        DirContext dirContext = new InitialDirContext(dirContextProperties);

        boolean result = dirContext != null;

        if (dirContext != null) {
            dirContext.close();
        }

        return result;
    }

    private Set<GrantedAuthority> populateUnipoolUserRoleAuthorities() {

        Set<UnipoolUserRole> unipoolUserRoles = new HashSet<UnipoolUserRole>();
        unipoolUserRoles.add(new UnipoolUserRole());

        Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
        authorities.addAll(unipoolUserRoles);
        return authorities;
    }
}
