package ink.verge.lab.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ink.verge.lab.controller.viewobject.DirectionVO;
import ink.verge.lab.mbg.model.Direction;
import ink.verge.lab.response.CommonResult;
import ink.verge.lab.service.DirectionService;
import ink.verge.lab.utils.OssUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @Author Verge
 * @Date 2020/10/11 20:05
 * @Version 1.0
 */
@Component
@RestController
@RequestMapping("/direction")
@Slf4j
@Api("DirectionController")

public class DirectionController {
    @Autowired
    private OssUtils ossUtils;
    @Autowired
    private DirectionService directionService;

    @ApiOperation("添加成员")
    @PostMapping("/insert")
    public CommonResult insertDirection(@RequestBody DirectionVO direction){
        if (directionService.insertDirectionWithPhotos(direction)) return CommonResult.success();
        else return CommonResult.failed();
    }

    @ApiOperation("添加图片")
    @PostMapping("/insert/photo")
    public CommonResult insertPhotos(@RequestParam MultipartFile img){
        return ossUtils.uploadImg(img);
    }

    @ApiOperation("删除成员")
    @DeleteMapping("{id}")
    public CommonResult deleteDirection(@PathVariable int id){
        if (directionService.deleteDirection(id) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("通过图片Url删除图片")
    @DeleteMapping("/photo")
    public CommonResult deletePhotoByUrl(@RequestParam String url){
        if (directionService.deletePhotoByUrl(url) == 1) return CommonResult.success();
        else return CommonResult.failed();
    }

    @ApiOperation("修改成员信息")
    @PutMapping("{id}")
    public CommonResult updateDirection(@PathVariable int id,@RequestBody DirectionVO directionVO){
        directionVO.setId(id);
        if (directionService.updateDirectionVO(directionVO) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("通过ID获取成员")
    @GetMapping("{id}")
    public CommonResult getDirection(@PathVariable int id){
        if (id <= 0){
            return CommonResult.failed("参数不正确");
        }

        DirectionVO directionVO = directionService.getDirectionVOByID(id);
        if (directionVO != null){
            return CommonResult.success(directionVO);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("获取所有项目")
    @GetMapping("/get/all")
    public CommonResult getAllDirection(@RequestParam(value = "pageNum") int pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "8") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<DirectionVO> list = directionService.getAllDirectionVO();
        int pageCnt = PageInfo.of(list).getPages();
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",list);
        resultMap.put("pageCnt",pageCnt);
        return CommonResult.success(resultMap);
    }

    @ApiOperation("根据关键词查找项目")
    @GetMapping("/get/keyword")
    public CommonResult getDirectionByKeyWord(@RequestParam String keyword,
                                            @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                            @RequestParam(value = "pageSize",defaultValue = "8") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<DirectionVO> list = directionService.getDirectionVOByKeyword(keyword);
        int pageCnt = PageInfo.of(list).getPages();
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",list);
        resultMap.put("pageCnt",pageCnt);
        return CommonResult.success(resultMap);
    }
}
