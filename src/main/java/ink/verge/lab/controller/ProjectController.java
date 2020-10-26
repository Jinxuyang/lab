package ink.verge.lab.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ink.verge.lab.mbg.model.Project;
import ink.verge.lab.response.CommonResult;
import ink.verge.lab.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2020/10/11 20:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/project")
@Slf4j
@Api("ProjectController")
public class ProjectController {
    ProjectService projectService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ApiOperation("添加成员")
    @PostMapping("/insert")
    public CommonResult insertProject(@RequestBody Project project){
        if (projectService.insertProject(project) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除成员")
    @DeleteMapping("{id}")
    public CommonResult deleteProject(@PathVariable int id){
        if (projectService.deleteProject(id) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改成员信息")
    @PutMapping("{id}")
    public CommonResult updateProject(@PathVariable int id,@RequestBody Project project){
        project.setId(id);
        if (projectService.updateProject(project) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("通过ID获取成员")
    @GetMapping("{id}")
    public CommonResult getProject(@PathVariable int id){
        if (id <= 0){
            return CommonResult.failed("参数不正确");
        }

        Project project = projectService.getProjectById(id);
        if (project != null){
            return CommonResult.success(project);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("获取所有项目")
    @GetMapping("/get/all")
    public CommonResult getAllProject(@RequestParam(value = "pageNum") int pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "8") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Project> list = projectService.getAllProject();
        int pageCnt = PageInfo.of(list).getPages();
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",list);
        resultMap.put("pageCnt",pageCnt);
        return CommonResult.success(resultMap);
    }

    @ApiOperation("根据关键词查找项目")
    @GetMapping("/get/keyword")
    public CommonResult getProjectByKeyWord(@RequestParam String keyword,
                                           @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                           @RequestParam(value = "pageSize",defaultValue = "8") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Project> list = projectService.getProjectByKeyWord(keyword);
        int pageCnt = PageInfo.of(list).getPages();
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",list);
        resultMap.put("pageCnt",pageCnt);
        return CommonResult.success(resultMap);
    }
}
