package compulsory;

import java.sql.*;
import java.util.Random;
/**
 * Describes operations on table Genres
 */
public class GenreDAO {
    /**
     * creates instance
     * @param name genre's name
     * @throws SQLException exception when creating record
     */
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        Random random = new Random();
        int id = random.nextInt(15)+ 15;
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres values (?, ?)")) {
            pstmt.setString(2, name);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Inserted in table Genres: "+ name);
        }
        finally {
            con.commit();
        }
    }
    /**
     * find artist by name
     * @param name genre's name
     * @return id in table
     * @throws SQLException exception when searching in table
     */
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name ='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    /**
     * finds genre by id
     *
     * @param id id in table
     * @return genre's name
     * @throws SQLException exception when searching in table
     */
    public String findById(int id) throws SQLException{
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id ='" + id + "'")) {
            return rs.next() ? rs.getString(2) : null;
        }
    }
}
