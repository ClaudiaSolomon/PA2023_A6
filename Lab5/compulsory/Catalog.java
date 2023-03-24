package org.example.Lab5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Document> docs = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    public String getName() {
        return name;
    }

    public List<Document> getDocs() {
        return docs;
    }

    public Catalog(String name) {
        this.name = name;
    }
    public Catalog() {}

    public void add(Document doc) {
        docs.add(doc);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", docs=" + docs +
                '}';
    }
}
