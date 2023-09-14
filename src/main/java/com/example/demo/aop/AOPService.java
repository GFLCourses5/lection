package com.example.demo.aop;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AOPService {

    public void testService(String message) throws Exception {
        TimeUnit.SECONDS.sleep(2);
        throw new Exception("Test Exception");
    }

    public void testService(String message, Integer qwe) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    public void testService(String message, Boolean test) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }
}
