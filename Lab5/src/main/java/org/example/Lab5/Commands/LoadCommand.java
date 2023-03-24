package org.example.Lab5.Commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Lab5.Catalog;

import java.io.File;
import java.io.IOException;

public class LoadCommand extends CatalogUtil {

    public void executeCommand(String path) throws IOException, InvalidPathException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
        System.out.print(catalog);
    }
}
