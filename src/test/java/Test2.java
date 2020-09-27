import maow.ncycloapi.Ncyclo;

public class Test2 {
    public static void main(String[] args) {
        TestReceiver receiver = new TestReceiver();
        receiver.start();
        Ncyclo.send("If this shows up, then the transfer worked.");
        Ncyclo.send("If this shows up, then the multi-transfers worked.");
        Ncyclo.send("If this doesn't show up, then the exclusions worked.", "test:receiver");
    }
}
