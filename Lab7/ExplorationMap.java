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
            if (matrix[row][col].isEmpty()){
//                the robot extract tokens
                List<Token> listOfTokens= Exploration.getMem().extractTokens(this.sizeMatrix);
                //                and store the tokens in the cell(it becomes visited)
                matrix[row][col].addAll(listOfTokens);
                //                display a success message
                System.out.println("s-a vizitat cell-ul: row= "+row+" col= "+col);
                return true;
            }
            else {
                System.out.println("cell deja vizitat");
                return false;
            }
        }
    }

    public static List<Token>[][] getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {
        return "ExplorationMap{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}