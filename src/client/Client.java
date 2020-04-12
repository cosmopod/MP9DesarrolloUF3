package client;
import server.Server;
import java.io.IOException;
import java.net.Socket;

public class Client {

    private Socket socket;
    private boolean exit = false;

    public Socket getSocket() {
        return socket;
    }


    public Client() throws IOException {
        this.socket = new Socket(Server.Host, Server.Port);
    }

    public void close() throws IOException {
        socket.close();
    }
}
