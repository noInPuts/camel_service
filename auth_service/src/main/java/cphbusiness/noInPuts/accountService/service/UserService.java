package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.UserDTO;

public interface UserService {
    UserDTO createAccount(UserDTO userDTO);
    UserDTO login(UserDTO userDTO);
}
