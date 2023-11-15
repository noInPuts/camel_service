package cphbusiness.noInPuts.userService.controller;


import cphbusiness.noInPuts.dto.UserDTO;
import cphbusiness.noInPuts.userService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user/create", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO postUserDTO) {
        UserDTO userDTO = userService.createUser(postUserDTO);

        return new ResponseEntity<>(userDTO.toString(), HttpStatus.OK);
    }
}
