package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.AdminDTO;
import cphbusiness.noInPuts.accountService.exception.UserDoesNotExistException;
import cphbusiness.noInPuts.accountService.exception.WrongCredentialsException;

public interface AdminService {
    AdminDTO login(AdminDTO adminDTO) throws WrongCredentialsException, UserDoesNotExistException;
}
