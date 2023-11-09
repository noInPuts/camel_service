package cphbusiness.noInPuts.accountService.repository;

import cphbusiness.noInPuts.accountService.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void createUserShouldReturnWithID() {
        User user = userRepository.save(new User("test_user", "password"));

        assertNotNull(user);
        assertEquals("test_user", user.getUsername());
        assertEquals("password", user.getPassword());
        assertNotNull(user.getId());
    }
}
