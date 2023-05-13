package org.example.Server;

import org.example.Server.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class GameServer {
    private static ServerSocket server;
    private static boolean running=true;
    private static int nrOfPlayers=0;
    private static Player playerX;
    private static Player player0;
    public static boolean startGame=false;

    public static ServerSocket getServer() {
        return server;
    }

    public static Player getPlayerX() {
        return playerX;
    }

    public static Player getPlayer0() {
        return player0;
    }

    public static void setRunning(boolean running) {
        GameServer.running = running;
    }

    public static int getNrOfPlayers() {
        return nrOfPlayers;
    }

    public static void setNrOfPlayers(int nrOfPlayers) {
        GameServer.nrOfPlayers += nrOfPlayers;
    }

    public static void createServer() throws IOException, ClassNotFoundException {
      int PORT = 9876;
//    server = new ServerSocket(port);
//    ClientThread.communicate();
    ServerSocket serverSocket = null ;
    try {
        serverSocket = new ServerSocket(PORT);
        System.out.println ("Waiting for a client ...");
        while (running) {
            Socket socket = serverSocket.accept();
            // Execute the client's request in a new thread
            new ClientThread(socket).start();
            sleep(10000);
        }
    } catch (IOException e) {
        System.err. println ("Error: " + e);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    } finally {
        serverSocket.close();
    }

}
public static String createGame() throws InterruptedException {
    nrOfPlayers++;
    Board.create();
//    Player.setEnd(20000);
    return GameServer.joinGame();
}
public static String joinGame() throws InterruptedException {
//    nrOfPlayers++;
    if(GameServer.nrOfPlayers%2==0&&GameServer.nrOfPlayers!=0) {
        player0=new Player(nrOfPlayers,10000);
        //timer on
        startGame=true;
        return "You are player 2!";
    }
    else{
        while(nrOfPlayers%2!=0)
        {
            sleep(1);
        }
        String aux=Game.begin();
        System.out.println(aux);
        playerX=new Player(nrOfPlayers-1,10000);
//        Player.startTimer();
        return "You are player 1!";
    }
}
public static String submitMove(int x,int y) throws InterruptedException {
    if(x<0||x>14||y<0||y>14)
    {
        return "Not a valid move!";
    }
    else {
        return Game.validateMove(x,y);
    }
}
}
