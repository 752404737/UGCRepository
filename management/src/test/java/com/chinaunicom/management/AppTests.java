package com.chinaunicom.management;

import com.chinaunicom.management.util.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {

    // private static final Logger logger = LogManager.getLogger(AppTests.class);

    @Test
    public void getMd5Test() {
        String usrName = "zrt";
        String passWord = "123456";
        String MD5 = CommonUtils.MD5Pwd(usrName, passWord);
        System.out.println(MD5);
    }

    @Test
    public void test() {

    }
}
