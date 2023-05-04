package homework;

/**
 * describes an artist
 */
public class Artist {
    private String name;
    private int id;

    /**
     * initialise an artist
     *
     * @param id   id in table Artists
     * @param name artist's name
     */
    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return representation of artist
     */
    @Override
    public String toString() {
        return "Artist name: " +
                this.name;

    }
}
