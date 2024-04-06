import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started on port 12345. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            
            // Receive amount from client
            double amount = dis.readDouble();
            System.out.println("Received amount from client: $" + amount);

            dis.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}