import maow.ncycloapi.Receiver;

public class TestReceiver implements Receiver {
    @Override
    public void onReceive(String data) {
        System.out.println(data);
    }
}
