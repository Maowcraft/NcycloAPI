package maow.ncycloapi.api;

import maow.ncycloapi.bridge.Bridge;

public interface NcycloReceiver {
    default void onRegister() {}

    default void receive(Bridge bridge) {
        this.onReceive(bridge.getData());
    }

    void onReceive(Object data);
}
