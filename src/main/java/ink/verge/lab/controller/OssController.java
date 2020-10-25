package ink.verge.lab.controller;

import ink.verge.lab.dto.OssCallbackResult;
import ink.verge.lab.dto.OssPolicyResult;
import ink.verge.lab.response.CommonResult;
import ink.verge.lab.service.impl.OssServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Verge
 * @Date 2020/10/10 20:14
 * @Version 1.0
 */
@Api("Oss")
@RestController
@RequestMapping("/aliyun/oss")
//@CrossOrigin
public class OssController {
    private OssServiceImpl ossService;

    @Autowired
    public void setOssService(OssServiceImpl ossService) {
        this.ossService = ossService;
    }

    @ApiOperation("生成签名")
    @GetMapping(value = "/policy")
    public CommonResult policy() {
        //return ossService.policy();
        OssPolicyResult result = ossService.policy();
        return CommonResult.success(result);
    }

    @ApiOperation("回调函数")
    @PostMapping(value = "/callback")
    public CommonResult callback(HttpServletRequest request) {
        OssCallbackResult ossCallbackResult = ossService.callback(request);
        return CommonResult.success(ossCallbackResult);
    }

}
