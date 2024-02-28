package vn.titv.spring.securityjpa.web;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class Register {
    @NotBlank(message = "field force")
    @Size(min=1, message="min length is 1")
    private String username;
    @NotBlank(message = "field force")
    @Size(min=8, message="min length is 8")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).*$",
             message="Password must have one number and one special characteristics")
    private String password;
    @NotBlank(message = "field force")
    private String firstName;
    @NotBlank(message = "field force")
    private String lastName;
    @NotBlank(message = "field force")
    @Email(message="Email is not validated")
    private String email;

    public Register() {
    }

    public Register(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
