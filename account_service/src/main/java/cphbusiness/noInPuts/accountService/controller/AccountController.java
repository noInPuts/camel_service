package cphbusiness.noInPuts.accountService.controller;

import cphbusiness.noInPuts.accountService.dto.AccountDTO;
import cphbusiness.noInPuts.accountService.service.AccountService;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(maxAge = 3600)
@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(value = "/account/create", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    // TODO: Swagger documentation
    // TODO: Apache Camel + ActiveMQ send message
    // TODO: Spam check
    public String createAccount(@RequestBody AccountDTO POSTaccountDTO) {
        AccountDTO accountDTO = accountService.createAccount(POSTaccountDTO);
        JSONObject publicProfileJsonObject = new JSONObject(accountDTO.getPublicProfile());
        return publicProfileJsonObject.toString();
    }
}
