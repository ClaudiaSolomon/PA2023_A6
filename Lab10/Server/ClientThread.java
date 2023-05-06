package org.example.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientThread {
    public static void communicate() throws IOException, ClassNotFoundException {
        while(true) {
            System.out.println("Waiting for commands from client: ");
            Socket socket = GameServer.getServer().accept();

            //reading
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Command received: " + message);

            //writing
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            if(message.equalsIgnoreCase("exit"))
            {
                oos.writeObject("Server stopped");
                break;
            }
            if(message.equalsIgnoreCase("create game"))
            {
                oos.writeObject(GameServer.createGame());
            }
            oos.writeObject("Server received the request: " + message);

            ois.close();
            oos.close();
            socket.close();

        }
    }
}
