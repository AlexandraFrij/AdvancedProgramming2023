package org.example.entity;

import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * entity of type Album
 */
@Entity
@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "Album.findAll",
                query = "select e from Album e order by e.title"),
        @NamedQuery(name = "Album.findByID",
                query = "select e from  Album e where e.id = :id"),
        @NamedQuery(name = "Album.findByArtist",
                query = "select e from Album e where e.artist = :artist"),
        @NamedQuery(name = "Album.findByTitle",
                query = "select e from Album e where e.title = :title"),

})
public class Album extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "releaseYear")
    private int releaseYear;

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Column(name = "title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
   /* @Column
    private List<Genre> genres;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }*/

    public Album() {
    }

    /**
     * constructor method
     *
     * @param year   release year
     * @param title  album's title
     * @param artist band or singer
     */
    public Album(int year, String title, Artist artist/*, List<Genre> genres*/) {
        this.releaseYear = year;
        this.artist = artist;
        this.title = title;
        /* this.genres = genres;*/
    }

    /**
     * @return representation of object
     */
    @Override
    public String toString() {
        return "Album [ title: " +
                this.title +
                ", artist: " +
                this.artist.getName() +
                ", year: " +
                this.releaseYear +
                " ]";
    }
}
