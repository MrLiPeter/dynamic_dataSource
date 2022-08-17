package org.lxh;

import org.junit.jupiter.api.Test;
import org.lxh.model.User;
import org.lxh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class DynamicMyDataSourceApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        List<User> allUsers = userService.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }
    }

}
