package com.java.ee.lesson4.client_manager_system;

public class ClientTask implements Runnable {

    private Client client;

    public ClientTask(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        System.out.println("client: " + client);
    }

    public Client getClient() {
        return client;
    }
}
