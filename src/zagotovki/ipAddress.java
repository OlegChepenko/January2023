package zagotovki;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ipAddress {
    static String ipAddress() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        String ipAddress = "" + ip.getHostAddress();
        return ipAddress;
    }
}
