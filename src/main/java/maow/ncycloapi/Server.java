package maow.ncycloapi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    private static Server instance;

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    private Server() {
        try {
            serverSocket = new ServerSocket(Ncyclo.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String data) {
        if (serverSocket != null) {
            try (Socket socket = serverSocket.accept()) {
                OutputStream toClient = socket.getOutputStream();
                DataOutputStream out = new DataOutputStream(toClient);
                out.writeUTF(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}