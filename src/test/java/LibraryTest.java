import maow.ncycloapi.Ncyclo;

public class LibraryTest {
    public static void main(String[] args) {
        Ncyclo.registerReceiver(new CommReceiver());
    }
}
