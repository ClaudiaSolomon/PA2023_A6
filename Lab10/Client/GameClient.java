package org.example.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class GameClient {
    public static void communicate() throws IOException, ClassNotFoundException, InterruptedException {
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
       while(true){
            socket = new Socket(host.getHostName(), 9876);

            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Server");

            //reading from keyboard
           Scanner scanner=new Scanner(System.in);
           String msj=scanner.nextLine();

           //writing to server
           oos.writeObject(msj);
           if(Objects.equals(msj, "exit")){
               ois = new ObjectInputStream(socket.getInputStream());
               String message = (String) ois.readObject();
               System.out.println(message);
               break;
           }

           //reading from server
           ois = new ObjectInputStream(socket.getInputStream());
           String message = (String) ois.readObject();
           System.out.println(message);

           ois.close();
           oos.close();
           Thread.sleep(100);
        }
    }
}
