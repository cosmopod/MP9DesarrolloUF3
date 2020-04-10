package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        AppServerSocket appServerSocket = new AppServerSocket();

        while (true) {

            appServerSocket.Accept();

            DataInputStream inputStream = new DataInputStream(appServerSocket.clientSocket().getInputStream());
            DataOutputStream outputStream = new DataOutputStream(appServerSocket.clientSocket().getOutputStream());

            outputStream.writeUTF("Cual es tu nombre?"); // 1. Pregunta nombre cliente
            String username = inputStream.readUTF(); // 4. recibe nombre usuario
            System.out.println("Bienvenido: " +  username);
            outputStream.writeUTF("Cuantas tareas has de realizar " + username + " ?"); // 5. pregunta el numero de tareas


            //appServerSocket.clientSocket().close();
        }
    }
}
