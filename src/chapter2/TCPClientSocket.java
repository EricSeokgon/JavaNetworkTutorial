package chapter2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPClientSocket {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12900);
        System.out.println("Started client  socket at "
                + socket.getLocalSocketAddress());
        BufferedReader socketReader = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(
                socket.getOutputStream()));
        BufferedReader consoleReader = new BufferedReader(
                new InputStreamReader(System.in));

        String promptMsg = "Please enter a  message  (Bye  to quit):";
        String outMsg = null;

        System.out.print(promptMsg);
        while ((outMsg = consoleReader.readLine()) != null) {
            if (outMsg.equalsIgnoreCase("bye")) {
                break;
            }
            // Add a new line to the message to the server,
            // because the server reads one line at a time.
            socketWriter.write(outMsg);
            socketWriter.write("\n");
            socketWriter.flush();

            // Read and display the message from the server
            String inMsg = socketReader.readLine();
            System.out.println("Server: " + inMsg);
            System.out.println(); // Print a blank line
            System.out.print(promptMsg);
        }
        socket.close();
    }
}
