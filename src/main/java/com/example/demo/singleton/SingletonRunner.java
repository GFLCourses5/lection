package com.example.demo.singleton;

public class SingletonRunner {

    public static void main(String[] args) {
        Thread threadFirst = new Thread(new FirstClass());
        Thread threadSecond = new Thread(new SecondClass());
        threadSecond.start();
        threadFirst.start();
    }

    static class FirstClass implements Runnable {
        @Override
        public void run() {
            Singleton instance = Singleton.getInstance("Test 1");
            System.out.printf(instance.getType());
        }
    }

    static class SecondClass implements Runnable {
        @Override
        public void run() {
            Singleton instance = Singleton.getInstance("Test 2");
            System.out.printf(instance.getType());
        }
    }
}
