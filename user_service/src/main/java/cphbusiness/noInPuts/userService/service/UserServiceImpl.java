package cphbusiness.noInPuts.userService.service;

import cphbusiness.noInPuts.userService.dto.UserDTO;
import cphbusiness.noInPuts.userService.model.User;
import cphbusiness.noInPuts.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getPhoneNumber(), userDTO.getAddress());
        User userEntity = userRepository.save(user);

        return new UserDTO(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getPhoneNumber(), userEntity.getAddress());
    }
}
