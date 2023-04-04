package org.example.Lab7;

import java.util.*;

public class SharedMemory {
    private final Queue<Token> listOfTokens=new LinkedList<>();
    public SharedMemory(int n) {
        Token token=new Token(n);
        listOfTokens.add(token);
        Collections.shuffle((List<?>) listOfTokens);
    }
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (listOfTokens.isEmpty()) {
                break;
            }
            extracted.add(listOfTokens.poll());
        }
        return extracted;
    }
}