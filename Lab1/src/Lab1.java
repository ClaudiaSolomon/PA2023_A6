import java.util.Scanner;

public class Lab1 {
    public static void main(String args[]) {
        Lab1 lab1 = new Lab1();
        //lab1.compulsory();
        long start1 = System.nanoTime();
        lab1.homework();
        long end1 = System.nanoTime();
        System.out.println("Time in nanoseconds: "+ (end1-start1));
    }
    void compulsory() {
        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n=n*3;
        n=n+0b10101;
        n=n+0xFF;
        n=n*6;
        System.out.println(n);
        int sum=0;
        while(n>0)
        {
            sum=sum+n%10;
            n=n/10;
        }
        int c=0;
        while(sum>0)
        {
            c=c+sum%10;
            sum=sum/10;
            if(sum==0&& c>=10) {
                sum = c;
                c = 0;
            }
        }
        System.out.println(c);
        System.out.println( "Willy-nilly, this semester I will learn " + languages[c]);
    }
    void homework() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //System.out.println(n);
        try {
            Integer.parseInt(input);
            System.out.println(input + " is a valid integer");
        } catch (NumberFormatException e) {
            System.out.println(input + " is not a valid integer");
            System.out.println(e);
        }
        int n = Integer.valueOf(input);
        int[][] latinSquareMatrix = new int[n][n];
        int k;
        for (int i = 0; i < n; i++) {
            k = i;
            for (int j = 0; j < n; j++) {
                k++;
                if (k == n + 1) k = 1;
                latinSquareMatrix[i][j] = k;

            }
        }
        String concatenareLinie = " ";
        if(n<30000) {
            for (int i = 0; i < n; i++) {
                concatenareLinie = " ";
                for (int j = 0; j < n; j++) {
                    concatenareLinie = concatenareLinie.concat(String.valueOf(latinSquareMatrix[i][j]));
                    concatenareLinie = concatenareLinie.concat(" ");
                    //System.out.print(latinSquareMatrix[i][j] + " ");
                }

                System.out.println(concatenareLinie);

            }
            System.out.println();
            String concatenareColoana = " ";
                for (int j = 0; j < n; j++) {
                    concatenareColoana = " ";
                    for (int i = 0; i < n; i++) {
                        concatenareColoana = concatenareColoana.concat(String.valueOf(latinSquareMatrix[j][i]));
                        concatenareColoana = concatenareColoana.concat(" ");
                        //System.out.print(latinSquareMatrix[i][j] + " ");
                    }
                    System.out.println(concatenareColoana);
                }

               // System.out.println();
            }
        }
}
