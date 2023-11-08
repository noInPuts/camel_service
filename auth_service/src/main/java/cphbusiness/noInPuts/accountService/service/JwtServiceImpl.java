package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.UserDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

// TODO: Comments/Documentation
@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String pKey;

    // TODO: Generate test for this
    @Override
    public String generateToken(UserDTO userDTO) {
        SecretKey key = Keys.hmacShaKeyFor(pKey.getBytes());

        return Jwts.builder()
                .header()
                .add("id", userDTO.getId())
                .add("username", userDTO.getUsername())
                .and()
                .issuedAt(new Date(System.currentTimeMillis()))
                // Expires after 2 days of issue
                .expiration(new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000))
                .signWith(key)
                .compact();
    }
}
