package org.example.Lab12;

import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        Main main=new Main();
        main.input();
    }
    public static void input() throws ClassNotFoundException, MalformedURLException {
        String classLocation = "C:\\Users\\Claudia\\Desktop\\anul 2\\java\\Lab11\\Lab11\\Lab11\\src\\main\\java\\com\\example\\Lab11";
        MyClassLoader myClassLoader = new MyClassLoader();
        File path = new File(classLocation);
        if (path.exists()) {
            System.out.println("path exists");
            URL url = path.toURI().toURL();
            myClassLoader.addURL(url);
        }
        String className = "org.example.Lab12.RandomClass";
        Class clasa = Class.forName(className);
        System.out.println(clasa.getName());
        System.out.println(clasa.getPackage());
        System.out.println(Arrays.toString(clasa.getMethods()));
        System.out.println(clasa.getSuperclass());
        
        int passed = 0, failed = 0;
        Method[] methods = clasa.getDeclaredMethods();
        List<Method> testMethods = new ArrayList<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}