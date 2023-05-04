package homework;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

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
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists values (?)")) {
            pstmt.setString(1, name);
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
     * @return Artist object containing all info about artist
     * @throws SQLException exception when searching in table
     */
    public Artist findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        int id = -1;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name ='" + name + "'")) {
            if(rs.next())
                id = rs.getInt(1);
        }
        return new Artist(id, name);
    }
    /**
     * finds artist by id
     * @param id id in table
     * @return Artist object with all info about the artist
     * @throws SQLException exception when searching in table
     */
    public Artist findById(int id) throws SQLException{
        Connection con = Database.getConnection();
        String name = " ";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from artists where id ='" + id + "'")) {
            if(rs.next())
                name = rs.getString(2);
        }
        return new Artist(id, name);
    }

    /**
     * finds all records in table
     * @return all records as a list or Artist
     * @throws SQLException exception when selecting in table
     */
    public List<Artist> findAll() throws SQLException {
        Connection con = Database.getConnection();
        String name = " ";
        int id = -1;
        List<Artist> artists = new ArrayList<>();
        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from artists")){
            while(rs.next())
            {
                id = rs.getInt(1);
                name = rs.getString(2);
                Artist artist = new Artist(id, name);
                artists.add(artist);
            }
        }
        return artists;

    }
}

