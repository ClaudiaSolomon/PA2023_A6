package org.example.Lab5.Commands;

import org.example.Lab5.Catalog;

public class ListCommand extends CatalogUtil{
    public void executeCommand(Catalog catalog) throws InvalidCatalogException
    {
        System.out.println(catalog.getDocs());
    }
}
