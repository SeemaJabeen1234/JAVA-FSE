import java.io.*;
import java.net.*;

public class TcpServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started. Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg, serverMsg;

            while (true) {
                // Read message from client
                if ((clientMsg = in.readLine()) != null) {
                    System.out.println("Client: " + clientMsg);
                    if ("bye".equalsIgnoreCase(clientMsg))
                        break;
                }

                // Read message from console (server user input)
                System.out.print("Server: ");
                serverMsg = console.readLine();
                out.write(serverMsg + "\n");
                out.flush();

                if ("bye".equalsIgnoreCase(serverMsg))
                    break;
            }

            System.out.println("Connection closed.");
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
