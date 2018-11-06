package com.mc.thinking.java;

import java.util.List;

public class PasswordUtils {
    @UserCase(id=47,description = "password must contain at least one numeric")
    public boolean validatePassword(String password){
        return password.matches("\\w*\\d\\w*");
    }
    @UserCase(id=48)
    public String encrptPawword(String password){
        return new StringBuilder(password).reverse().toString();
    }
    @UserCase(id=49,description = "New Passowrd can't equals previously used ones")
    public boolean checkForNewPassword(List<String> prevPassword, String password){
        return !prevPassword.contains(password);
    }
}
