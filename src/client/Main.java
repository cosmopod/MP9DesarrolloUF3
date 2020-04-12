package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        DataInputStream inputStream = null;
        DataOutputStream outputStream = null;
        try {
            inputStream = new DataInputStream(client.getSocket().getInputStream());
            outputStream = new DataOutputStream(client.getSocket().getOutputStream());
            Scanner scanner = new Scanner(System.in);

            System.out.println(inputStream.readUTF()); // 2. Recibe invitación servidor servidor
            String username = scanner.nextLine();
            outputStream.writeUTF(username);  // 3. usuario envia su nombre
            System.out.println(inputStream.readUTF()); // 6. recibe peticion tareas servidor

            int tasksNumber = Integer.parseInt(scanner.nextLine());
            outputStream.writeInt(tasksNumber); // 7. envia al servidor el numero de tareas a realizar

            for (int i = 0; i < tasksNumber; i++) {
                System.out.println(inputStream.readUTF()); // 10. recibe peticion numero tarea
                System.out.println(inputStream.readUTF()); //12 recibe solicitud descripcion
                String description = scanner.nextLine();
                outputStream.writeUTF(description); // 13. envia descripcion tarea
                System.out.println(inputStream.readUTF()); // 16. recibe solicitud estado tarea
                String taskState = scanner.nextLine();
                outputStream.writeUTF(taskState); // 17. envia estado de la tarea
            }

            System.out.println(inputStream.readUTF()); // 20. recibe aviso tareas

            for (int i = 0; i < tasksNumber; i++) {
                System.out.println(inputStream.readUTF()); // 22. recibe tareas
            }

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getLocalizedMessage());
        }

        if (inputStream != null) inputStream.close();
        if (outputStream != null) outputStream.close();
        client.close();
    }
}
