package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        AppServerSocket appServerSocket = new AppServerSocket();

        while (true){

            while (true) {

                appServerSocket.Accept();

                DataInputStream inputStream = new DataInputStream(appServerSocket.clientSocket().getInputStream());
                DataOutputStream outputStream = new DataOutputStream(appServerSocket.clientSocket().getOutputStream());

                String clientMessage = "";
                try {
                    while (!(clientMessage = inputStream.readUTF()).isEmpty())
                        System.out.println(clientMessage); //1. Listen

                } catch (EOFException e) {

                }
                System.out.println(clientMessage);     //2. Write
                outputStream.writeUTF("Hello world from server");

                if (clientMessage.equals("e")) appServerSocket.clientSocket().close();
                System.out.println("Client disconnect");
            }
        }

    }
}
