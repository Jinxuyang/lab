package ink.verge.lab.controller;

import ink.verge.lab.component.CustomUserDetailService;
import ink.verge.lab.mbg.model.Admin;
import ink.verge.lab.response.CommonResult;
import ink.verge.lab.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Verge
 * @Date 2020/10/22 21:01
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin")
@Api("管理员管理")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    CustomUserDetailService userDetailService;
    @GetMapping("/auth")
    public CommonResult doLogin(){
        //UserDetails userDetails = userDetailService.loadUserByUsername(username);

        return CommonResult.failed("请登录");
    }
    @ApiOperation("新增用户")
    @PostMapping("/insert")
    public CommonResult insertAdmin(@RequestBody Admin admin){
        if (adminService.insertAdmin(admin) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @GetMapping("/me")
    public CommonResult getMyInfo(Authentication authentication){
        return CommonResult.success(authentication);
    }
}
