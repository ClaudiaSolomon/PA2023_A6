package org.example.Server;

public class Board {
    private static String[][] board;

    public static String[][] getBoard() {
        return board;
    }

    public static void setBoard(String move,int x,int y) {
        Board.board[x][y] = move;
    }

    public static void create()
    {
        board=new String[15][15];
    }
    public static String updateBoard()
    {
        String boardToPrint = new String();
        boardToPrint+="\n---------------------------------------------------------------------\n";
//        System.out.println();
//        System.out.println("-----------------------");
        for(int i=0;i<15;i++)
        {
            for(int j=0;j<15;j++)
            {
                if(board[i][j]==null)
                {
                    boardToPrint+="   |";
//                    System.out.print("   |");
                }
                else {
                    boardToPrint+=" "+board[i][j]+" |";
//                    System.out.print(" "+board[i][j] + " |");
                }
            }
            boardToPrint+="\n---------------------------------------------------------------------\n";
//            System.out.println();
//            System.out.println("-----------------------");
        }
        return boardToPrint;
    }
}
