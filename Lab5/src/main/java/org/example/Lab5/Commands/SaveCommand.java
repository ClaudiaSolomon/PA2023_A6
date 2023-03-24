package org.example.Lab5.Commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Lab5.Catalog;

import java.io.File;
import java.io.IOException;

public class SaveCommand extends CatalogUtil{
    @Override
    public void executeCommand(Catalog catalog, String path) throws IOException, InvalidCatalogException, InvalidPathException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path),catalog);
    }
}
