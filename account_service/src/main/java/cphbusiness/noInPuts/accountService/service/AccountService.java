package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.AccountDTO;
import jdk.jshell.spi.ExecutionControl;

public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO) throws ExecutionControl.NotImplementedException;
}
