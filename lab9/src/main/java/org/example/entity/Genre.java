package org.example.entity;

import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * entity of type genre
 */
@Entity
@Table(name = "genres")
@NamedQueries({
        @NamedQuery(name = "Genre.findAll",
                query = "select e from Genre e order by e.name"),
        @NamedQuery(name = "Genre.findByID",
                query = "select e from  Genre e where e.id = :id"),
        @NamedQuery(name = "Genre.findByName",
                query = "select e from Genre e where e.name = :name"),

})
public class Genre extends AbstractEntity implements Serializable {
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
     * @param name genre's name
     */
    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }

    /**
     * @return representation of object
     */
    @Override
    public String toString() {
        return "Genre[ name: " +
                this.name +
                ", id: " +
                this.id +
                " ]";
    }
}
