package ink.verge.lab.controller;

import ink.verge.lab.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Verge
 * @Date 2020/10/16 15:46
 * @Version 1.0
 */
@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {
   /* private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }*/

    @RequestMapping("/login")
    public CommonResult login(String username,String password){
        return null;
    }
}
