package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.AccountDTO;

public interface UserService {
    AccountDTO createAccount(AccountDTO accountDTO);
    AccountDTO login(AccountDTO accountDTO);
}
