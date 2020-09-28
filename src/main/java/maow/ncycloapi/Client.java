package maow.ncycloapi;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private final List<Receiver> receivers = new ArrayList<>();

    private static Client instance;

    public static Client getInstance() {
        if (instance == null) {
            instance = new Client();
        }
        return instance;
    }

    private Client() {
    }

    public void addReceiver(Receiver receiver) {
        receivers.add(receiver);
    }
    public void removeReceiver(Receiver receiver) {
        receivers.remove(receiver);
    }
    public List<Receiver> getReceivers() {
        return receivers;
    }

    @SuppressWarnings({"InfiniteLoopStatement", "BusyWait"})
    public void start() {
        while (true) {
            try (Socket socket = new Socket("localhost", Ncyclo.PORT)) {
                InputStream fromServer = socket.getInputStream();
                DataInputStream in = new DataInputStream(fromServer);
                String data = in.readUTF();
                for (Receiver receiver : receivers) {
                    receiver.onReceive(data);
                }
            } catch (IOException e) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
}
