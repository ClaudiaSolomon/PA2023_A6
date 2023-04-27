package org.example.Lab8.DAO;

import org.example.Lab8.DataBase;
import org.example.Lab8.OOPModel.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {
    public void create(Artist artist) throws SQLException {
        Connection con = DataBase.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, artist.getName());
            pstmt.executeUpdate();
        }
    }
    public Artist findByName(String name) throws SQLException {
        Connection con = DataBase.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name='" + name + "'")) {
            return new Artist(rs.getInt("id"),name);
        }
    }
    public Artist findById(int id) throws SQLException {
        Connection conn = DataBase.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from artists where id='" + id + "'")) {
            return new Artist(id,rs.getString("name"));
        }
    }
    public List<Artist> findAll() throws SQLException {
        List<Artist> listArtists=new ArrayList<>();
        Connection con1 = DataBase.getConnection();
        try {
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery("select * from artists");
            while(rs.next())
            {
                Artist artist=new Artist(rs.getInt("id"),rs.getString("name"));
                listArtists.add(artist);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listArtists;
    }
}
