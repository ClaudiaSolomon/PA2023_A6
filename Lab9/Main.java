package org.example.Lab9;

import org.example.Lab9.Entity.AlbumsEntity;
import org.example.Lab9.Entity.ArtistsEntity;
import org.example.Lab9.Repos.AlbumRepository;
import org.example.Lab9.Repos.ArtistRepository;

import java.sql.SQLException;

import static org.example.Lab9.Repos.ArtistRepository.em;
import static org.example.Lab9.Repos.ArtistRepository.emf;

public class Main {
    public static void main(String[] args) throws SQLException {
        Singleton s = new Singleton();
        s.testJPA();

        ArtistRepository ar = new ArtistRepository();
        ArtistsEntity artist1 = new ArtistsEntity("Pink Floyd");
        ar.create(artist1);
        System.out.println(ar.findByName("Pink Floyd"));

        AlbumRepository albumRepository=new AlbumRepository();
        AlbumsEntity album=new AlbumsEntity(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");
        albumRepository.create(album);
        System.out.println(albumRepository.findByName("Thriller"));

        em.close();
        emf.close();
    }
}