package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServerSocket {
    public static final int Port = 9876;
    public static final String Host = "localhost";

    private ServerSocket serverSocket;
    private Socket client;

    public AppServerSocket() throws IOException {
        serverSocket = new ServerSocket(Port);
        client = new Socket();
        System.out.println("Servidor Iniciado");
        System.out.println("Esperando ID Cliente");
    }

    public Socket clientSocket() {
        return client;
    }

    public void Accept() throws IOException {

        client = serverSocket.accept();
    }

    public void Close() throws IOException {

        serverSocket.close();
    }
}
