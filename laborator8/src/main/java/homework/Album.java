package homework;

/**
 * describes an album
 */
public class Album {
    private int id;
    private int year;
    private String title;
    private String artist;
    private String genre;

    /**
     * initialize the album
     *
     * @param id     id in table Albums
     * @param year   release year
     * @param title  name of album
     * @param artist singer
     * @param genre  string of genres
     */
    public Album(int id, int year, String title, String artist, String genre) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return representation of album
     */
    @Override
    public String toString() {
        return "Album: title: " +
                this.title +
                " artist: " +
                this.artist +
                "release year: " +
                this.year;
    }
}
