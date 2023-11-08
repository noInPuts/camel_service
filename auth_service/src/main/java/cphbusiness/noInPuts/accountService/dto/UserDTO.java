package cphbusiness.noInPuts.accountService.dto;

import jakarta.validation.constraints.NotBlank;

public class UserDTO {
    private int id;
    @NotBlank(message = "Username is mandatory")
    private String username;


    @NotBlank(message = "Password is mandatory")
    private String password;

    public UserDTO() {
    }

    public UserDTO(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }
}
