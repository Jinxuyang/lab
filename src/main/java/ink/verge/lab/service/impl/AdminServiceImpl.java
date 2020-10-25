package ink.verge.lab.service.impl;

import ink.verge.lab.mbg.mapper.AdminMapper;
import ink.verge.lab.mbg.model.Admin;
import ink.verge.lab.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author Verge
 * @Date 2020/10/22 20:44
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public int insertAdmin(Admin admin) {
        String oriPasswd = admin.getPassword();
        String passwd = passwordEncoder.encode(oriPasswd);
        admin.setPassword(passwd);
        return adminMapper.insert(admin);
    }
}
