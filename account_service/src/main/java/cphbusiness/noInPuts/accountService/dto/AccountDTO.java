package cphbusiness.noInPuts.accountService.dto;

import java.util.HashMap;

public class AccountDTO {
    private int id;
    private String username;
    private String password;

    public AccountDTO() {
    }

    public AccountDTO(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public AccountDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
