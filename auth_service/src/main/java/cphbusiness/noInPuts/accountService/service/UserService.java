package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.UserDTO;
import cphbusiness.noInPuts.accountService.exception.UserAlreadyExistsException;
import cphbusiness.noInPuts.accountService.exception.WrongCredentialsException;

public interface UserService {
    UserDTO createAccount(UserDTO userDTO) throws UserAlreadyExistsException;
    UserDTO login(UserDTO userDTO) throws WrongCredentialsException;
}
