package com.example.demo.interupt;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class HandleInterrupt {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdlMainExecution = new CountDownLatch(1);
        CountDownLatch cdlToAwait = new CountDownLatch(3);

        Runnable runnable = () -> {
            System.out.println("Interrupt status - " + Thread.currentThread().isInterrupted());
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("Do piece of work - " + i++);
                    cdlToAwait.countDown();
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    System.out.println("Interrupt status before - " + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("Interrupt status after - " + Thread.currentThread().isInterrupted());
                }
            }
            cdlMainExecution.countDown();
        };

        Thread thread = new Thread(runnable);
        thread.start();
        cdlToAwait.await();
        thread.interrupt();
        cdlMainExecution.await();
        System.out.println("Application completed");
    }
}
