package com.java.ee.lesson2.consumer_produser2;

import java.util.concurrent.BlockingQueue;

public class Server extends Thread {
    private BlockingQueue<Integer> bucket;

    public Server(BlockingQueue bucket) {
        this.bucket = bucket;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                bucket.put(i);
                System.out.println("server: " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}