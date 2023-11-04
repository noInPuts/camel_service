package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.AccountDTO;

public interface JwtService {
    String generateToken(AccountDTO accountDTO);
}
