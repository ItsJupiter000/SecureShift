import java.io.*;
import java.net.*;
import java.util.HashSet;
import java.util.Set;

public class Proxy {
    private static final int PROXY_PORT = 55555; // Choose a port number for the proxy server
    private static final Set<String> ALLOWED_IPS = new HashSet<>(); // List of allowed IP addresses

    static {
        // Add allowed IP addresses
        ALLOWED_IPS.add("127.0.0.1"); // Example IP address
        ALLOWED_IPS.add("192.168.56.1"); //This is client's ip address 
        ALLOWED_IPS.add("192.168.178.81");
    }

    public static void main(String[] args) {
        try (ServerSocket proxyServerSocket = new ServerSocket(PROXY_PORT)) {
            System.out.println("Proxy server started on port " + PROXY_PORT);

            while (true) {
                Socket clientSocket = proxyServerSocket.accept();
                String clientIP = clientSocket.getInetAddress().getHostAddress();

                if (isAllowed(clientIP)) {
                    System.out.println("Client connected: " + clientIP);
                    forwardAmount(clientSocket);
                } else {
                    System.out.println("Blocked client: " + clientIP);
                    // Send refusal message to client
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                    writer.println("Access denied. Your IP is not allowed.");
                    writer.flush();
                    writer.close();
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isAllowed(String ipAddress) {
        return ALLOWED_IPS.contains(ipAddress);
    }

    private static void forwardAmount(Socket clientSocket) {
        try (Socket serverSocket = new Socket("192.168.56.102", 12345)) { // Server's address and port
            InputStream is = clientSocket.getInputStream();
            OutputStream os = serverSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            
            // Forward amount to server
            DataInputStream dis = new DataInputStream(is);
            double amount = dis.readDouble();
            dos.writeDouble(amount);
            
            dis.close();
            dos.close();
            serverSocket.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}