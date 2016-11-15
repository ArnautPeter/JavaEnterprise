package com.java.ee.bonus;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);

        while (true) {
            service.submit(new Client(random()));
        }
    }

    private static int random() {
        Random random = new Random(5);
        return random.nextInt();
    }
}
