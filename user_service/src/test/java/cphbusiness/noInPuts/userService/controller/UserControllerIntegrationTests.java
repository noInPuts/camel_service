package cphbusiness.noInPuts.userService.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import net.datafaker.Faker;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Value("${jwt.secret}")
    private String pKey;

    @Test
    public void createUser() throws Exception {
        // Creating faker object
        Faker faker = new Faker();

        // Creating a map with the data we want to send in the request
        Map<String, Object> jsonRequestMap = new HashMap<>();
        jsonRequestMap.put("username", "my_test_user");
        jsonRequestMap.put("id", 1L);
        jsonRequestMap.put("name", faker.name().fullName());
        jsonRequestMap.put("address", faker.address().fullAddress());
        jsonRequestMap.put("phoneNumber", faker.phoneNumber().cellPhone());
        jsonRequestMap.put("email", faker.internet().emailAddress());

        // Converting the map to a JSON object
        JSONObject jsonObject = new JSONObject(jsonRequestMap);
        String jsonRequestData = jsonObject.toString();

        // Creating a cookie with a jwt token
        SecretKey key = Keys.hmacShaKeyFor(pKey.getBytes());
        String jwtToken = Jwts.builder()
                .header()
                .add("id", 1L)
                .add("username", "user")
                .add("role", "admin")
                .and()
                .issuedAt(new Date(System.currentTimeMillis()))
                // Expires after 2 days of issue
                .expiration(new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000))
                .signWith(key)
                .compact();
        Cookie cookie = new Cookie("jwt-token", jwtToken);

        this.mockMvc.perform(post("/user/create").content(jsonRequestData).contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").cookie(cookie))
                .andExpect(status().isOk());
    }

}
