package com.example.demo.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ThreadPoolService {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        System.out.println(LocalDateTime.now());
        scheduledExecutorService.scheduleAtFixedRate(() -> {
//                TimeUnit.SECONDS.sleep(1);
            System.out.println("Task - " + Thread.currentThread().getName());
            System.out.println(LocalDateTime.now());
            countDownLatch.countDown();
        }, 2, 1, TimeUnit.SECONDS);
        countDownLatch.await();
        scheduledExecutorService.shutdown();
//        scheduledExecutorService.shutdown();

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                10, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>());
        for (int i = 0; i <= 10; i++) {
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Task " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            TimeUnit.SECONDS.sleep(1);
        }
//        executorService.shutdown();


//        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
//        for (int i = 0; i <= 10; i++) {
//            executorService.submit(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                    System.out.println("Task " + Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            TimeUnit.SECONDS.sleep(1);
//        }
//        executorService.shutdown();
////        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println("Task 1 - " + Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        executorService.submit(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println("Task 2 - " + Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        executorService.submit(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println("Task 3 - " + Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
    }
}
