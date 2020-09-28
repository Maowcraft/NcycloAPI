import maow.ncycloapi.Ncyclo;
import maow.ncycloapi.util.ExcludeType;

public class ServerTest {
    public static void main(String[] args) {
        Ncyclo.send("If this shows up, then the transfer worked.");
        Ncyclo.send("If this shows up, then the multi-transfers worked.", ExcludeType.NONE);
        Ncyclo.send("If this shows up, then the inclusions worked.", ExcludeType.INCLUDE, new String[]{"test:receiver"});
        Ncyclo.send("If this doesn't up, then the inclusions worked.", ExcludeType.INCLUDE);
        Ncyclo.send("If this doesn't show up, then the exclusions worked.", ExcludeType.EXCLUDE, new String[]{"test:receiver"});
    }
}
