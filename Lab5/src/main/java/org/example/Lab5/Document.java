package org.example.Lab5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String id;
    private String title;
    private String location; //file name or Web page
    private Map<String, Object> tags = new HashMap<>();

    public Document(String id, String title) {
        this.id = id;
        this.title = title;
    }
    public Document()
    {

    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}';
    }

    public String getId() {
        return id;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }
}
