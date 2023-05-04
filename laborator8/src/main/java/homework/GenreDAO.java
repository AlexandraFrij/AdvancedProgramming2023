package homework;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Describes operations on table Genres
 */

public class GenreDAO {
    /**
     * creates instance
     *
     * @param name genre's name
     * @throws SQLException exception when creating record
     */
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres values ( ?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Inserted in table Genres: " + name);
        } finally {
            con.commit();
        }
    }

    /**
     * find artist by name
     *
     * @param name genre's name
     * @return Genre object containing all info about the genre
     * @throws SQLException exception when searching in table
     */
    public Genre findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        int id = -1;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name ='" + name + "'")) {
            if (rs.next())
                id = rs.getInt(1);
        }
        return new Genre(id, name);
    }

    /**
     * finds genre by id
     *
     * @param id id in table
     * @return Genre object with all info about the genre
     * @throws SQLException exception when searching in table
     */
    public Genre findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        String name = " ";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id ='" + id + "'")) {
            if (rs.next())
                name = rs.getString(2);
        }
        return new Genre(id, name);
    }

    /**
     * finds all records in table
     *
     * @return all records as a list or Genre
     * @throws SQLException exception when selecting in table
     */
    public List<Genre> findAll() throws SQLException {
        Connection con = Database.getConnection();
        String name = " ";
        int id = -1;
        List<Genre> genres = new ArrayList<>();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from genres")) {
            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                Genre genre = new Genre(id, name);
                genres.add(genre);
            }
        }
        return genres;

    }
}

