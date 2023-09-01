package com.example.demo.pubsub;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Server {
    private Hashtable<Topic, List<Subscriber>> subscriberHashtable;
    private static Server server;

    private Server() {
        this.subscriberHashtable = new Hashtable<>();
    }

    public static Server getInstance() {
        if (server == null) {
            server = new Server();
        }
        return server;
    }

    public void registerSubscriber(Subscriber subscriber, Topic topic) {
        if (!subscriberHashtable.containsKey(topic)) {
            ArrayList<Subscriber> subscribers = new ArrayList<>();
            subscribers.add(subscriber);
            subscriberHashtable.put(topic, subscribers);
        } else {
            subscriberHashtable.get(topic).add(subscriber);
        }
    }

    public void sendMessage(Topic topic, Message message) {
        List<Subscriber> subscribers = subscriberHashtable.get(topic);
        for (Subscriber s : subscribers) {
            s.receivedMessage(topic, message);
        }
    }
}
