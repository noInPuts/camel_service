package cphbusiness.noInPuts.accountService.controller;

import cphbusiness.noInPuts.accountService.dto.AccountDTO;
import cphbusiness.noInPuts.accountService.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
public class AccountControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void createAccountShouldReturnAccountWithID() throws Exception {
        when(accountService.createAccount(any(AccountDTO.class))).thenReturn(new AccountDTO(1, "test_user", "password"));
        this.mockMvc.perform(post("/account/create").content("{ \"username\": \"test_user\", \"password\": \"password\" }").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"username\":\"test_user\"}"));
    }
}
