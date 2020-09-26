import maow.ncycloapi.Ncyclo;

public class Sending2 {
    public static void main(String[] args) {
        Ncyclo.registerReceiver(new SendReceiver());
    }
}
