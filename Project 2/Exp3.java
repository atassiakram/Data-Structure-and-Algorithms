import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Exp3 {
    public static void main(String[] args) {
        DBScan linear = new DBScan(args[0],args[1],args[2]);
        DBScanKD kd = new DBScanKD(args[0],args[1],args[2]);
    }
}
