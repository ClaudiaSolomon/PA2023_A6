package org.example.Lab8.DAO;

import org.example.Lab8.DataBase;

import java.sql.*;

public class GenreDAO {
    public void create(String name) throws SQLException {
        Connection con = DataBase.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = DataBase.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection conn = DataBase.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
