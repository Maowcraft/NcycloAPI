import maow.ncycloapi.api.NcycloReceiver;

public class CommReceiver implements NcycloReceiver {
    @Override
    public void onRegister() {
        System.out.println("Registered.");
    }

    @Override
    public void onReceive(Object data) {
        System.out.println(data);
    }
}
