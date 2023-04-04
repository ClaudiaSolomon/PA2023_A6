package org.example.Lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExplorationMap {
    private static List<Token>[][] matrix;
    private int sizeMatrix;

    public ExplorationMap(int size) {
        this.sizeMatrix=size;
        matrix=new List[sizeMatrix][sizeMatrix];
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                matrix[i][j] = new ArrayList<>();
            }
        }

    }

    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (matrix[row][col].isEmpty()==true){
//                the robot extract tokens
                List<Token> listOfTokens= robot.explore.getMem().extractTokens(5);
                //                and store the tokens in the cell(it becomes visited)
                matrix[row][col].addAll(listOfTokens);
                System.out.println(listOfTokens);
                System.out.println();
                //                display a success message
                System.out.println(robot.getName()+" s-a vizitat cell-ul: row= "+row+" col= "+col);
            }
            else {
                System.out.println(robot.getName()+" cell deja vizitat");
            }
            return isFull();
        }
    }

    public static List<Token>[][] getMatrix() {
        return matrix;
    }
    public boolean isFull()
    {
        for(int i=0;i<sizeMatrix;i++)
        {
            for(int j=0;j<sizeMatrix;j++)
            {
                if(matrix[i][j].isEmpty()==true) return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ExplorationMap{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}