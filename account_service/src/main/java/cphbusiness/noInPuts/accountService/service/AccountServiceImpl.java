package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.AccountDTO;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    public AccountDTO createAccount(AccountDTO accountDTO) throws ExecutionControl.NotImplementedException {
        // TODO: Implementation
        throw new ExecutionControl.NotImplementedException("Not implemented");
    }
}
