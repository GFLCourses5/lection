package com.example.demo.proxy;


public class UserDataApplication {
    public static void main(String[] args) {
        UserDataServiceImpl userDataService = new UserDataServiceImpl();
        UserData userData1 = userDataService.getUserData();
        UserData userData2 = userDataService.getUserData();

        UserDataServiceCacheImpl userDataServiceCache = new UserDataServiceCacheImpl();
        UserData cacheUser1 = userDataServiceCache.getUserData();
        UserData cacheUser2 = userDataServiceCache.getUserData();

        System.out.println(userData1);
        System.out.println(userData2);
        System.out.println(cacheUser1);
        System.out.println(cacheUser2);
    }
}
