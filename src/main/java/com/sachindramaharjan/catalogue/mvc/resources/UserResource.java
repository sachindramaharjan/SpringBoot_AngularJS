package com.sachindramaharjan.catalogue.mvc.resources;

import com.sachindramaharjan.catalogue.core.entity.User;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by sachindra.maharjan on 4/13/16.
 */
public class UserResource extends ResourceSupport{

    private String username;
    private String password;
    private boolean loginSuccess;
    private String message;

    public UserResource(){}

    public UserResource(String username, String password, boolean loginSuccess, String message) {
        this.username       = username;
        this.password       = password;
        this.loginSuccess   = loginSuccess;
        this.message        = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public User toUser(){
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        return user;
    }
}
