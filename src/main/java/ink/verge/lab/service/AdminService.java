package ink.verge.lab.service;

import ink.verge.lab.mbg.model.Admin;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Author Verge
 * @Date 2020/10/22 17:45
 * @Version 1.0
 */
public interface AdminService {
    int insertAdmin (Admin admin);
}
