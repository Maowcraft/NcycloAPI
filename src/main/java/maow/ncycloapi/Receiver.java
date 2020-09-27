package maow.ncycloapi;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public interface Receiver {
    default void open() {
        try {
            Socket client = new Socket("localhost", 63540);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            onReceive(in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void onReceive(String data);
}
