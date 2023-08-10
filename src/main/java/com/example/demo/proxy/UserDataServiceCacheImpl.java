package com.example.demo.proxy;

public class UserDataServiceCacheImpl implements UserDataService {
    private static UserDataService userDataService;
    private UserData userData;

    @Override
    public UserData getUserData() {
        if (userData == null) {
            userDataService = new UserDataServiceImpl();
            userData = userDataService.getUserData();
        }
        return userData;
    }
}
