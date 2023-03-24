package org.example.Lab5;

import freemarker.template.TemplateException;
import org.example.Lab5.Commands.*;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, TemplateException, InvalidCatalogException, InvalidPathException, InvalidDocumentException {
        Catalog catalog =new Catalog("MyDocuments");
        Catalog catalog2=new Catalog("Al doilea catalog");
        var book = new Document("article1","titlu1");
        var article = new Document("book1","titlu2");

        CatalogUtil command1=new AddCommand();
        CatalogUtil command2=new ListCommand();
        CatalogUtil command3=new SaveCommand();
        CatalogUtil command4=new LoadCommand();
        CatalogUtil command5=new ViewCommand();
       // CatalogUtil command6=new ReportCommand();

        command1.executeCommand(catalog,book);
        command1.executeCommand(catalog,article);
        command1.executeCommand(catalog2,book);

        command2.executeCommand(catalog);
        command2.executeCommand(catalog2);

        command3.executeCommand(catalog,catalog.getName()+".json");
        command3.executeCommand(catalog2,catalog2.getName()+".json");

        command4.executeCommand(catalog.getName()+".json");

        command5.executeCommand(catalog.getName()+".json");
        command5.executeCommand(catalog,book);

        //command6.executeCommand(catalog2);
    }
}