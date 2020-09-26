import maow.ncycloapi.Ncyclo;

public class Receiving {
    public static void main(String[] args) {
        Ncyclo.registerReceiver(new ReceiveReceiver());
    }
}
