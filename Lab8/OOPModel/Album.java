package org.example.Lab8.OOPModel;

import java.util.Objects;

public class Album extends Music{
    private int id;
    private int release_year;
    private String title;
    private String artist;
    private String genre;
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    public Album(int id, int release_year, String title, String artist, String genre) {
        this.id = id;
        this.release_year = release_year;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public Album(int id,String title) {
        this.id = id;
        this.title=title;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", release_year=" + release_year +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album album)) return false;
        return getId() == album.getId() && getRelease_year() == album.getRelease_year() && getName().equals(album.getName()) && getArtist().equals(album.getArtist()) && getGenre().equals(album.getGenre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRelease_year(), getName(), getArtist(), getGenre());
    }
}
