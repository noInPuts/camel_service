package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.UserDTO;
import cphbusiness.noInPuts.accountService.exception.UserAlreadyExistsException;
import cphbusiness.noInPuts.accountService.exception.WrongCredentialsException;
import cphbusiness.noInPuts.accountService.model.User;
import cphbusiness.noInPuts.accountService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: Automated acceptance test (Cucumber)
    // TODO: Hashing password
    // TODO: Check password is strong enough
    public UserDTO createAccount(UserDTO userDTO) throws UserAlreadyExistsException {
        Optional<User> checkIfUserExist = userRepository.findByUsername(userDTO.getUsername());

        if(checkIfUserExist.isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }

        User user = userRepository.save(new User(userDTO.getUsername(), userDTO.getPassword()));

        return new UserDTO(user.getId(), user.getUsername());
    }

    // TODO: Create tests for this
    public UserDTO login(UserDTO userDTO) throws WrongCredentialsException {
        Optional<User> user = userRepository.findByUsername(userDTO.getUsername());
        if (user.isPresent()) {
            if (user.get().getPassword().equals(userDTO.getPassword())) {
                userDTO.setPassword(null);
                userDTO.setId(user.get().getId());
            } else {
                throw new WrongCredentialsException("Wrong password.");
            }
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return userDTO;
    }
}
