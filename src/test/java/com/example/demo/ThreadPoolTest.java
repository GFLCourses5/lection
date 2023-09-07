package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadPoolTest {

    public void singleThreadPool() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(executorService.getCorePoolSize());
        System.out.println(executorService.getQueue().size());
        assertEquals(1, executorService.getPoolSize());
    }

    @Test
    public void fixedThreadPool() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("CorePoolSize - " + executorService.getCorePoolSize());
        System.out.println("Queue size - " + executorService.getQueue().size());
        assertEquals(2, executorService.getPoolSize());
    }

    @Test
    public void cashedThreadPool() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i <= 100; i++) {
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        System.out.println("CorePoolSize - " + executorService.getCorePoolSize());
        System.out.println("PoolSize - " + executorService.getPoolSize());
        System.out.println("Queue size - " + executorService.getQueue().size());
        assertEquals(101, executorService.getPoolSize());
    }

    @Test
    public void scheduleThreadPool() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(() -> {try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }}, 2,1,TimeUnit.SECONDS);
    }
}
