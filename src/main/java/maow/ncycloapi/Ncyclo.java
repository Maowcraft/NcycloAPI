package maow.ncycloapi;

import maow.ncycloapi.server.Server;

public class Ncyclo {
    public static final int PORT = 63540;
    private static Server server;

    public static void init() {
        new Thread(() -> {
            server = new Server();
            server.start();
        }).start();
    }

    public static void send(String data, String... exclusions) {
        boolean unsent = true;
        while (unsent) {
            try {
                server.send(data, exclusions);
                unsent = false;
            } catch (NullPointerException e) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }

    public static Server getServer() {
        return server;
    }
}