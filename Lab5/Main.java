package org.example.Lab5;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        Main app = new Main();
        Catalog catalog =
                new Catalog("MyDocuments");
        var book = new Document("article1","titlu1");
        var article = new Document("book1","titlu2");
        catalog.add(book);
        catalog.add(article);

        CatalogUtil.save(catalog, "./catalog.json");
       System.out.println( CatalogUtil.load("C:\\Users\\Claudia\\IdeaProjects\\Lab5\\catalog.json")+catalog.getName());
    }
}