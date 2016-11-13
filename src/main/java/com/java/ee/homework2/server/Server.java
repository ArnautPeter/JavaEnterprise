package com.java.ee.homework2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new ServerCustomSocket(clientSocket)).start();
        }
    }

    public static class ServerCustomSocket implements Runnable {

        private Socket clientSocket;

        public ServerCustomSocket(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {

            try {

                Scanner scanner = new Scanner(System.in);
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
                printWriter.println("hello from server");
                printWriter.flush();
                String msgFromClient;
                while (!"stop".equals(msgFromClient = reader.readLine())) {
                    System.out.println("msg from client" + clientSocket.toString() + " = " + msgFromClient);
                    String serverMsg = "MSG FROM SERVER " + msgFromClient;
                    printWriter.println(serverMsg);
                    printWriter.flush();
                }
                printWriter.println("stop");
                printWriter.flush();
                System.out.println("client disconnected");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}