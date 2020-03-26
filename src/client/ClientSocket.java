package client;
import server.AppServerSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocket {

    private Socket socket;

    public ClientSocket() throws IOException {
        this.socket = new Socket(AppServerSocket.Host, AppServerSocket.Port);
    }

    public void connect(){
        try {
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println(inputStream.readUTF());
            for (int i = 0; i < 5; i++) {
                outputStream.writeUTF("Message: " + i);
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Unable to connect to server");
        }
    }
}
