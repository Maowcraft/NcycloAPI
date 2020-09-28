import maow.ncycloapi.Client;

public class ClientTest {
    public static void main(String[] args) {
        TestReceiver receiver = new TestReceiver();
        Client.getInstance().addReceiver(receiver);
        Client.getInstance().start();
    }
}
