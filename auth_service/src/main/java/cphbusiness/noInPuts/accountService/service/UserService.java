package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.UserDTO;
import cphbusiness.noInPuts.accountService.exception.UserAlreadyExistsException;
import cphbusiness.noInPuts.accountService.exception.WeakPasswordException;
import cphbusiness.noInPuts.accountService.exception.WrongCredentialsException;

public interface UserService {
    UserDTO createUser(UserDTO userDTO) throws UserAlreadyExistsException, WeakPasswordException;
    UserDTO login(UserDTO userDTO) throws WrongCredentialsException;
}
