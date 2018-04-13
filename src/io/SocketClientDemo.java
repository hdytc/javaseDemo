package io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketClientDemo {
    public static void main(String[] args) throws IOException {
        try (
                Socket socket = new Socket("127.0.0.1",9999);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8")))
        {
            bw.write("hahahaha");
            bw.newLine();
            bw.write("fuck you");
            bw.flush();
        }
    }
}
