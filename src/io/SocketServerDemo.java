package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("连接成功"+clientSocket.getRemoteSocketAddress());
            new Thread(() -> process(clientSocket)).start();
        }
    }
    private static void process(Socket socket) {
        System.out.println("内容为:");
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF8"))) {
            String s;
            while ((s = bf.readLine()) != null) {
                System.out.println(s);
            }
            socket.close();
            System.out.println("连接断开"+socket.getRemoteSocketAddress());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
