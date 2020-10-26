package ink.verge.lab;

import cn.hutool.core.date.DateTime;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Verge
 * @Date 2020/10/26 19:39
 * @Version 1.0
 */
public class DateTest {
    @Test
    public void test(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");

        System.out.println(format.format(date));
    }
}
