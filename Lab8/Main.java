package org.example.Lab8;

import org.example.Lab8.DAO.AlbumDAO;
import org.example.Lab8.DAO.ArtistDAO;
import org.example.Lab8.DAO.GenericDAO;
import org.example.Lab8.DAO.GenreDAO;
import org.example.Lab8.OOPModel.Album;
import org.example.Lab8.OOPModel.Artist;
import org.example.Lab8.OOPModel.Genre;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        try {
//            var artists = new ArtistDAO();
//            artists.create("Pink Floyd");
//            artists.create("Michael Jackson");
//            var genres = new GenreDAO();
//            genres.create("Rock");
//            genres.create("Funk");
//            genres.create("Soul");
//            genres.create("Pop");
//            DataBase.getConnection().commit();
//            var albums = new AlbumDAO();
//            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
//
//            //findByName
//            System.out.println(albums.findByName("The Wall"));
//
//            albums.create(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");
//            DataBase.getConnection().commit();
//
//            //printAllAlbums
//            System.out.println(albums.printAllAlbums());
//
//            DataBase.getConnection().close();
//        } catch (SQLException e) {
//            System.err.println(e);
//            DataBase.rollback();
//        }
        try{
            var artists = new ArtistDAO();
            Artist artist = new Artist(1,"Pink Floyd");
            Artist artist2=new Artist(2,"Michael Jackson");
            artists.create(artist);
            artists.create(artist2);
            DataBase.getConnection().commit();

            var genres = new GenreDAO();
            Genre rock = new Genre(1, "Rock");
            Genre pop = new Genre(2, "Pop");
            Genre funk = new Genre(1, "Funk");
            Genre soul = new Genre(2, "Soul");
            genres.create(rock);
            genres.create(pop);
            genres.create(funk);
            genres.create(soul);
            DataBase.getConnection().commit();

            var albums=new AlbumDAO();
            Album album1=new Album(1,1979, "The Wall", "Pink Floyd", "Rock");
            Album album2=new Album(2,1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");
            albums.create(album1);
            albums.create(album2);
            DataBase.getConnection().commit();

            var music=new GenericDAO("artists");
            Artist artist3 = new Artist(1,"Madonna");
            Artist artist4=new Artist(2,"Lady Gaga");
            music.create(artist3);
            music.create(artist4);
            DataBase.getConnection().commit();

            System.out.println(genres.findAll());
            DataBase.getConnection().close();
        } catch (SQLException e){
            System.err.println(e);
            DataBase.rollback();
        }
    }
}