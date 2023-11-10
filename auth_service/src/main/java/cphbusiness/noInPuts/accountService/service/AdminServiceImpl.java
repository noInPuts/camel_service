package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.AdminDTO;
import cphbusiness.noInPuts.accountService.exception.UserDoesNotExistException;
import cphbusiness.noInPuts.accountService.exception.WrongCredentialsException;
import cphbusiness.noInPuts.accountService.model.Admin;
import cphbusiness.noInPuts.accountService.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public AdminDTO login(AdminDTO adminDTO) throws WrongCredentialsException, UserDoesNotExistException {
        Optional<Admin> optionalAdminUser =  adminRepository.findByUsername(adminDTO.getUsername());
        if(optionalAdminUser.isPresent()) {
            Admin adminUser = optionalAdminUser.get();
            if(adminUser.getPassword().equals(adminDTO.getPassword())) {
                return new AdminDTO(adminUser.getId(), adminUser.getUsername(), null);
            } else {
                throw new WrongCredentialsException("Wrong password");
            }
        } else {
            throw new UserDoesNotExistException("User does not exist");
        }
    }
}
