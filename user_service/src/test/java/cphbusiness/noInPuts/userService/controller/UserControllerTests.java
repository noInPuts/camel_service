package cphbusiness.noInPuts.userService.controller;

import cphbusiness.noInPuts.userService.dto.UserDTO;
import cphbusiness.noInPuts.userService.service.JwtService;
import cphbusiness.noInPuts.userService.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import net.datafaker.Faker;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private JwtService jwtService;

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

        // Mocking the userService.createUser method to return a UserDTO object
        UserDTO userMockObject = new UserDTO(Long.parseLong(jsonRequestMap.get("id").toString()), jsonRequestMap.get("name").toString(), jsonRequestMap.get("email").toString(), jsonRequestMap.get("phoneNumber").toString(), jsonRequestMap.get("address").toString());
        when(userService.createUser(any(UserDTO.class))).thenReturn(userMockObject);
        when(jwtService.getUserIdFromToken(any(String.class))).thenReturn(1L);

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

        MvcResult result = this.mockMvc.perform(post("/user/create").content(jsonRequestData).contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").cookie(cookie))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(result.getResponse().getContentAsString(), userMockObject.toString());
    }

    @Test
    public void createUserShouldReturn400BadRequestWhenParsingBadRequest() throws Exception {
        this.mockMvc.perform(post("/user/create").content("{ \"password\": \"Password1!\" }").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createUserShouldReturn415UnsupportedeMediaTypeWhenParsingInvalidJson() throws Exception {
        this.mockMvc.perform(post("/user/create").content("not json").characterEncoding("UTF-8"))
                .andExpect(status().isUnsupportedMediaType());
    }
}
