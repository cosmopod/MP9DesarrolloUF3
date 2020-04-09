package client;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        connectClient();
    }
    private static void connectClient(){
        try {
            ClientSocket clientSocket = new ClientSocket();
            clientSocket.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
