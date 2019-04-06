package chapter1;

import java.net.InetSocketAddress;

public class SocketAddress {

    public static void main(String[] args) {
        InetSocketAddress addr1 = new InetSocketAddress("::1", 12345);
        printSocketAddress(addr1);

        InetSocketAddress addr2 = InetSocketAddress.createUnresolved("::1", 12881);
        printSocketAddress(addr2);
    }

    public static void printSocketAddress(InetSocketAddress sAddr) {
        System.out.println("Socket  Address: " + sAddr.getAddress());
        System.out.println("Socket Host  Name: " + sAddr.getHostName());
        System.out.println("Socket Port:  " + sAddr.getPort());
        System.out.println("isUnresolved(): " + sAddr.isUnresolved());
        System.out.println();
    }
}
