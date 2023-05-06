package org.example.Server;

import org.example.Server.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;

public class GameServer {
    private static ServerSocket server;

    public static ServerSocket getServer() {
        return server;
    }
public static void createServer() throws IOException, ClassNotFoundException {
    int port = 9876;
    server = new ServerSocket(port);
    ClientThread.communicate();
}
public static String createGame()
{
    return "Game creating...";
//    System.out.println("se creaza jocul...");
}
}
