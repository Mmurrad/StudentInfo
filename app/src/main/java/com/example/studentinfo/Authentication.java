package com.example.studentinfo;

public class Authentication {
    String fullname;
    String username;
    String email;
    String password;
    String confirm_password;

    public Authentication() {
    }

    public Authentication(String fullname, String username, String email, String password, String confirm_password) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
}
