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

            int taskNumber = inputStream.readInt(); // 8. recibe el numero de tareas
            System.out.println("Se han recibido " + taskNumber + " tareas");

            for (int i = 0; i < taskNumber ; i++) {
                Tarea userTask = new Tarea();
                outputStream.writeUTF("Introduccion de la tarea: " + (i + 1)); // 9. envia cliente numero tarea
                outputStream.writeUTF("descripcion de la tarea:"); // 11. solicita descripcion tarea
                String taskDescription = inputStream.readUTF(); // 14. recibe description tarea
                System.out.println("Descripcion recibida: " + taskDescription);
                outputStream.writeUTF("Estado de la tarea:"); // 15. solicita estado tarea
                String taskState = inputStream.readUTF(); // 18. recibe el estado de la tarea
                System.out.println("Estado recibido: " + taskState);

                userTask.Descripcion = taskDescription;
                userTask.Estado = taskState;
                appServerSocket.AddTaskToList(userTask);
            }



            //appServerSocket.clientSocket().close();
        }
    }
}
