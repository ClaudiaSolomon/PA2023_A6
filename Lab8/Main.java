package org.example.Lab8;

import org.example.Lab8.DAO.AlbumDAO;
import org.example.Lab8.DAO.ArtistDAO;
import org.example.Lab8.DAO.GenreDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            var genres = new GenreDAO();
            genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");
            DataBase.getConnection().commit();
            var albums = new AlbumDAO();
            albums.create(1979, "The Wall", "Pink Floyd", "Rock");

            //findByName
            System.out.println(albums.findByName("The Wall"));

            albums.create(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");
            DataBase.getConnection().commit();

            //printAllAlbums
            System.out.println(albums.printAllAlbums());

            DataBase.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            DataBase.rollback();
        }
    }
}