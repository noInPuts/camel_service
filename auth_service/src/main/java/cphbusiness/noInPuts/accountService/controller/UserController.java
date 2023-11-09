package cphbusiness.noInPuts.accountService.controller;

import cphbusiness.noInPuts.accountService.dto.UserDTO;
import cphbusiness.noInPuts.accountService.exception.UserAlreadyExistsException;
import cphbusiness.noInPuts.accountService.exception.WeakPasswordException;
import cphbusiness.noInPuts.accountService.exception.WrongCredentialsException;
import cphbusiness.noInPuts.accountService.service.UserService;
import cphbusiness.noInPuts.accountService.service.JwtService;
import cphbusiness.noInPuts.accountService.service.RabbitMessagePublisher;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    private final RabbitMessagePublisher rabbitMessagePublisher;

    @Autowired
    public UserController(UserService userService, JwtService jwtService, RabbitMessagePublisher rabbitMessagePublisher) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.rabbitMessagePublisher = rabbitMessagePublisher;
    }

    // Endpoint for creating a user account
    @PostMapping(value = "/user/create", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    // TODO: Swagger documentation
    // TODO: Spam check
    public ResponseEntity<Map<String, Object>> createUser(@Valid @RequestBody UserDTO POSTuserDTO) {

        // Catch exception if user already exists else create entity in DB
        UserDTO userDTO;
        try {
            userDTO = userService.createAccount(POSTuserDTO);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (WeakPasswordException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Genereate JWT token for user
        String jwtToken = jwtService.generateToken(userDTO);

        // Send out createdUserEvent to RabbitMQ/Apache Camel
        rabbitMessagePublisher.createdUserEvent("User created: " + userDTO.getUsername());

        // Creates response entity with userDTO and JWT token
        Map<String, Object> response = new HashMap<>();
        response.put("user", userDTO);
        response.put("jwtToken", jwtToken);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Endpoint for logging in to a user account
    @PostMapping(value = "/user/login", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String, Object>> login(@Valid @RequestBody UserDTO POSTuserDTO) {

        // Check for correct credentials
        UserDTO userDTO;
        try {
            userDTO = userService.login(POSTuserDTO);
        } catch (WrongCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        // Generate JWT token for user
        String jwtToken = jwtService.generateToken(userDTO);

        // Creates response entity with userDTO and JWT token
        Map<String,Object> response = new HashMap<>();
        response.put("user", userDTO);
        response.put("jwtToken", jwtToken);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
