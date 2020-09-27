package maow.ncycloapi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    public void send(String data, String... exclusions) {
        try (ServerSocket serverSocket = new ServerSocket(Ncyclo.PORT)) {
            Socket socket = serverSocket.accept();
            OutputStream toClient = socket.getOutputStream();
            InputStream fromClient = socket.getInputStream();
            DataOutputStream out = new DataOutputStream(toClient);
            DataInputStream in = new DataInputStream(fromClient);
            String receiverName = in.readUTF();
            if (Arrays.asList(exclusions).contains(receiverName)) {
                out.writeUTF("ncyclo:server:exclusion_found");
            } else {
                out.writeUTF(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}