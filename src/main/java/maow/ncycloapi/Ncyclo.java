package maow.ncycloapi;

public class Ncyclo {
    public static final int PORT = 63540;
    private static Server server;

    public static void send(String data, String... exclusions) {
        if (server == null) {
            server = new Server();
        }
        server.send(data, exclusions);
    }
}
