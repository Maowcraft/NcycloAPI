package maow.ncycloapi.server;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class ServerThread extends Thread {
    private final Socket socket;
    private final String data;
    private final String[] exclusions;

    public ServerThread(Socket socket, String data, String[] exclusions) {
        this.socket = socket;
        this.data = data;
        this.exclusions = exclusions;
    }

    @Override
    public void run() {
        try {
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
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
