package org.example.Lab9;

import com.github.javafaker.Faker;
import org.example.Lab9.Entity.AlbumsEntity;
import org.example.Lab9.Entity.ArtistsEntity;
import org.example.Lab9.Repos.AlbumRepository;
import org.example.Lab9.Repos.ArtistRepository;

import java.sql.SQLException;

import static org.example.Lab9.Repos.ArtistRepository.em;
import static org.example.Lab9.Repos.ArtistRepository.emf;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Singleton s = new Singleton();
//        s.testJPA();
//
//        ArtistRepository ar = new ArtistRepository(ArtistsEntity.class);
//        ArtistsEntity artist1 = new ArtistsEntity("Pink Floyd");
//        ar.create(artist1);
//        System.out.println(ar.findByName("Pink Floyd"));
//
//        AlbumRepository albumRepository=new AlbumRepository(AlbumsEntity.class);
//        AlbumsEntity album=new AlbumsEntity(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");
//        albumRepository.create(album);
//        System.out.println(albumRepository.findByName("Thriller"));
//
//        em.close();
//        emf.close();
        Main main=new Main();
        main.generateLargeNumber();
    }
    public void generateLargeNumber()
    {
        Faker faker = new Faker();
        long largeNumber=1000;
        long start = System.nanoTime();
        while(largeNumber!=0)
        {
            int year= (int) ((Math.random() * (2023 - 1970)) + 1970);
            String artist=faker.artist().name();
            String genre = faker.music().genre();
            String name= faker.name().name();
            //artist
            ArtistRepository ar = new ArtistRepository(ArtistsEntity.class);
            ArtistsEntity artistsEntity = new ArtistsEntity(artist);
            ar.create(artistsEntity);

            //album
            AlbumRepository albumRepository=new AlbumRepository(AlbumsEntity.class);
            AlbumsEntity album=new AlbumsEntity(year, name, artist,genre);
            albumRepository.create(album);

            largeNumber--;
        }
        long end = System.nanoTime();
        System.out.println("Time: "+(end-start)+" nanoseconds");
    }
}