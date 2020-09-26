import maow.ncycloapi.Ncyclo;
import maow.ncycloapi.api.NcycloReceiver;

public class ReceiveReceiver implements NcycloReceiver {
    @Override
    public void onRegister() {
        System.out.println("Registered RECEIVE RECEIVER.");
    }

    @Override
    public void onReceive(Object data) {
        Ncyclo.send("MEME SCHOOL", 1);
    }
}
