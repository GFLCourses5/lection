package com.example.demo.pubsub;

public class Application {
    public static void main(String[] args) {
        new Subscriber(Topic.INFO, Topic.WARNING);
        new Subscriber(Topic.WARNING);
        new Subscriber(Topic.ERROR, Topic.INFO);

        Publisher infoPublisher = new Publisher(Topic.INFO);
        Publisher warningPublisher = new Publisher(Topic.WARNING);
        Publisher errorPublisher = new Publisher(Topic.ERROR);

        infoPublisher.sendMessage(new Message("First message"));
        warningPublisher.sendMessage(new Message("Second message"));
        errorPublisher.sendMessage(new Message("Third message"));
        errorPublisher.sendMessage(new Message("Test message"));
    }
}
