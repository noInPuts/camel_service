package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.AccountDTO;
import cphbusiness.noInPuts.accountService.model.User;
import cphbusiness.noInPuts.accountService.repository.AccountRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDTO createAccount(AccountDTO accountDTO)  {
        // TODO: Implementation
        Optional<User> optionalUser = accountRepository.findById(accountDTO.getId());
        User user;

        try {
            if(optionalUser.isPresent()) {
                user = optionalUser.get();
            } else {
                throw new ChangeSetPersister.NotFoundException();
            }
        } catch (ChangeSetPersister.NotFoundException e) {
            return null;
        }

        return new AccountDTO(user.getId(), user.getUsername());
    }
}
