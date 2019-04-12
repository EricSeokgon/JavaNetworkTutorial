package chapter2;

import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class ServerSocketMain {
    public static void main(String[] argv) throws Exception {
        // Create an unbound server socket
        ServerSocket serverSocket = new ServerSocket();

        // Create a socket address object
        InetSocketAddress endPoint = new InetSocketAddress("localhost", 12900);

        // Set the wait queue size to 100
        int waitQueueSize = 100;

        // Bind the server socket to localhost and at port 12900 with
        // a wait queue size of 100
        serverSocket.bind(endPoint, waitQueueSize);

    }
}
