package cphbusiness.noInPuts.userService.controller;


import cphbusiness.noInPuts.userService.dto.UserDTO;
import cphbusiness.noInPuts.userService.service.JwtService;
import cphbusiness.noInPuts.userService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    private final JwtService jwtService;

    @Autowired
    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping(value = "/user/create", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO postUserDTO, @CookieValue("jwt-token") String jwtToken) {
        Long userIdFromToken = jwtService.getUserIdFromToken(jwtToken);

        if(!userIdFromToken.equals(postUserDTO.getId())) {
            return new ResponseEntity<>("{\"error\": \"You are not allowed to create a user with a different id than your own\"}", HttpStatus.FORBIDDEN);
        }

        UserDTO userDTO = userService.createUser(postUserDTO);

        return new ResponseEntity<>(userDTO.toString(), HttpStatus.OK);
    }
}
