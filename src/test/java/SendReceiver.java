import maow.ncycloapi.api.NcycloReceiver;

public class SendReceiver implements NcycloReceiver {
    @Override
    public String getId() {
        return "SENDING:RECEIVER";
    }

    @Override
    public void onRegister() {
        System.out.println("Registered SEND RECEIVER.");
    }

    @Override
    public void onReceive(Object data) {
        Sending.incoming.add(data);
    }
}
