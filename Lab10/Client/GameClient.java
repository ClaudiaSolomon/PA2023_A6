package org.example.Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class GameClient {
//    public static void communicate() throws IOException, ClassNotFoundException, InterruptedException {
//        //get the localhost IP address, if server is running on some other IP, you need to use that
//        InetAddress host = InetAddress.getLocalHost();
//        Socket socket = null;
//        ObjectOutputStream oos = null;
//        ObjectInputStream ois = null;
//       while(true){
//            socket = new Socket(host.getHostName(), 9876);
//
//            oos = new ObjectOutputStream(socket.getOutputStream());
//            System.out.println("Sending request to Server");
//
//            //reading from keyboard
//           Scanner scanner=new Scanner(System.in);
//           String msj=scanner.nextLine();
//
//           //writing to server
//           oos.writeObject(msj);
//           if(Objects.equals(msj, "exit")||Objects.equals(msj, "stop")){
//               ois = new ObjectInputStream(socket.getInputStream());
//               String message = (String) ois.readObject();
//               System.out.println(message);
//               break;
//           }
//
//           //reading from server
//           ois = new ObjectInputStream(socket.getInputStream());
//           String message = (String) ois.readObject();
//           System.out.println(message);
//
//           ois.close();
//           oos.close();
//           Thread.sleep(100);
//        }
//    }
public static void main (String[] args) throws IOException {
    String serverAddress = "127.0.0.1"; // The server's IP address
    int PORT = 9876; // The server's port
    try (
            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())) ) {
        while(true) {
            // Send a request to the server
            System.out.println("Enter command: ");
            Scanner scanner = new Scanner(System.in);
            String request = scanner.nextLine();
            out.println(request);
            if(Objects.equals(request, "exit")||Objects.equals(request, "stop")){
               System.out.println("I disconnect now");
               break;
           }
            // Wait the response from the server ("Hello World!")
            String response = in.readLine();
            System.out.println(response);
        }
    } catch (UnknownHostException e) {
        System.err.println("No server listening... " + e);
    }
    }

}
