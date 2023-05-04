package compulsory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * used to create the tables for database
 */
public class Tables {
    private Database db;
    private Connection conn;

    /**
     * constructor method used to connect to database
     *
     * @param database database used
     */
    public Tables(Database database) {
        this.db = database;
        conn = db.getConnection();
    }

    /**
     * creates table Albums
     *
     * @throws SQLException exception when creating the table
     */
    public void createTableAlbums() throws SQLException {
        String command = "CREATE TABLE ALBUMS" +
                "( id int, " +
                "release_year int," +
                " title varchar(50), " +
                "artist varchar(50), " +
                "genre varchar(50) );";
        Statement stmt = conn.createStatement();
        try {
            stmt.execute(command);
            System.out.println("Table albums created!");
            stmt.close();
        } catch (SQLException exception) {
            System.out.println("Exception at creating table albums: " + exception);
        } finally {
            conn.commit();
        }
    }

    /**
     * creates table Artists
     *
     * @throws SQLException exception when creating the table
     */
    public void createTableArtists() throws SQLException {
        String command = "CREATE TABLE ARTISTS" +
                "( id int, " +
                "name varchar(50) );";
        Statement stmt = conn.createStatement();
        try {
            stmt.execute(command);
            System.out.println("Table artists created!");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Exception at creating table artists: " + ex);
        } finally {
            conn.commit();
        }
    }

    /**
     * creates table Genres
     *
     * @throws SQLException exception when creating the table
     */
    public void createTableGenres() throws SQLException {
        String command = "CREATE TABLE GENRES" +
                "( id int, " +
                "name varchar(50) );";
        Statement stmt = conn.createStatement();
        try {
            stmt.execute(command);
            System.out.println("Table genres created!");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Exception at creating table genres: " + ex);
        } finally {
            conn.commit();
        }
    }


}
