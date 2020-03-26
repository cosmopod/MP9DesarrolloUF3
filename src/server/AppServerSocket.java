package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class AppServerSocket {
    public static final int Port = 9876;
    public static final String Host = "localhost";

    private ServerSocket serverSocket;
    private Socket client;

    public AppServerSocket() throws IOException {
        serverSocket = new ServerSocket(Port);
        client = new Socket();
        System.out.println("Server Started");
    }

    public void connect() throws IOException {

        while (true) {

            client = serverSocket.accept();

            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

            String clientMessage = "";
            try {
                while (!(clientMessage = inputStream.readUTF()).isEmpty())
                    System.out.println(clientMessage); //1. Listen

            } catch (EOFException e) {

            }
            System.out.println(clientMessage);     //2. Write
            outputStream.writeUTF("Hello world from server");

            if (clientMessage.equals("e")) client.close();
            System.out.println("Client disconnect");
        }

    }
}
