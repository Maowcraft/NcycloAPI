package maow.ncycloapi;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Bridge extends Thread {
    private final ServerSocket serverSocket;
    private final String data;

    public Bridge(String data) throws IOException {
        this.data = data;
        this.serverSocket = new ServerSocket(63540);
        this.serverSocket.setSoTimeout(10000);
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                Socket server = serverSocket.accept();
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF(data);
                server.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}