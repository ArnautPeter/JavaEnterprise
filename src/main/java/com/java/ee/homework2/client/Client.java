package com.java.ee.homework2.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("localhost", 9999);


        try (Scanner scanner = new Scanner(System.in);
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream())) {

            String msgFromServer;
            while (!"stop".equals(msgFromServer = reader.readLine())) {
                System.out.println("msg from server = " + msgFromServer);
                String serverMsg = scanner.nextLine();
                printWriter.println(serverMsg);
                printWriter.flush();
            }
            System.out.println("server disconnected");
        }
    }


    public String toString() {
        return Thread.currentThread().getName();
    }
}