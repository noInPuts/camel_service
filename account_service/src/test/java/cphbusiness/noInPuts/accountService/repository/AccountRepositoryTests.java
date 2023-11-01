package cphbusiness.noInPuts.accountService.repository;

import cphbusiness.noInPuts.accountService.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AccountRepositoryTests {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void createAccountShouldReturnWithID() {
        User user = accountRepository.save(new User("test_user", "password"));

        assertNotNull(user);
        assertEquals(user.getUsername(), "test_user");
        assertEquals(user.getId(), 1);
    }
}
