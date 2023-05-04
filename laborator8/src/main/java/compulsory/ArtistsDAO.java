package compulsory;
import java.lang.constant.Constable;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
/**
 * Describes operations on table Artists
 */
public class ArtistsDAO {
    /**
     * creates instance
     * @param name artist's name
     * @throws SQLException exception when creating record
     */
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        Random random = new Random();
        int id = random.nextInt(15);
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists values (?, ?)")) {
            pstmt.setString(2, name);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Inserted in table Artists artist: "+ name);
        }
        finally {
            con.commit();
        }
    }
    /**
     * find artist by name
     * @param name artist's name
     * @return Artist's id
     * @throws SQLException exception when searching in table
     */
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name ='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    /**
     * finds artist by id
     *
     * @param id id in table
     * @return artist's name
     * @throws SQLException exception when searching in table
     */
    public String findById(int id) throws SQLException{
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from artists where id ='" + id + "'")) {
            return rs.next() ? rs.getString(2) : null;
        }
    }
}
