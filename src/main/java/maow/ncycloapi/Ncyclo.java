package maow.ncycloapi;

import maow.ncycloapi.util.ExcludeType;

public class Ncyclo {
    public static final int PORT = 63540;
    private static final Server server = Server.getInstance();

    @Deprecated
    public static void send(String data, ExcludeType excludeType, String[] receiverNames) {
        if (server != null) server.send(data);
    }

    @Deprecated
    public static void send(String data, ExcludeType excludeType) {
        send(data, ExcludeType.NONE, new String[]{});
    }

    @Deprecated
    public static void send(String data) {
        send(data, ExcludeType.NONE);
    }
}
