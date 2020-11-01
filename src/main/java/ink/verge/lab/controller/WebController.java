package ink.verge.lab.controller;

import ink.verge.lab.response.CommonResult;
import ink.verge.lab.service.WebService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Verge
 * @Date 2020/10/31 13:34
 * @Version 1.0
 */
@RequestMapping("/web")
@RestController
@Slf4j
@Api("前端视图")
public class WebController {
    @Autowired
    private WebService webService;

    @ApiOperation("获取Index页")
    @GetMapping("/index")
    public CommonResult getIndexPage() {
        try {
            return CommonResult.success("",webService.getHomePage());
        } catch (Exception e){
            return CommonResult.failed();
        }

    }
}
