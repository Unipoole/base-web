package ac.za.unisa.unipool.adprovider;

import java.io.Serializable;
import org.springframework.security.core.GrantedAuthority;

public class UnipoolUserRole implements Serializable, GrantedAuthority {

       String roleName = "ROLE_USER";
    
       @Override
       public String getAuthority() {
        return this.roleName;
    }
}
