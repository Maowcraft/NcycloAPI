package maow.ncycloapi;

import java.io.*;
import java.net.Socket;

public interface Receiver {
    String getReceiverName();

    default void start() {
        Thread thread = new Thread(() -> {
            while (true) {
                try (Socket clientSocket = new Socket("localhost", Ncyclo.PORT)) {
                    OutputStream toServer = clientSocket.getOutputStream();
                    InputStream fromServer = clientSocket.getInputStream();
                    DataOutputStream out = new DataOutputStream(toServer);
                    DataInputStream in = new DataInputStream(fromServer);
                    out.writeUTF(getReceiverName());
                    String data = in.readUTF();
                    if (!data.equals("ncyclo:server:exclusion_found")) onReceive(data);
                } catch (IOException e) {
                    try {
                        //noinspection BusyWait
                        Thread.sleep(5000);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    void onReceive(String data);
}
