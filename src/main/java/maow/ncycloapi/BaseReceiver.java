package maow.ncycloapi;

public interface BaseReceiver {
    String getReceiverName();

    void start();

    void end();

    void onReceive(String data);
}
