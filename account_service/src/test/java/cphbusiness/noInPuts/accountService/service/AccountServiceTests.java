package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.AccountDTO;
import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceTests {

    @Disabled
    @Test
    public void createAccountShouldReturnWithID() throws ExecutionControl.NotImplementedException {
        AccountService accountService = new AccountServiceImpl();
        AccountDTO accountDTO = new AccountDTO("test_user", "password");
        AccountDTO createdAccountDTO = accountService.createAccount(accountDTO);

        assertEquals(createdAccountDTO.getUsername(), accountDTO.getUsername());
        assertEquals(createdAccountDTO.getId(), 1);
    }
}
