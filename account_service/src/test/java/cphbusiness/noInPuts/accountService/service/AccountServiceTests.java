package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.AccountDTO;
import cphbusiness.noInPuts.accountService.model.User;
import cphbusiness.noInPuts.accountService.repository.AccountRepository;
import cphbusiness.noInPuts.accountService.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountServiceTests {

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    public void createAccountShouldReturnWithID() {
        User user = new User("test_user", "password");
        user.setId(1);
        when(accountRepository.save(any(User.class))).thenReturn(user);

        AccountDTO accountDTO = new AccountDTO("test_user", "password");
        AccountDTO createdAccountDTO = accountService.createAccount(accountDTO);

        assertEquals(createdAccountDTO.getUsername(), accountDTO.getUsername());
        assertEquals(createdAccountDTO.getId(), 1);
    }

    // TODO: Exception test for createAccount
}
