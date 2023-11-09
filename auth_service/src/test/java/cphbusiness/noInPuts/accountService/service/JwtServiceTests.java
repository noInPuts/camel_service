package cphbusiness.noInPuts.accountService.service;

import cphbusiness.noInPuts.accountService.dto.UserDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JwtServiceTests {

    @Autowired
    private JwtService jwtService;

    @Test
    public void generateTokenShouldReturnToken() {
        UserDTO userDTO = new UserDTO("test_user", "Password1!");
        String jwtToken = jwtService.generateToken(userDTO);

        assertEquals(String.class, jwtToken.getClass());
    }
}
