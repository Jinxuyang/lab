package ink.verge.lab.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ink.verge.lab.mbg.model.HomeNews;
import ink.verge.lab.response.CommonResult;
import ink.verge.lab.service.HomeNewsService;
import ink.verge.lab.utils.OssUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2020/10/26 13:38
 * @Version 1.0
 */
@Api("首页新闻管理")
@RestController
@RequestMapping("/homenews")
@Slf4j
public class HomeNewsController {
    @Autowired
    private HomeNewsService homenewsService;
    @Autowired
    OssUtils ossUtils;

    @ApiOperation("添加成员")
    @PostMapping("/insert")
    public CommonResult insertHomeNews(@RequestBody HomeNews homenews){
        if (homenewsService.insertHomeNews(homenews) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除成员")
    @DeleteMapping("{id}")
    public CommonResult deleteHomeNews(@PathVariable int id){
        if (homenewsService.deleteHomeNews(id) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("上传照片")
    @PostMapping("/image")
    public CommonResult uploadImage(MultipartFile img){
        return ossUtils.uploadImg(img);
    }

    @ApiOperation("上传文件")
    @PostMapping("/file")
    public CommonResult uploadFile(MultipartFile file){
        return ossUtils.uploadFile(file);
    }

    @ApiOperation("修改成员信息")
    @PutMapping("{id}")
    public CommonResult updateHomeNews(@PathVariable int id,@RequestBody HomeNews homenews){
        homenews.setId(id);
        if (homenewsService.updateHomeNews(homenews) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("通过ID获取成员")
    @GetMapping("{id}")
    public CommonResult getHomeNews(@PathVariable int id){
        if (id <= 0){
            return CommonResult.failed("参数不正确");
        }

        HomeNews homenews = homenewsService.getHomeNewsById(id);
        if (homenews != null){
            return CommonResult.success(homenews);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("获取所有项目")
    @GetMapping("/get/all")
    public CommonResult getAllHomeNews(@RequestParam(value = "pageNum") int pageNum,
                                        @RequestParam(value = "pageSize",defaultValue = "8") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<HomeNews> list = homenewsService.getAllHomeNews();
        int pageCnt = PageInfo.of(list).getPages();
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",list);
        resultMap.put("pageCnt",pageCnt);
        return CommonResult.success(resultMap);
    }

    @ApiOperation("根据关键词查找项目")
    @GetMapping("/get/keyword")
    public CommonResult getHomeNewsByKeyWord(@RequestParam String keyword,
                                              @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                              @RequestParam(value = "pageSize",defaultValue = "8") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<HomeNews> list = homenewsService.getHomeNewsByKeyword(keyword);
        int pageCnt = PageInfo.of(list).getPages();
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",list);
        resultMap.put("pageCnt",pageCnt);
        return CommonResult.success(resultMap);
    }
}
