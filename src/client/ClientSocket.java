package client;

import server.AppServerSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {

    private Socket socket;
    private boolean exit = false;

    public ClientSocket() throws IOException {
        this.socket = new Socket(AppServerSocket.Host, AppServerSocket.Port);
    }

    public void connect() {
        try {
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            String message;
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Escribe un mensaje:");            // 1. Write
                message = scanner.nextLine();
                outputStream.writeUTF(message);

            } while (!message.equals("e"));
            //String serverMessage = inputStream.readUTF();             // 2. Listen
            outputStream.close();
            inputStream.close();
            //System.out.println(serverMessage);
            socket.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
