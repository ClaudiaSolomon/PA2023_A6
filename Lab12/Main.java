package org.example.Lab12;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Main {
    private static List<String> listOfClasses=new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Main main=new Main();
       // main.input_class();
     //main.input_folder("C:\\Users\\Claudia\\Desktop\\anul 2\\java\\Lab12\\target\\classes\\org\\example\\Lab12",".class");
       // main.input_jar("C:\\Users\\Claudia\\Desktop\\anul 2\\java\\Lab12\\out\\artifacts\\Lab12_jar\\Lab12.jar");
        main.testStatistics();
    }
    public static void input_class() throws ClassNotFoundException {
        String className = "org.example.Lab12.RandomClass";
        Class clasa = Class.forName(className);
        System.out.println(clasa.getName());
        System.out.println(clasa.getPackage());
        System.out.println(Arrays.toString(clasa.getMethods()));
        System.out.println(clasa.getSuperclass());

    }
    public static List<String> input_folder(String folderLocation,String type) throws ClassNotFoundException, MalformedURLException {
        File folder = new File(folderLocation);
        if (!folder.exists()) {
            System.out.println("path doesn't exist");
            return List.of();
        } else {
            if (!folder.isDirectory()) {
                System.out.println("path isn't a folder");
                return List.of();
            }
        }
        File[] files = folder.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                input_folder(file.getAbsolutePath(),type);
            }
             else if (file.getName().endsWith(type)) {
                    System.out.println("Found"+ type+ " file: " + file.getName());
                    listOfClasses.add(file.getPath());
                }
            }
        return listOfClasses;
    }
    public void input_jar(String jarLocation) throws IOException, ClassNotFoundException {
        JarFile jarFile=new JarFile(jarLocation);
        Enumeration<JarEntry> jarEntries= jarFile.entries();
        while(jarEntries.hasMoreElements())
        {
            JarEntry entry = jarEntries.nextElement();
            if(entry.isDirectory())
            {
                input_folder(entry.getName(),".class");
            }
            else {
                if(entry.getName().endsWith(".class"))
                {
                    System.out.println("Found .class file: " + entry.getName());
                }
            }
        }

    }
    public void testStatistics() throws ClassNotFoundException, MalformedURLException {
        String path = "C:\\Users\\Claudia\\Desktop\\anul 2\\java\\Lab12\\src\\main\\java\\org\\example\\Lab12";
        List<String> listOfClasses=input_folder(path,".java");
        for(String classString:listOfClasses)
        {
            String className = getClassNameFromFilePath(classString);
            Class<?> clasa = Class.forName(className);

            
            //apelare javap
            simulate_javap_tool(clasa);


            Annotation[] annotations = clasa.getAnnotations();

            for (Annotation annotation : annotations) {
                if (annotation.annotationType().getSimpleName().equals("Test")) //if class has @Test
                {
                    int passed = 0, failed = 0;
                    Method[] methods = clasa.getDeclaredMethods();
                    for (Method m : methods) {
                        if (m.isAnnotationPresent(Test.class)) //if method has @Test
                        {
                            try {
                                Object instance = clasa.getDeclaredConstructor().newInstance();
                                Object[] arguments = generateMockArguments(m.getParameterTypes());
                                m.invoke(instance, arguments);
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
        }

    }
    private static Object[] generateMockArguments(Class<?>[] parameterTypes) {
        List<Object> arguments = new ArrayList<>();
        for (Class<?> paramType : parameterTypes) {
            if (paramType == int.class) {
                arguments.add(1);
            } else if (paramType == String.class) {
                arguments.add("mock");
            } else {
                arguments.add(null);
            }
        }
        return arguments.toArray();
    }
    private static String getClassNameFromFilePath(String filePath) {
        String normalizedPath = filePath.replace("\\", "/");
        String javaFilePath = normalizedPath.substring(normalizedPath.indexOf("src/main/java/") + 14);

        String className = javaFilePath.replace(".java", "");
        className = className.replace("/", ".");

        return className;
    }
    public void simulate_javap_tool(Class<?> clazz)
    {
        System.out.println("Fields:");
        Field f[]=clazz.getDeclaredFields();
        for(int i=0;i<f.length;i++)
            System.out.println(f[i]);

        System.out.println("Constructors:");
        Constructor con[]=clazz.getDeclaredConstructors();
        for(int i=0;i<con.length;i++)
            System.out.println(con[i]);

        System.out.println("Methods:");
        Method m[]=clazz.getDeclaredMethods();
        for(int i=0;i<m.length;i++)
            System.out.println(m[i]);
    }
}