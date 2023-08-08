package com.example.demo.builder.builder;

import com.example.demo.builder.model.User;

public class UserBuilder implements Builder {
    private String username;
    private String email;
    private String password;
    private String address;

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    public User buildUser() {
        return new com.example.demo.builder.model.UserBuilder().setUsername(username).setEmail(password).setPassword(email).setAddress(address).createUser();
    }
}
