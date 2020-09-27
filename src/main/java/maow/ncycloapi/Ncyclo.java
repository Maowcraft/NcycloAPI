package maow.ncycloapi;

import java.io.IOException;

public class Ncyclo {
    public static void send(String data) {
        try {
            Bridge bridge = new Bridge(data);
            bridge.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
