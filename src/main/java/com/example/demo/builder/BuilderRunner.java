package com.example.demo.builder;

import com.example.demo.builder.builder.PremiumUserBuilder;
import com.example.demo.builder.builder.UserBuilder;
import com.example.demo.builder.director.Director;
import com.example.demo.builder.model.PremiumUser;
import com.example.demo.builder.model.User;

public class BuilderRunner {
    public static void main(String[] args) {
        Director director = new Director();

        UserBuilder userBuilder = new UserBuilder();
        director.createDefaultUser(userBuilder);
        User user = userBuilder.buildUser();

        System.out.printf("Default build user - " + user.getUsername() + "\n");

        PremiumUserBuilder premiumUserBuilder = new PremiumUserBuilder();
        director.createAdminUser(premiumUserBuilder);
        PremiumUser premiumUser = premiumUserBuilder.buildUser();

        System.out.printf("Premium build user - " + premiumUser.print());
    }
}
