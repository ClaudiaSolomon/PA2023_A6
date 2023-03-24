package org.example.Lab5.Commands;

public class InvalidPathException extends Exception{
    public InvalidPathException(Exception ex)
    {
        super("Invalid path.",ex);
    }
}

