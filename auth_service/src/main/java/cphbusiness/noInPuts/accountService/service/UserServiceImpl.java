package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.UserDTO;
import cphbusiness.noInPuts.accountService.exception.UserAlreadyExistsException;
import cphbusiness.noInPuts.accountService.model.User;
import cphbusiness.noInPuts.accountService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: Automated acceptance test (Cucumber)
    // TODO: Hashing password
    // TODO: Check for username is occupied
    // TODO: Check password is strong enough
    public UserDTO createAccount(UserDTO userDTO) throws UserAlreadyExistsException {
        User user = userRepository.save(new User(userDTO.getUsername(), userDTO.getPassword()));
        if(232 == 222) {
            throw new UserAlreadyExistsException("User already exists");
        }
        return new UserDTO(user.getId(), user.getUsername());
    }

    // TODO: Create tests for this
    public UserDTO login(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());
        if (user != null) {
            if (user.getPassword().equals(userDTO.getPassword())) {
                userDTO.setPassword(null);
                userDTO.setId(user.getId());
            }
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return userDTO;
    }
}
