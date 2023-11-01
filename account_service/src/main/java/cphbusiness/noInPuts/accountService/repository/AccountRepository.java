package cphbusiness.noInPuts.accountService.repository;

import cphbusiness.noInPuts.accountService.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<User, Integer> {
    // TODO: Create user account
    // TODO: Delete user account
    // TODO: Update user account
    // TODO: Get user account
}
