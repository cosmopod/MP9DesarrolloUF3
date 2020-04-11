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
            Scanner scanner = new Scanner(System.in);

            System.out.println(inputStream.readUTF()); // 2. Recibe invitación servidor servidor
            String username = scanner.nextLine();
            outputStream.writeUTF(username);  // 3. usuario envia su nombre
            System.out.println(inputStream.readUTF()); // 6. recibe peticion tareas servidor


            int tasksNumber = Integer.parseInt(scanner.nextLine());
            outputStream.writeInt(tasksNumber); // 7. envia al servidor el numero de tareas a realizar



            clientSocket.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
