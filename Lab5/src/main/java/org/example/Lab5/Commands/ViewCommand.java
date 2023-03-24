package org.example.Lab5.Commands;

import org.example.Lab5.Catalog;
import org.example.Lab5.Document;

import javax.swing.text.View;
import java.awt.*;
import java.io.*;

public class ViewCommand extends CatalogUtil{
    public void executeCommand(String path) throws IOException,InvalidPathException {
        Desktop desktop = Desktop.getDesktop();
        File file=new File(path);
        desktop.open(file);
    }
    public void executeCommand(File file) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }
    public void executeCommand(Catalog catalog, Document document) throws IOException,InvalidDocumentException,InvalidCatalogException {
        if(catalog.findById(document.getId())!=null)
        {
            File file = new File("./document.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write(document.toString());
            fr.close();
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);

        }
    }


}
