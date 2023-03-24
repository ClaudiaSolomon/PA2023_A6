package org.example.Lab5.Commands;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.example.Lab5.Catalog;

import javax.swing.text.View;

import static java.lang.System.out;

public class ReportCommand extends CatalogUtil{
    public void executeCommand(Catalog catalog) throws IOException, TemplateException, InvalidPathException,InvalidCatalogException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File("./"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Map<String, Object> map = new HashMap<>();
        map.put("catalog", catalog);
       Template template = cfg.getTemplate("report.ftl");
        Writer console = new OutputStreamWriter(System.out);
        template.process(map, console);

        Writer file = new FileWriter (new File("./report.html"));
        ViewCommand view=new ViewCommand();
        view.executeCommand("./report.html");

        template.process(map, file);
    }

}
