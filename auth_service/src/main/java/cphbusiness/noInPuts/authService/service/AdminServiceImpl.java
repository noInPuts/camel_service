package cphbusiness.noInPuts.authService.service;

import cphbusiness.noInPuts.authService.dto.AdminDTO;
import cphbusiness.noInPuts.authService.exception.UserDoesNotExistException;
import cphbusiness.noInPuts.authService.exception.WrongCredentialsException;
import cphbusiness.noInPuts.authService.model.Admin;
import cphbusiness.noInPuts.authService.repository.AdminRepository;
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
