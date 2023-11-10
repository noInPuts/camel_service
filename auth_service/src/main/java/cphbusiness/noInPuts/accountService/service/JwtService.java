package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.AdminDTO;
import cphbusiness.noInPuts.accountService.dto.UserDTO;

public interface JwtService {
    String tokenGenerator(Long id, String username, String role);
}
