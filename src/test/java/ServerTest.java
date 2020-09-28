import maow.ncycloapi.Server;

public class ServerTest {
    public static void main(String[] args) {
        Server.getInstance().send("If this shows up, then the transfer worked.");
        Server.getInstance().send("If this shows up, then the multi-transfers worked.");
    }
}
