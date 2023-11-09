package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.UserDTO;
import cphbusiness.noInPuts.accountService.exception.UserAlreadyExistsException;
import cphbusiness.noInPuts.accountService.exception.WeakPasswordException;
import cphbusiness.noInPuts.accountService.model.User;
import cphbusiness.noInPuts.accountService.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void createUserShouldReturnWithID() throws UserAlreadyExistsException, WeakPasswordException {
        User user = new User("test_user", "password");
        user.setId(1);
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO userDTO = new UserDTO("test_user", "Password1!");
        UserDTO createdUserDTO = userService.createAccount(userDTO);

        assertEquals(createdUserDTO.getUsername(), userDTO.getUsername());
        assertEquals(createdUserDTO.getId(), 1);
    }

    @Test
    public void createUserShouldThrowExceptionWhenUserAlreadyExist() {
        User user = new User("user", "Password1!");
        when(userRepository.findByUsername(any(String.class))).thenReturn(Optional.of(user));
        UserDTO userDTO = new UserDTO("test_user", "Password1!");

        assertThrows(UserAlreadyExistsException.class, () -> userService.createAccount(userDTO));
    }

    @Test
    public void createUserShouldThrowExceptionWhenPasswordIsToWeak() {
        // Create userDTO with weak password
        UserDTO userDTO  = new UserDTO("test_user", "weak");

        assertThrows(WeakPasswordException.class, () -> userService.createAccount(userDTO));
    }
}
