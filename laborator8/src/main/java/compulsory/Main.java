package compulsory;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database db = new Database();
        /*Tables tables = new Tables(db);
        tables.createTableArtists();
        tables.createTableAlbums();
        tables.createTableGenres();
*/        try {
            var artists = new ArtistsDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            var genres = new GenreDAO();
            genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");
            var albums = new AlbumsDAO();
            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            albums.create(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");
        } catch (SQLException e) {
            System.err.println(e);

        }
    }
}