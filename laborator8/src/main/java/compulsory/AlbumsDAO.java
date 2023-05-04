package compulsory;

import java.sql.*;
import java.util.Random;

/**
 * Describes operations on table Albums
 */
public class AlbumsDAO {
    /**
     * creates the table
     * @param year release year
     * @param title album's name
     * @param artist singer
     * @param genre string of genres
     * @throws SQLException exceptions when creating the table
     */
    public void create(int year, String title, String artist, String genre) throws SQLException {
        Connection con = Database.getConnection();
        Random random = new Random();
        int id = random.nextInt(15)+ 30;
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums values (?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, year);
            pstmt.setString(3,title);
            pstmt.setString(4,artist);
            pstmt.setString(5,genre);
            pstmt.executeUpdate();
            System.out.println("Inserted in table Albums album: "+ title);
        }
        finally {
            con.commit();
        }
    }

    /**
     * used to find an album by the title
     * @param title album's name
     * @return the id in table
     * @throws SQLException exception when searching for id
     */
    public Integer findByTitle(String title) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title ='" + title + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    /**
     * used to find an album by the id
     *
     * @param id id in table
     * @return album's title
     * @throws SQLException exception when searching for title
     */
    public String findById(int id) throws SQLException{
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select title from albums where id ='" + id + "'")) {
            return rs.next() ? rs.getString(3) : null;
        }
    }
}
