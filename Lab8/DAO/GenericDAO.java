package org.example.Lab8.DAO;

import org.example.Lab8.DataBase;
import org.example.Lab8.OOPModel.Album;
import org.example.Lab8.OOPModel.Artist;
import org.example.Lab8.OOPModel.Genre;
import org.example.Lab8.OOPModel.Music;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericDAO {
    private final String tableName;

    public GenericDAO(String tableName) {
        this.tableName = tableName;
    }

    public void create(Music music) throws SQLException {
        Connection con = DataBase.getConnection();
            try (PreparedStatement pstmt = con.prepareStatement(
                    "insert into "+tableName+ " (name) values (?)")) {
                pstmt.setString(1, music.getName());
                pstmt.executeUpdate();
        }

    }
    public Music findByName(String name) throws SQLException {
        Connection con = DataBase.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from "+tableName+ " where name='" + name + "'")) {
            if(Objects.equals(tableName, "artists")) {
                return new Artist(rs.getInt("id"), name);
            }
            if(Objects.equals(tableName, "genres"))
            {
                return new Genre(rs.getInt("id"),name);
            }
            if(Objects.equals(tableName, "albums"))
            {
                return new Album(rs.getInt("id"), name );
            }
        }
        return null;
    }
    public Music findById(int id) throws SQLException {
        Connection conn = DataBase.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from "+tableName+ " where id='" + id + "'")) {
            if(Objects.equals(tableName, "artists")) {
                return new Artist(id, rs.getString("name"));
            }
            if(Objects.equals(tableName, "genres"))
            {
                return new Genre(id, rs.getString("name"));
            }
            if(Objects.equals(tableName, "albums"))
            {
                return new Album(id, rs.getString("name"));
            }
        }
        return null;
    }
    public List<Music> findAll() throws SQLException {
        List<Music> listMusic=new ArrayList<>();
        Connection con1 = DataBase.getConnection();
        try {
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery("select * from "+tableName);
            while(rs.next())
            {
                if(Objects.equals(tableName, "artists")) {
                    Artist artist = new Artist(rs.getInt("id"), rs.getString("name"));
                    listMusic.add(artist);
                }
                if(Objects.equals(tableName, "genres"))
                {
                    Genre genre=new Genre(rs.getInt("id"),rs.getString("name"));
                    listMusic.add(genre);
                }
                if(Objects.equals(tableName, "albums")) {
                Album album=new Album(rs.getInt("id"), rs.getString("name"));
                listMusic.add(album);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listMusic;
    }
}
