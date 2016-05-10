package coza.opencollab.unipoole.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * A util class for user data.
 * 
 * @author OpenCollab
 * @since 1.0.0
 */
public final class AuthenticationUtil {
    
    /**
     * Util class, so private
     */
    private AuthenticationUtil(){
        //utility class
    }

    /**
     * Get the username.
     */
    public static String getUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    /**
     * Get the user display name.
     * XXX
     */
    public static String getUserDisplayName() {
        return getUsername();
    }

    /**
     * Get the user email address.
     * XXX
     */
    public static String getUserEmail() {
        return null;
    }
}
