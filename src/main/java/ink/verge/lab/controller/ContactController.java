package ink.verge.lab.controller;

import ink.verge.lab.mbg.model.Contact;
import ink.verge.lab.response.CommonResult;
import ink.verge.lab.service.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/11 20:01
 * @Version 1.0
 */
@Component
@RestController
@RequestMapping("/contact")
@Slf4j
@Api("ContactController")
public class ContactController {
    ContactService contactService;

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @ApiOperation("添加成员")
    @PostMapping("/insert")
    public CommonResult insertContact(@RequestBody Contact contact){
        if (contactService.insertContact(contact) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除成员")
    @DeleteMapping("{id}")
    public CommonResult deleteContact(@PathVariable int id){
        if (contactService.deleteContact(id) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改成员信息")
    @PutMapping("{id}")
    public CommonResult updateContact(@PathVariable int id,@RequestBody Contact contact){
        contact.setId(id);
        if (contactService.updateContact(contact) == 1){
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("通过ID获取成员")
    @GetMapping("{id}")
    public CommonResult getContact(@PathVariable int id){
        if (id <= 0){
            return CommonResult.failed("参数不正确");
        }

        Contact contact = contactService.getContactById(id);
        if (contact != null){
            return CommonResult.success(contact);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("获取所有成员")
    @GetMapping("/all")
    public CommonResult getAllContact(){
        List<Contact> list = contactService.getAllContact();
        return CommonResult.success(list);
    }
}
