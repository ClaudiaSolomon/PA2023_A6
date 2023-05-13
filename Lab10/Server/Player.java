package org.example.Server;

public class Player {
    private int number;
    private String character;
    private static long start;
    private static long end;

    public Player(int number,long end) {
        this.number = number;
        Player.start=System.currentTimeMillis();
        Player.end=Player.start+end;
        if(number%2==0)
        {
            this.character="X";
        }
        else{
            this.character="0";
        }
    }

    public int getNumber() {
        return number;
    }

    public String getCharacter() {
        return character;
    }
    public static void startTimer()
    {
        Player.start=System.currentTimeMillis();
    }
    public boolean verifyTime()
    {
        //10 secunde
        long end=start+10000;
        if(System.currentTimeMillis()-start>end)
        {
            return false;
        }
        return true;
    }

    public static void setEnd(long end) {
        Player.end = start+end;
    }

    public static long getStart() {
        return start;
    }

    public static long getEnd() {
        return end;
    }
}
