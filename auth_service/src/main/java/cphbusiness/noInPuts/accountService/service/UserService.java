package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.UserDTO;
import cphbusiness.noInPuts.accountService.exception.UserAlreadyExistsException;

public interface UserService {
    UserDTO createAccount(UserDTO userDTO) throws UserAlreadyExistsException;
    UserDTO login(UserDTO userDTO);
}
