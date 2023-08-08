package com.example.demo.builder.director;

import com.example.demo.builder.builder.Builder;
import com.example.demo.builder.model.User;

public class Director {

    public void createDefaultUser(Builder builder) {
        builder.setUsername("Default username");
        builder.setEmail("Default email");
        builder.setPassword("Default password");
        builder.setAddress("Default address");
    }

    public void createUser(Builder builder) {
        builder.setUsername("username");
        builder.setEmail("email");
        builder.setPassword("password");
        builder.setAddress("address");
    }

    public void createAdminUser(Builder builder) {
        builder.setUsername("Admin username");
        builder.setEmail("Admin email");
        builder.setPassword("Admin password");
        builder.setAddress("Admin address");
    }
}
