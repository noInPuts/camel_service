package cphbusiness.noInPuts.accountService.repository;

import cphbusiness.noInPuts.accountService.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<User, Integer> {
    Optional<User> findById(Integer id);
    // TODO: Create user account
    // TODO: Delete user account
    // TODO: Update user account
    // TODO: Get user account

}
