package homework;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database database = new Database();
        try (Connection connection = database.getConnection()) {
            System.out.println("Connected to database!");
        }
        catch(SQLException exception)
        {
            System.out.println("Failed to connect to database");
        }
        Playlist playlist1 = new Playlist("Indie");
        //playlist1.addAlbum("AM");
        // playlist1.addAlbum("This is it");
        //playlist1.addAlbum("The Smiths");
        //playlist1.deleteAlbum("The Smiths");
        playlist1.getAlbums();

    }
}
