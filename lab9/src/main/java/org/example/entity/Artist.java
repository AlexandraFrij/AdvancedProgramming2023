package org.example.entity;

import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * entity of type Artist
 */
@Entity
@Table(name = "artists")
@NamedQueries({
        @NamedQuery(name = "Artist.findAll",
                query = "select e from Artist e order by e.name"),
        @NamedQuery(name = "Artist.findByID",
                query = "select e.name from  Artist e where e.id = :id"),
        @NamedQuery(name = "Artist.findByName",
                query = "select e.id from Artist e where e.name = :name"),
        @NamedQuery(name = "Artist.findID",
                query = "select e from Artist e where e.name = :name"),
})
public class Artist extends AbstractEntity implements Serializable {
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

    @Column(name = "name")
    private String name;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    /**
     * constructor method
     *
     * @param name artist's name
     */
    public Artist(String name) {

        this.name = name;
    }

    public Artist() {
    }

    @OneToMany(mappedBy = "artist")
    private List<Album> album = new ArrayList<>();

    /**
     * @return representation of object
     */
    @Override
    public String toString() {
        return "Artist[ name: " +
                this.name +
                ", id: " +
                this.id +
                " ]";
    }
}
