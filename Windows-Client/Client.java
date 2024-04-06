import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.56.102", 55555);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            // Send amount to server
            dos.writeDouble(1000.0); // Example amount
            
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
