package org.example.Lab5.Commands;

public class InvalidDocumentException extends Exception{
    public InvalidDocumentException(Exception ex)
    {
        super("Invalid document.",ex);
    }
}