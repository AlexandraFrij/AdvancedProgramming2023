package homework;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Describes operations on table Albums
 */
public class AlbumsDAO {
    /**
     * creates the table
     *
     * @param year   release year
     * @param title  album's name
     * @param artist singer
     * @param genre  string of genres
     * @throws SQLException exceptions when creating the table
     */
    public void create(int year, String title, String artist, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year, title, artist) values (?, ?, ?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2, title);
            pstmt.setString(3, artist);
            pstmt.executeUpdate();
            System.out.println("Inserted in table Albums album: " + title);
            con.commit();
            addAlbumGenres(genre, title);
        }
    }

    /**
     * adds album's genres in another table
     *
     * @param genre string of genres
     * @param title album's name
     * @throws SQLException exception when adding in table
     */
    private void addAlbumGenres(String genre, String title) throws SQLException {
        String[] genres = genre.split(",");
        Album album = findByTitle(title);
        Connection con = Database.getConnection();
        for (int i = 0; i < genres.length; i++) {
            GenreDAO genreDAO = new GenreDAO();
            Genre genre1 = genreDAO.findByName(genres[i]);
            try (PreparedStatement stmt = con.prepareStatement(
                    "insert into albumGenres values (?, ?)")) {
                stmt.setInt(1, album.getId());
                stmt.setInt(2, genre1.getId());
                stmt.executeUpdate();
                System.out.println("Inserted in table Albums album: " + title);
                con.commit();
            } catch (SQLException ex) {
                System.out.println("Exceptie la albumGenres: " + ex);

            }
        }
    }

    /**
     * used to find an album by the title
     *
     * @param title album's name
     * @return un Album object containing all information about an album
     * @throws SQLException exception when searching for id
     */
    public Album findByTitle(String title) throws SQLException {
        Connection con = Database.getConnection();
        Album album = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from albums where title ='" + title + "'")) {
            if (rs.next()) {
                int id = rs.getInt(1);
                int year = rs.getInt(2);
                String artist = rs.getString(3);
                String genre = rs.getString(4);
                album = new Album(id, year, title, artist, genre);
            }
        }
        return album;
    }

    /**
     * used to find an album by the id
     *
     * @param id id in table
     * @return Album object containing info about an album
     * @throws SQLException exception when searching for title
     */
    public Album findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        int year = -1;
        String genre = " ";
        String artist = " ";
        String title = " ";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from albums where id ='" + id + "'")) {
            if (rs.next()) {
                year = rs.getInt(2);
                title = rs.getString(3);
                artist = rs.getString(4);
                genre = rs.getString(5);
            }
        }
        return new Album(id, year, title, artist, genre);
    }

    /**
     * find all records in table
     *
     * @return all records as a list of Albums
     * @throws SQLException exception when selecting from table
     */
    public List<Album> findAll() throws SQLException {
        Connection con = Database.getConnection();
        List<Album> albums = new ArrayList<>();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from albums")) {
            while (rs.next()) {
                int id = rs.getInt(1);
                int year = rs.getInt(2);
                String title = rs.getString(3);
                String artist = rs.getString(4);
                String genre = rs.getString(5);
                Album album = new Album(id, year, title, artist, genre);
                albums.add(album);
            }
        }
        return albums;

    }
}

