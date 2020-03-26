package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ClientSocket clientSocket = new ClientSocket();
        try {
            DataInputStream inputStream = new DataInputStream(clientSocket.getSocket().getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getSocket().getOutputStream());
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
            clientSocket.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
