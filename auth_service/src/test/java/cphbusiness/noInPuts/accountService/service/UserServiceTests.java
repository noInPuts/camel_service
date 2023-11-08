package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.UserDTO;
import cphbusiness.noInPuts.accountService.model.User;
import cphbusiness.noInPuts.accountService.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void createUserShouldReturnWithID() {
        User user = new User("test_user", "password");
        user.setId(1);
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO userDTO = new UserDTO("test_user", "password");
        UserDTO createdUserDTO = userService.createAccount(userDTO);

        assertEquals(createdUserDTO.getUsername(), userDTO.getUsername());
        assertEquals(createdUserDTO.getId(), 1);
    }

    // TODO: Exception test for createAccount
}
