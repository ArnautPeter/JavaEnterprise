package com.java.ee.bonus;

public class Task implements Runnable {

    @Override
    public void run() {

        System.out.println("Start task ");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End task ");
    }
}
