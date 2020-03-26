package client;
import server.AppServerSocket;
import java.io.IOException;
import java.net.Socket;

public class ClientSocket {

    private Socket socket;
    private boolean exit = false;

    public Socket getSocket() {
        return socket;
    }

    public ClientSocket() throws IOException {
        this.socket = new Socket(AppServerSocket.Host, AppServerSocket.Port);
    }

    public void close() throws IOException {
        socket.close();
    }
}
