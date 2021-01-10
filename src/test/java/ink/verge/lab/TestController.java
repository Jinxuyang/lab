package ink.verge.lab;

import ink.verge.lab.controller.MemberController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;


/**
 * @Author Verge
 * @Date 2020/11/13 17:23
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {""})
public class TestController {
    @Autowired
    MemberController controller;
    @Test
    public void test(){
        PathMatcher matcher = new AntPathMatcher();
        Assert.assertTrue(matcher.match("/user", "/user"));
        Assert.assertTrue(matcher.match("/**/user", "/dfgdg/gdfgdf/dfgdsad/user"));
        Assert.assertTrue(matcher.match("/*/user", "/asdas/user"));
        Assert.assertFalse(matcher.match("/*/user", "/asdas/sadas/user"));
        Assert.assertTrue(matcher.match("/*/user/**", "/asdas/user"));
    }
}
