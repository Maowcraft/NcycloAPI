package maow.ncycloapi;

import maow.ncycloapi.api.NcycloReceiver;
import maow.ncycloapi.bridge.Bridge;
import maow.ncycloapi.exception.ReceiverException;

import java.util.ArrayList;
import java.util.List;

public class Ncyclo {
    private static final List<NcycloReceiver> receivers = new ArrayList<>();

    public static void registerReceiver(NcycloReceiver receiver) {
        if (!receivers.contains(receiver)) {
            receivers.add(receiver);
            receiver.onRegister();
        } else {
            try {
                throw new ReceiverException.AlreadyRegistered("Receiver " + receiver.toString() + " already registered.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static List<NcycloReceiver> getReceivers() {
        return receivers;
    }

    public static void send(Object data, int maximumTransfers, String id) {
        Bridge bridge = new Bridge(data);
        for (NcycloReceiver receiver : Ncyclo.getReceivers()) {
            if (!receiver.getId().equals(id) || id.equals("")) {
                bridge.send(receiver, maximumTransfers);
            }
        }
    }

    public static void send(Object data, String id) {
        send(data, 0, id);
    }

    public static void send(Object data, int maximumTransfers) {
        send(data, maximumTransfers, "");
    }

    public static void send(Object data) {
        send(data, 0);
    }
}
