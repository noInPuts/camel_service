package cphbusiness.noInPuts.apache_camel.service;

public interface JwtService {
    String tokenGenerator(Long id, String username, String role);
}
