package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.AccountDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateToken(AccountDTO accountDTO);
}
