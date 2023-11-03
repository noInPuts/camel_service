package cphbusiness.noInPuts.accountService.controller;

import cphbusiness.noInPuts.accountService.dto.AccountDTO;
import cphbusiness.noInPuts.accountService.service.AccountService;
import cphbusiness.noInPuts.accountService.service.JwtService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
public class AccountController {

    private final AccountService accountService;
    private final JwtService jwtService;

    @Autowired
    public AccountController(AccountService accountService, JwtService jwtService) {
        this.accountService = accountService;
        this.jwtService = jwtService;
    }

    @PostMapping(value = "/account/create", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    // TODO: Swagger documentation
    // TODO: Apache Camel + ActiveMQ send message
    // TODO: Spam check
    // TODO: Return with JWT Token
    public ResponseEntity<Map<String, Object>> createAccount(@RequestBody AccountDTO POSTaccountDTO) {
        System.out.println("asdasdasdasd");
        AccountDTO accountDTO = accountService.createAccount(POSTaccountDTO);
        String jwtToken = jwtService.generateToken(accountDTO);

        Map<String, Object> response = new HashMap<>();
        response.put("user", accountDTO);
        response.put("jwtToken", jwtToken);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // TODO: Return with JWT Token
    @PostMapping(value = "/account/login", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody AccountDTO POSTaccountDTO) {
        return "login";
    }
}
