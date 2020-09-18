package maow.ncycloapi.bridge;

import maow.ncycloapi.api.NcycloReceiver;

public class Bridge {
    private final Object data;
    private int totalSent = 0;

    public Bridge(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void send(NcycloReceiver receiver, int maximumTransfers) {
        if (maximumTransfers != 0 && totalSent >= maximumTransfers) return;
        receiver.receive(this);
        totalSent++;
    }
}
