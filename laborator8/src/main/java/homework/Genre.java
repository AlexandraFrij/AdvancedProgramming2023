package homework;

/**
 * describes a genre
 */
public class Genre {
    private String name;
    private int id;

    /**
     * initialise a genre
     *
     * @param id   id in table Genres
     * @param name genre's name
     */
    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return id value
     */
    public int getId() {
        return id;
    }

    /**
     * @return representation of genre
     */
    @Override
    public String toString() {
        return "Genre: " +
                this.name;
    }
}
