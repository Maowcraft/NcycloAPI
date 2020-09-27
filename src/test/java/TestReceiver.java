import maow.ncycloapi.Receiver;

public class TestReceiver implements Receiver {
    @Override
    public String getReceiverName() {
        return "test:receiver";
    }

    @Override
    public void onReceive(String data) {
        System.out.println("Received data:" + data);
    }
}
