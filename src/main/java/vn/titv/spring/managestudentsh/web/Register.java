package vn.titv.spring.managestudentsh.web;

import jakarta.validation.constraints.*;
import vn.titv.spring.managestudentsh.entity.Role;

import java.sql.Date;

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
    private String fullName;
    @NotBlank(message = "field force")
    private Date dateOfBirth;
    @NotBlank(message = "field required")
    private Boolean gender;
    @NotBlank(message = "field force")
    @Email(message="Email is not validated")
    private String email;
    @NotBlank(message = "field force")
    private String role;
    public Register() {
    }

    public Register(String username, String password, String fullName, Date dateOfBirth, Boolean gender, String email,String role) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.role=role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
