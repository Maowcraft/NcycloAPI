package maow.ncycloapi;

import java.io.*;
import java.net.Socket;

public abstract class Receiver implements BaseReceiver {
    private boolean alive = true;

    @Override
    public void start() {
        Thread thread = new Thread(() -> {
            while (alive) {
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

    @Override
    public void end() {
        alive = false;
    }
}
