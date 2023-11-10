package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;

@SpringBootTest
public class JwtServiceTests {

    @Autowired
    private JwtService jwtService;

    @Test
    public void generateTokenShouldReturnToken() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA512");
        String mockedPrivateKey = String.valueOf(keyGenerator.generateKey());

        ReflectionTestUtils.setField(jwtService, "pKey", mockedPrivateKey);

        UserDTO userDTO = new UserDTO("test_user", "Password1!");
        String jwtToken = jwtService.tokenGenerator(userDTO.getId(), userDTO.getUsername(), "user");

        assertEquals(String.class, jwtToken.getClass());
    }
}
