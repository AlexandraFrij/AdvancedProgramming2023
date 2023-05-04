package homework;


import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * describes a playlist
 */
public class Playlist {
    private String name;
    private String createdOn;

    /**
     * initialise the playlist
     *
     * @param name given name
     * @throws SQLException exception at creating table for playlist
     */
    public Playlist(String name) throws SQLException {
        this.name = name;
        this.createdOn = currentDate();
        Connection con = Database.getConnection();
        String command = "CREATE TABLE " + name +
                "( album_title varchar(50), added_on varchar(50) )";
        Statement stmt = con.createStatement();
        try {
            stmt.execute(command);
            System.out.println("Table " + name + " created!");
            stmt.close();
        } catch (SQLException exception) {
            System.out.println("Exception at creating table : " + name + exception);
        } finally {
            con.commit();
        }

    }

    /**
     * @return return the current date as string of format dd/MM/yy
     */
    private String currentDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String str = formatter.format(date);
        return str;
    }

    /**
     * adds an album in table
     *
     * @param album album's title
     * @throws SQLException exception at insert
     */
    public void addAlbum(String album) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into " + name + " values (?, ?)")) {
            pstmt.setString(1, album);
            pstmt.setString(2, currentDate());
            pstmt.executeUpdate();
            System.out.println("Inserted in table: " + name);
        } finally {
            con.commit();
        }
    }

    /**
     * deletes an album from table
     *
     * @param album album to be deleted
     * @throws SQLException exception al delete
     */
    public void deleteAlbum(String album) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "delete from " + name + " where album_title =  '" + album + "'")) {
            int row = pstmt.executeUpdate();
            if (row == 0)
                System.out.println("Album doesn't exists in playlist");
            else System.out.println("Album deleted");
        } finally {
            con.commit();
        }
    }

    /**
     * prints all albums in table
     *
     * @throws SQLException exception at select all
     */
    public void getAlbums() throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from " + name)) {
            while (rs.next()) {
                String title = rs.getString(1);
                String addedOn = rs.getString(2);
                System.out.println("Album " + title + " added on: " + addedOn);
            }
        }
    }
}
