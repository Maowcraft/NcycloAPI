import maow.ncycloapi.Client;

public class ClientTest {
    public static void main(String[] args) {
        Client.getInstance().addReceiver(new TestReceiver());
        Client.getInstance().start();
    }
}
