package cphbusiness.noInPuts.userService.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void createUserShouldReturnUserDTO () {
        userService.createUser(null);

    }
}
