package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.UserDTO;

public interface JwtService {
    String generateToken(UserDTO userDTO);
}
