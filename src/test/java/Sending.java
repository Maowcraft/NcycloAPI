import maow.ncycloapi.Ncyclo;

import java.util.ArrayList;
import java.util.Arrays;

public class Sending {
    public static final ArrayList<Object> incoming = new ArrayList<>();

    public static void main(String[] args) {
        String data = "Meme School";
        Ncyclo.send(data, "SENDING:RECEIVER");
        boolean await = true;
        while (await) {
            System.out.println("Awaiting...");
            if (!incoming.isEmpty()) {
                System.out.println("Received.");
                await = false;
            }
        }
        System.out.println(Arrays.toString(incoming.toArray()));
    }
}
