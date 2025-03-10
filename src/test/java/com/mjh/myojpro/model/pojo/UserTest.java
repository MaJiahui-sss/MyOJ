package com.mjh.myojpro.model.pojo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    /**
     * 测试lombok插件是否正常工作
     */
    @Test
    public void testLombok(){
        User user = new User();
        User userMjh = User.builder().userId(555).userName("马家辉").build();
        User userWys = new User();
        userWys.setUserName("温云舒");
        System.out.println(userMjh);
        System.out.println(userWys);

    }
}
