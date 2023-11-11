package cphbusiness.noInPuts.authService.service;

public interface JwtService {
    String tokenGenerator(Long id, String username, String role);
}
