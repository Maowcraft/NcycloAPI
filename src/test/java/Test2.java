import maow.ncycloapi.Ncyclo;

public class Test2 {
    public static void main(String[] args) {
        Ncyclo.send("If this shows up, then the transfer worked.");
        Ncyclo.send("If this shows up, then the transfer worked.");
        Ncyclo.send("If this doesn't show up, then the exclusions worked.", "test:receiver");
    }
}
