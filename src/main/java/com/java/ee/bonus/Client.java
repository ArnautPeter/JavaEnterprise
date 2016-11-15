package com.java.ee.bonus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client implements Runnable {

    private ExecutorService service = Executors.newFixedThreadPool(1);
    private int count;

    Client(int count) {
        this.count = count;
    }

    @Override
    public void run() {

        for (int i = 0; i < count; i++) {
            System.out.println(toString());
            service.submit(new Task());
        }
        notifyAll();
    }
}
