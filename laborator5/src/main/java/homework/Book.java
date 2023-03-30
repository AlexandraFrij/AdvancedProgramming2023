package homework;

/**
 * describes a Book object
 * extends class Document
 */
public class Book extends Document {
    private String author;
    private int year;

    /**
     * constructor method, initialize the object
     *
     * @param id       book's id
     * @param title    book's title
     * @param location book's location
     * @param author   book's author
     * @param year     book's year of publication
     */
    public Book(String id, String title, String location, String author, int year) {
        super(id, title, location);
        this.author = author;
        this.year = year;
    }

    /**
     * getter method for author
     *
     * @return book's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * setter for author
     *
     * @param author author name
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * getter for year
     *
     * @return a book's publication year
     */
    public int getYear() {
        return year;
    }

    /**
     * setter for year
     *
     * @param year book's publication year
     */
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book= { id: " + this.getId() +
                " title: " + this.getTitle() +
                " author: " + this.author +
                " year: " + this.year +
                " location: " + this.getLocation() +
                " tags: " + this.getTags() +
                " }";
    }
}
