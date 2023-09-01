package com.example.demo.pubsub;

public class Subscriber {

    public Subscriber(Topic... topics) {
        for (Topic t : topics) {
            Server.getInstance().registerSubscriber(this, t);
        }
    }

    public void receivedMessage(Topic topic, Message message) {
        switch (topic) {
            case INFO:
                System.out.println("Info topic - " + message.getMessage());
                break;
            case WARNING:
                System.out.println("Warning topic - " + message.getMessage());
                break;
            case ERROR:
                System.out.println("Error topic - " + message.getMessage());
                break;
        }
    }
}
