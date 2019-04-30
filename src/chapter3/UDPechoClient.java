package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPechoClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket udpSocket = new DatagramSocket();
        String msg = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter a  message  (Bye  to quit):");
        while ((msg = br.readLine()) != null) {
            if (msg.equalsIgnoreCase("bye")) {
                break;
            }
            DatagramPacket packet = UDPechoClient.getPacket(msg);
            udpSocket.send(packet);
            udpSocket.receive(packet);
            displayPacketDetails(packet);
            System.out.print("Please enter a  message  (Bye  to quit):");
        }
        udpSocket.close();
    }

    public static void displayPacketDetails(DatagramPacket packet) {
        byte[] msgBuffer = packet.getData();
        int length = packet.getLength();
        int offset = packet.getOffset();
        int remotePort = packet.getPort();
        InetAddress remoteAddr = packet.getAddress();
        String msg = new String(msgBuffer, offset, length);
        System.out.println("[Server at IP  Address=" + remoteAddr + ", port="
                + remotePort + "]: " + msg);
    }

    public static DatagramPacket getPacket(String msg) throws UnknownHostException {
        int PACKET_MAX_LENGTH = 1024;
        byte[] msgBuffer = msg.getBytes();

        int length = msgBuffer.length;
        if (length > PACKET_MAX_LENGTH) {
            length = PACKET_MAX_LENGTH;
        }
        DatagramPacket packet = new DatagramPacket(msgBuffer, length);
        InetAddress serverIPAddress = InetAddress.getByName("localhost");
        packet.setAddress(serverIPAddress);
        packet.setPort(15900);
        return packet;

    }
}
