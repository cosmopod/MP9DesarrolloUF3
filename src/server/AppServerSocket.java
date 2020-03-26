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
    }

    public void connect() throws IOException {
        System.out.println("Server Started");
        while (true){
            client  = serverSocket.accept();

            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

            outputStream.writeUTF("Welcome client");
            String clientMessage;
            try{
                while (!(clientMessage = inputStream.readUTF()).isEmpty())
                    System.out.println(clientMessage);
            }catch (EOFException e){
                System.out.println("Client has finished");
            }
            System.out.println("Waiting for new client");
        }
    }
}
