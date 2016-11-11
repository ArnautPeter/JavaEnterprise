package com.java.ee.lesson2.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientCustomSocket {
    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("localhost", 9999);

        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
        String msgFromServer;
        while (!"stop".equals(msgFromServer = reader.readLine())) {
            System.out.println("msg from server = " + msgFromServer);
            String serverMsg = scanner.nextLine();
            printWriter.println(serverMsg);
            printWriter.flush();
        }
    }
}