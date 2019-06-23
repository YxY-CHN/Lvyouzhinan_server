package com.yuxuyi.lvyouzhinan;

import com.yuxuyi.lvyouzhinan.entity.Admin;
import com.yuxuyi.lvyouzhinan.entity.User;
import com.yuxuyi.lvyouzhinan.mapper.AdminMapper;
import com.yuxuyi.lvyouzhinan.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LvyouzhinanApplicationTests {

    @Autowired
//    UserMapper userMapper;
    @Test
    public void contextLoads() {
//        User user=new User();
//        user.setName("test");
//        user.setPhone("123");
//        user.setPassword("1234");
////        Admin admin = adminMapper.getByName("admin");
////        System.out.println(admin.getPassword());
////        LocalDateTime date = LocalDateTime.now();
////        System.out.println(date.toString());
//        userMapper.save(user);
    }

}
