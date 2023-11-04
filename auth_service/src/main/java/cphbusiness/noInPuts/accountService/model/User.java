package cphbusiness.noInPuts.accountService.model;

import jakarta.persistence.*;


@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;
    public User() {
    }

    public User(String username, String password) {
       this.username = username;
       this.password = password;
       this.role = "user";
    }

    public int getId() {
        return this.id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // For testing purposes
    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }
}
