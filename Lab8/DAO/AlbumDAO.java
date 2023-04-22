package org.example.Lab8.DAO;

import org.example.Lab8.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {
    public void create(int year,String title,String artist,String genre) throws SQLException {
        Connection con = DataBase.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year,title,artist,genre) values (?,?,?,?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2, title);
            pstmt.setString(3, artist);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = DataBase.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection conn = DataBase.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select title from albums where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
    public List<String> printAllAlbums() throws SQLException {
        List<String> listTitles=new ArrayList<>();
        Connection con1 = DataBase.getConnection();
        try {
            Statement stmt = con1.createStatement();
             ResultSet rs = stmt.executeQuery("select * from albums");
            while(rs.next())
            {
              listTitles.add(rs.getString("title"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listTitles;
    }
}
