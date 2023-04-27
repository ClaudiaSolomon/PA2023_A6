package org.example.Lab8;

import org.example.Lab8.DAO.AlbumDAO;
import org.example.Lab8.OOPModel.Album;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Tool {
    public static void readLines(File f) throws IOException, SQLException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        line=br.readLine();
        while((line = br.readLine())!= null){
            //System.out.println(line);
            createObjects(line);
        }
        br.close();
        fr.close();
    }
    public static void createObjects(String line) throws SQLException {
        String stringArray[] = line.split(",");
        //System.out.println(stringArray[0]);
        var albums = new AlbumDAO();
        Album album = new Album(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]), stringArray[2], stringArray[3],stringArray[4]);
        albums.create(album);
    }
    public static void main(String args[]) throws IOException, SQLException {
        try{
            File f = new File("C:\\Users\\Claudia\\Downloads\\albumlist.csv");
            readLines(f);
            DataBase.getConnection().commit();
            DataBase.getConnection().close();
        } catch (IOException | SQLException e){
            e.printStackTrace();
            DataBase.rollback();
        }

    }
}
