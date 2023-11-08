package cphbusiness.noInPuts.accountService.controller;

import cphbusiness.noInPuts.accountService.dto.UserDTO;
import cphbusiness.noInPuts.accountService.exception.UserAlreadyExistsException;
import cphbusiness.noInPuts.accountService.service.UserService;
import cphbusiness.noInPuts.accountService.service.JwtService;
import cphbusiness.noInPuts.accountService.service.RabbitMessagePublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private RabbitMessagePublisher rabbitMessagePublisher;

    @Test
    public void createUserShouldReturnUserWithID() throws Exception {
        mockUserServiceAndJwtService();

        this.mockMvc.perform(post("/user/create").content("{ \"username\": \"test_user\", \"password\": \"password\" }").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"user\":{\"id\":1,\"username\":\"test_user\"}}"));
    }

    @Test
    public void createUserShouldReturn400BadRequestWhenParsingBadRequest() throws Exception {
        mockUserServiceAndJwtService();

        this.mockMvc.perform(post("/user/create").content("{ \"password\": \"password\" }").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createUserShouldReturn415UnsupportedeMediaTypeWhenParsingInvalidJson() throws Exception {
        mockUserServiceAndJwtService();

        this.mockMvc.perform(post("/user/create").content("not json").characterEncoding("UTF-8"))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    public void createUserShouldReturn400BadRequestWhenParsingEmptyUsername() throws Exception {
        mockUserServiceAndJwtService();

        this.mockMvc.perform(post("/user/create").content("{ \"username\": \"\", \"password\": \"password\" }").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createUserShouldReturn400BadRequestWhenParsingEmptyPassword() throws Exception {
        mockUserServiceAndJwtService();

        this.mockMvc.perform(post("/user/create").content("{ \"username\": \"user_test\", \"password\": \"\" }").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createUserShouldReturn409ConflictWhenUsernameAlreadyExists() throws Exception {
        when(userService.createAccount(any(UserDTO.class))).thenThrow(new UserAlreadyExistsException("Username already exists."));
        when(jwtService.generateToken(any(UserDTO.class))).thenReturn("dummyToken");

        this.mockMvc.perform(post("/user/create").content("{ \"username\": \"test_user\", \"password\": \"password\" }").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andExpect(status().isConflict());
    }
    public void mockUserServiceAndJwtService() throws UserAlreadyExistsException {
        when(userService.createAccount(any(UserDTO.class))).thenReturn(new UserDTO(1, "test_user"));
        when(jwtService.generateToken(any(UserDTO.class))).thenReturn("dummyToken");
    }
}
