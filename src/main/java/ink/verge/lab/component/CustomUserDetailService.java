package ink.verge.lab.component;

import ink.verge.lab.component.SecurityAdmin;
import ink.verge.lab.mbg.mapper.AdminMapper;
import ink.verge.lab.mbg.mapper.AuthMapper;
import ink.verge.lab.mbg.mapper.RoleMapper;
import ink.verge.lab.mbg.model.Admin;
import ink.verge.lab.mbg.model.AdminExample;
import ink.verge.lab.mbg.model.Auth;
import ink.verge.lab.mbg.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/22 20:25
 * @Version 1.0
 */
@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuthMapper authMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andUsernameEqualTo(username);
        List<Admin> list = adminMapper.selectByExample(adminExample);
        if (list == null || list.size() != 1) return null;
        Admin admin = list.get(0);

        //String password = admin.getPassword();
        Integer adminId = admin.getId();

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> roleList = roleMapper.selectAssignRoleList(adminId);
        List<Integer> roleIdList = new ArrayList<>();
        for (Role role : roleList) {
            String roleName = role.getName();
            roleIdList.add(role.getId());
            authorities.add(new SimpleGrantedAuthority("ROLE_"+roleName));
        }

        for (Integer id : roleIdList) {
            List<Auth> authList = authMapper.selectAssignedAuthList(id);
            for (Auth auth : authList) {
                String authName = auth.getAuth();
                authorities.add(new SimpleGrantedAuthority(authName));
            }
        }


        return new SecurityAdmin(admin,authorities);

    }
}
