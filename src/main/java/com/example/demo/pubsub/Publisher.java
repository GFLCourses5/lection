package com.example.demo.pubsub;

public class Publisher {

    private Topic topic;

    public Publisher(Topic topic) {
        this.topic = topic;
    }

    public void sendMessage(Message message) {
        Server.getInstance().sendMessage(topic, message);
    }
}
