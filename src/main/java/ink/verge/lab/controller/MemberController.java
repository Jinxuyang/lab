package ink.verge.lab.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ink.verge.lab.mbg.model.Member;
import ink.verge.lab.response.CommonResult;
import ink.verge.lab.service.MemberService;
import ink.verge.lab.utils.OssUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2020/10/9 0:27
 * @Version 1.0
 */
@Component
@RestController
@RequestMapping("/member")
@Slf4j
@Api("MemberController")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private OssUtils ossUtils;

    @ApiOperation("添加成员")
    @PostMapping("/insert")
    public CommonResult insertMember(@RequestBody Member member){
        if (memberService.insertMember(member) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("上传成员照片")
    @PostMapping("/insert/photo")
    public CommonResult insertMemberPhoto(@RequestParam MultipartFile img){
        return ossUtils.uploadImg(img);
    }
    @ApiOperation("删除成员")
    @DeleteMapping("/{id}")
    public CommonResult deleteMember(@PathVariable int id){
        if (memberService.deleteMember(id) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改成员信息")
    @PutMapping("/{id}")
    public CommonResult updateMember(@PathVariable int id,@RequestBody Member member){
        log.info("进入Controller ， id" + id);
        log.info("Member" + member);

        member.setId(id);
        if (memberService.updateMember(member) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("通过ID获取成员")
    @GetMapping("/{id}")
    public CommonResult getMember(@PathVariable int id){
        if (id <= 0){
          return CommonResult.failed("参数不正确");
        }

        Member member = memberService.getMemberById(id);
        if (member != null){
            return CommonResult.success(member);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("获取所有成员")
    @GetMapping("/get/all")
    public CommonResult getAllMember( @RequestParam(value = "pageNum") int pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "8") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Member> list = memberService.getAllMember();
        int pageCnt = PageInfo.of(list).getPages();
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",list);
        resultMap.put("pageCnt",pageCnt);
        return CommonResult.success(resultMap);
    }

    @ApiOperation("根据关键词查找成员")
    @GetMapping("/get/keyword")
    public CommonResult getMemberByKeyWord(@RequestParam String keyword,
                                           @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                           @RequestParam(value = "pageSize",defaultValue = "8") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Member> list = memberService.getMemberByKeyWord(keyword);
        int pageCnt = PageInfo.of(list).getPages();
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",list);
        resultMap.put("pageCnt",pageCnt);
        return CommonResult.success(resultMap);
    }
}
