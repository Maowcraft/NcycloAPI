package maow.ncycloapi;

public interface Receiver {
    String getName();

    void onReceive(String data);
}
