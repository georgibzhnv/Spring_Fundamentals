package com.softuni.model.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class UserRegisterBinding {
    private String username;
    private String password;
    private String confirmedPassword;
    private String email;
    private String git;

    public UserRegisterBinding() {
    }
    @NotNull
    @Length(min = 2,message = "Username length must be at least 2 characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @NotNull
    @Length(min = 3,message = "Password length must be at least 3 characters!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @NotNull
    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
    @NotNull
    @Email(message = "Enter valid email address!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+",message = "Enter valid git address!")
    @NotNull
    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }
}
