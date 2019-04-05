package chapter1;

import java.net.InetAddress;

public class IPaddresses {
    public static void main(String[] args) throws Exception {

        printAddressDetails("www.yahoo.com");

        // Print the loopback address details
        printAddressDetails(null);

        // Print the loopback address details using IPv6 format
        printAddressDetails("::1");
    }

    public static void printAddressDetails(String host) throws Exception {
        System.out.println("Host '" + host + "' details starts...");
        InetAddress addr = InetAddress.getByName(host);
        System.out.println("Host  IP  Address: " + addr.getHostAddress());
        System.out.println("Canonical  Host  Name: "
                + addr.getCanonicalHostName());

        int timeOutinMillis = 10000;
        System.out.println("isReachable(): "
                + addr.isReachable(timeOutinMillis));
        System.out.println("isLoopbackAddress(): " + addr.isLoopbackAddress());

    }
}
