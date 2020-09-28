import maow.ncycloapi.Receiver;

public class TestReceiver implements Receiver {
    @Override
    public String getName() {
        return "test:receiver";
    }

    @Override
    public void onReceive(String data) {
        System.out.println("Received data: " + data);
    }
}
