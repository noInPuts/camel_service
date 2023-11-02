package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.AccountDTO;
import cphbusiness.noInPuts.accountService.model.User;
import cphbusiness.noInPuts.accountService.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // TODO: Automated acceptance test (Cucumber)
    // TODO: Hashing password
    // TODO: Check for username is occupied
    // TODO: Check password is strong enough
    public AccountDTO createAccount(AccountDTO accountDTO)  {
        User user = accountRepository.save(new User(accountDTO.getUsername(), accountDTO.getPassword()));
        return new AccountDTO(user.getId(), user.getUsername());
    }
}
