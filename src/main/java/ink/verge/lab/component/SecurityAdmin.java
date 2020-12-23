package ink.verge.lab.component;

import ink.verge.lab.mbg.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @Author Verge
 * @Date 2020/10/22 17:31
 * @Version 1.0
 */
public class SecurityAdmin extends User {
    @Autowired
    private Admin originalAdmin;

    public SecurityAdmin(Admin admin, Collection<? extends GrantedAuthority> authorities) {
        super(admin.getUsername(),admin.getPassword(),authorities);
        this.originalAdmin = admin;
    }
    public Admin getOriginalAdmin(){
        return originalAdmin;
    }

}
