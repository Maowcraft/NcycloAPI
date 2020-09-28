package maow.ncycloapi;

import maow.ncycloapi.util.ExcludeType;

public class Ncyclo {
    public static final int PORT = 63540;
    private static final Server server = Server.getInstance();

    public static void send(String data, ExcludeType excludeType, String[] receiverNames) {
        if (server != null) server.send(data, excludeType, receiverNames);
    }

    public static void send(String data, ExcludeType excludeType) {
        send(data, excludeType, new String[]{});
    }

    public static void send(String data) {
        send(data, ExcludeType.NONE, new String[]{});
    }
}
