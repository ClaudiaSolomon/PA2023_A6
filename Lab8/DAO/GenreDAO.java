package org.example.Lab8.DAO;

import org.example.Lab8.DataBase;
import org.example.Lab8.OOPModel.Artist;
import org.example.Lab8.OOPModel.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {
    public void create(Genre genre) throws SQLException {
        Connection con = DataBase.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, genre.getName());
            pstmt.executeUpdate();
        }
    }
    public Genre findByName(String name) throws SQLException {
        Connection con = DataBase.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + name + "'")) {
            return new Genre(rs.getInt("id"),name);
        }
    }
    public Genre findById(int id) throws SQLException {
        Connection conn = DataBase.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id='" + id + "'")) {
            return new Genre(id,rs.getString("name"));
        }
    }
    public List<Genre> findAll() throws SQLException {
        List<Genre> listGenres=new ArrayList<>();
        Connection con1 = DataBase.getConnection();
        try {
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery("select * from genres");
            while(rs.next())
            {
                Genre genre=new Genre(rs.getInt("id"),rs.getString("name"));
                listGenres.add(genre);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listGenres;
    }
}
