package org.example.Lab5.Commands;

import org.example.Lab5.Catalog;
import org.example.Lab5.Document;

public class AddCommand extends CatalogUtil{
    public void executeCommand(Catalog catalog,Document document) throws InvalidCatalogException,InvalidDocumentException {
       catalog.add(document);
    }
}
