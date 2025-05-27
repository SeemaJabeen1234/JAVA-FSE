import java.io.*;
import java.net.*;

public class TcpClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String serverMsg, clientMsg;

            while (true) {
                // Read message from console (client user input)
                System.out.print("Client: ");
                clientMsg = console.readLine();
                out.write(clientMsg + "\n");
                out.flush();

                if ("bye".equalsIgnoreCase(clientMsg))
                    break;

                // Read message from server
                if ((serverMsg = in.readLine()) != null) {
                    System.out.println("Server: " + serverMsg);
                    if ("bye".equalsIgnoreCase(serverMsg))
                        break;
                }
            }

            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
