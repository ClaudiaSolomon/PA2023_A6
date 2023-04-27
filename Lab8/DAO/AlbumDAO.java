package org.example.Lab8.DAO;

import org.example.Lab8.DataBase;
import org.example.Lab8.OOPModel.Album;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {
    public void create(Album album) throws SQLException {
        Connection con = DataBase.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year,name,artist,genre) values (?,?,?,?)")) {
            pstmt.setInt(1, album.getRelease_year());
            pstmt.setString(2, album.getName());
            pstmt.setString(3, album.getArtist());
            pstmt.setString(4, album.getGenre());
            pstmt.executeUpdate();
        }
    }
    public Album findByName(String name) throws SQLException {
        Connection con = DataBase.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id,release_year,artist,genre from albums where name='" + name + "'")) {
            return new Album(rs.getInt("id"),
                    rs.getInt("release_year"),
                    name,
                    rs.getString("artist"),
                    rs.getString("genre"));
        }
    }
    public Album findById(int id) throws SQLException {
        Connection conn = DataBase.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select title,release_year,artist,genre from albums where id='" + id + "'")) {
            return new Album(id,
                    rs.getInt("release_year"),
                    rs.getString("name"),
                    rs.getString("artist"),
                    rs.getString("genre"));
        }
    }
    public List<Album> findAll() throws SQLException {
        List<Album> listAlbums=new ArrayList<>();
        Connection con1 = DataBase.getConnection();
        try {
            Statement stmt = con1.createStatement();
             ResultSet rs = stmt.executeQuery("select * from albums");
            while(rs.next())
            {
                Album album=new Album(rs.getInt("id"),
                        rs.getInt("release_year"),
                        rs.getString("name"),
                        rs.getString("artist"),
                        rs.getString("genre"));
              listAlbums.add(album);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listAlbums;
    }
}
