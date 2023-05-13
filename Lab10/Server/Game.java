package org.example.Server;

import java.util.Objects;

import static java.lang.Thread.sleep;

public class Game {
    private static int nrOfMoves = 0;

    public static String begin() {
        return Board.updateBoard();
    }

    public static int getNrOfMoves() {
        return nrOfMoves;
    }

    public static String validateMove(int x, int y) throws InterruptedException {
        if (Board.getBoard()[x][y] == null) {
            nrOfMoves++;
            if (nrOfMoves % 2 == 0) {
                Board.setBoard("0", x, y);
                String aux = Board.updateBoard();
                System.out.println(aux);
                if(Game.gameWon("0")==1)
                {
                    return "0 won!";
                }
             if(nrOfMoves==15*15)
             {
                 return "Draw!";
             }
             while (nrOfMoves % 2 == 0&& GameServer.getNrOfPlayers()!=0) {
                    sleep(1);
             }
             if(Game.gameWon("X")==1)
             {
                 return "X won!";
             }
             if(nrOfMoves==15*15)
             {
                 return "Draw!";
             }

            } else {
                Board.setBoard("X", x, y);
                String aux = Board.updateBoard();
                System.out.println(aux);
                if(Game.gameWon("X")==1)
                {
                    return "X won!";
                }
                if(nrOfMoves==15*15)
                {
                    return "Draw!";
                }
                while (nrOfMoves % 2 != 0&& GameServer.getNrOfPlayers()!=0) {
                    sleep(1);
                }
                if(Game.gameWon("0")==1)
                {
                    return "0 won!";
                }
                if(nrOfMoves==15*15)
                {
                    return "Draw!";
                }

            }
            return "Move valid!";
        } else {
            return "Move invalid, place occupied on board already!";
        }
    }

    public static int gameWon(String character) {
        int count1, count2;
        if (nrOfMoves < 9) return 0;
        else {
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    if (Objects.equals(Board.getBoard()[i][j], character)) {
                        //vertical
                        if (i - 4 >= 0) {
                            if (Objects.equals(Board.getBoard()[i - 1][j], character) &&
                                    Objects.equals(Board.getBoard()[i - 2][j], character) &&
                                    Objects.equals(Board.getBoard()[i - 3][j], character) &&
                                    Objects.equals(Board.getBoard()[i - 4][j], character)) {
                                return 1;
                            }
                        }
                        if (i + 4 < 15) {
                            if (Objects.equals(Board.getBoard()[i + 1][j], character) &&
                                    Objects.equals(Board.getBoard()[i + 2][j], character) &&
                                    Objects.equals(Board.getBoard()[i + 3][j], character) &&
                                    Objects.equals(Board.getBoard()[i + 4][j], character)) {
                                return 1;
                            }
                        }
                        //orizontal
                        if (j - 4 >= 0) {
                            if (Objects.equals(Board.getBoard()[i][j - 1], character) &&
                                    Objects.equals(Board.getBoard()[i][j - 2], character) &&
                                    Objects.equals(Board.getBoard()[i][j - 3], character) &&
                                    Objects.equals(Board.getBoard()[i][j - 4], character)) {
                                return 1;
                            }
                        }
                        if (j + 4 < 15) {
                            if (Objects.equals(Board.getBoard()[i][j + 1], character) &&
                                    Objects.equals(Board.getBoard()[i][j + 2], character) &&
                                    Objects.equals(Board.getBoard()[i][j + 3], character) &&
                                    Objects.equals(Board.getBoard()[i][j + 4], character)) {
                                return 1;
                            }
                        }
                        //diagonal
                        if(i+j-4>=0)
                        {
                            if(Objects.equals(Board.getBoard()[i+1][j-1], character)&&
                                    Objects.equals(Board.getBoard()[i+2][j-2], character)&&
                                    Objects.equals(Board.getBoard()[i+3][j-3], character)&&
                                    Objects.equals(Board.getBoard()[i+4][j-4], character))
                            {
                                return 1;
                            }
                        }
                        if(i+j+4<15)
                        {
                            if(Objects.equals(Board.getBoard()[i+1][j+1], character)&&
                                    Objects.equals(Board.getBoard()[i+2][j+2], character)&&
                                    Objects.equals(Board.getBoard()[i+3][j+3], character)&&
                                    Objects.equals(Board.getBoard()[i+4][j+4], character))
                            {
                                return 1;
                            }
                        }
                    }
                }
            }

        }
        return 0;
    }
}
