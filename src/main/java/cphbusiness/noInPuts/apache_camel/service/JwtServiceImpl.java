package cphbusiness.noInPuts.apache_camel.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;


@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String pKey;

    public String tokenGenerator(Long id, String username, String role) {
        // Generate a secret key from the pKey
        SecretKey key = Keys.hmacShaKeyFor(pKey.getBytes());

        // Generate a jwt token with the secret key
        return Jwts.builder()
                .header()
                .add("id", id)
                .add("username", username)
                .add("role", role)
                .and()
                .issuedAt(new Date(System.currentTimeMillis()))
                // Expires after 2 days of issue
                .expiration(new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000))
                .signWith(key)
                .compact();
    }

}
