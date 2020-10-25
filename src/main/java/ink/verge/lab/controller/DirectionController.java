package ink.verge.lab.controller;

import ink.verge.lab.mbg.model.Direction;
import ink.verge.lab.response.CommonResult;
import ink.verge.lab.service.DirectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    DirectionService directionService;

    @Autowired
    public void setDirectionService(DirectionService directionService) {
        this.directionService = directionService;
    }

    @ApiOperation("添加成员")
    @PostMapping("/insert")
    public CommonResult insertDirection(@RequestBody Direction direction){
        if (directionService.insertDirection(direction) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
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

    @ApiOperation("修改成员信息")
    @PutMapping("{id}")
    public CommonResult updateDirection(@PathVariable int id,@RequestBody Direction direction){
        direction.setId(id);
        if (directionService.updateDirection(direction) == 1){
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

        Direction direction = directionService.getDirectionById(id);
        if (direction != null){
            return CommonResult.success(direction);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("获取所有成员")
    @GetMapping("/all")
    public CommonResult getAllDirection(){
        List<Direction> list = directionService.getAllDirection();
        return CommonResult.success(list);
    }
}
