package ink.verge.lab.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ink.verge.lab.mbg.model.Introduction;
import ink.verge.lab.response.CommonResult;
import ink.verge.lab.service.IntroductionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2020/10/26 13:56
 * @Version 1.0
 */
@Api("简介管理")
@RestController
@RequestMapping("/introduction")
@Slf4j
public class IntroductionController {
    IntroductionService introductionService;

    @Autowired
    public void setIntroductionService(IntroductionService introductionService) {
        this.introductionService = introductionService;
    }

    @ApiOperation("添加成员")
    @PostMapping("/insert")
    public CommonResult insertIntroduction(@RequestBody Introduction introduction){
        if (introductionService.insertIntroduction(introduction) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除成员")
    @DeleteMapping("{id}")
    public CommonResult deleteIntroduction(@PathVariable int id){
        if (introductionService.deleteIntroduction(id) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改成员信息")
    @PutMapping("{id}")
    public CommonResult updateIntroduction(@PathVariable int id,@RequestBody Introduction introduction){
        introduction.setId(id);
        if (introductionService.updateIntroduction(introduction) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("通过ID获取成员")
    @GetMapping("{id}")
    public CommonResult getIntroduction(@PathVariable int id){
        if (id <= 0){
            return CommonResult.failed("参数不正确");
        }

        Introduction introduction = introductionService.getIntroductionById(id);
        if (introduction != null){
            return CommonResult.success(introduction);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("获取所有项目")
    @GetMapping("/get/all")
    public CommonResult getAllIntroduction(@RequestParam(value = "pageNum") int pageNum,
                                       @RequestParam(value = "pageSize",defaultValue = "8") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Introduction> list = introductionService.getAllIntroduction();
        int pageCnt = PageInfo.of(list).getPages();
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",list);
        resultMap.put("pageCnt",pageCnt);
        return CommonResult.success(resultMap);
    }

    @ApiOperation("根据关键词查找项目")
    @GetMapping("/get/keyword")
    public CommonResult getIntroductionByKeyWord(@RequestParam String keyword,
                                             @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                             @RequestParam(value = "pageSize",defaultValue = "8") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Introduction> list = introductionService.getIntroductionByKeyword(keyword);
        int pageCnt = PageInfo.of(list).getPages();
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",list);
        resultMap.put("pageCnt",pageCnt);
        return CommonResult.success(resultMap);
    }
}
