import maow.ncycloapi.Ncyclo;

public class Test {
    public static void main(String[] args) {
        Ncyclo.send("Meme School");
        new TestReceiver().open();

    }
}
