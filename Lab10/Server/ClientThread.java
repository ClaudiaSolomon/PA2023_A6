package org.example.Server;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import static org.junit.Assert.assertTrue;
public class ClientThread extends Thread{
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run() {
        try {
            // Get the request from the input stream: client → server
            System.out.println ("New client here!");
            while (true) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                System.out.println("Command received: " + request);
                // Send the response to the oputput stream: server → client
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String raspuns = "Server received the request: " + request;
                if(System.currentTimeMillis()>Player.getEnd()&& GameServer.startGame)
                {
                    System.out.println("Time ran out");
//                    GameServer.setNrOfPlayers(-1);
                    GameServer.setPlayersTo0();
                    out.println("Time ran out!");
                }
                if (request.equalsIgnoreCase("stop")) {
//                    out.println("Server stopped");
                    System.out.println("Server stopped");
                    GameServer.setRunning(false);
                    break;
                }
                else {
                    if(Objects.equals(request, "exit"))
                    {
//                        out.println("Client disconnected");
                        System.out.println("Client disconnected");
                        GameServer.setNrOfPlayers(-1);
//                        break;
                    }else {
                        if (request.equalsIgnoreCase("create game")) {
//                            GameServer.setNrOfPlayers(1);
                            out.println(GameServer.createGame());
                        } else {
                            if (request.equalsIgnoreCase("join game")) {
                               if(GameServer.getNrOfPlayers()%2==0)
                               {
                                   out.println("There's no game available!");
                               }
                               else{
                                   GameServer.setNrOfPlayers(1);
                                   out.println(GameServer.joinGame());
                               }
                            } else {
                                if (request.contains("submit move: ")) {
                                    if(GameServer.getNrOfPlayers()%2!=0)
                                    {
                                        out.println("Wait for player 2 to join!");
                                    }
                                    else {
                                        if(GameServer.getNrOfPlayers()==0)
                                        {
                                            out.println("There's no game available!");
                                        }
                                        else {
                                            int ok=0;
                                            int x=0,y=0;
                                            for(int i=13;i<request.length();i++)
                                            {
                                                if(Character.compare(request.charAt(i), ' ') == 0)
                                                {
                                                    ok=1;
                                                }
                                                else {
                                                    if (ok == 0) {
                                                        x = x * 10 + Character.getNumericValue(request.charAt(i));
                                                    } else {
                                                        y = y * 10 + Character.getNumericValue(request.charAt(i));
                                                    }
                                                }
                                            }
//                                            System.out.println("x="+x+"y="+y);
                                            out.println(GameServer.submitMove(x,y));
                                        }
                                    }
                                }
                                else {
                                    out.println(raspuns);
                                }
                            }
                        }
                    }
                }
                out.flush();
            }
            } catch(IOException e){
                System.err.println("Communication error... " + e);
            } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
                try {
                    socket.close(); // or use try-with-resources
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }
