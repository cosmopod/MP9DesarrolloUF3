package server;

import client.ClientSocket;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        connectServer();
    }

    private static void connectServer(){
        try {
            AppServerSocket appServerSocket = new AppServerSocket();
            appServerSocket.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
