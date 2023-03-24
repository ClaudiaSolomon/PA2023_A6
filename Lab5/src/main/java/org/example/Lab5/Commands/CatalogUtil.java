package org.example.Lab5.Commands;

import freemarker.template.TemplateException;
import org.example.Lab5.Catalog;
import org.example.Lab5.Document;

import java.io.File;
import java.io.IOException;

public abstract class CatalogUtil {
    public void executeCommand(Catalog catalog) throws IOException, TemplateException, InvalidCatalogException, InvalidPathException {

    }
    public void executeCommand(Catalog catalog,Document document) throws InvalidCatalogException, IOException,InvalidDocumentException {}
    public void executeCommand(Catalog catalog,String path) throws IOException, InvalidCatalogException, InvalidPathException {}
    public void executeCommand(String path) throws IOException, InvalidPathException {}
    public void executeCommand(File file) throws IOException {}
}
