package compulsory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * describes a Document that has at least an id, title, location and a list of tags
 */
public abstract class Document implements Serializable {
    private String id;
    private String title;
    private String location;
    private Map<String, Object> tags;

    /**
     * constructor method, initialize a document
     *
     * @param id       document's id
     * @param title    document's title
     * @param location document's location
     */
    public Document(String id, String title, String location) {
        this.id = id;
        this.location = location;
        this.title = title;
        tags = new HashMap<>();
    }

    /**
     * setter method for id
     *
     * @param id document's id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getter method for if
     *
     * @return id's value
     */
    public String getId() {
        return id;
    }

    /**
     * setter method for title
     *
     * @param title document's title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getter method for title
     *
     * @return title's value
     */
    public String getTitle() {
        return title;
    }

    /**
     * setter method for location
     *
     * @param location document's location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * getter method for location
     *
     * @return location's value
     */
    public String getLocation() {
        return location;
    }

    /**
     * setter method for tags
     *
     * @param tags document's tags
     */
    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    /**
     * getter method for tags
     *
     * @return document's map of tags
     */
    public Map<String, Object> getTags() {
        return tags;
    }

    /**
     * adds a new tag to the map
     *
     * @param key   tag's key
     * @param value the key's value
     */
    public void addTag(String key, Object value) {
        tags.put(key, value);
    }

    /**
     * return a description of a Document object
     *
     * @return values for id, title, location and the map of tags
     */
    @Override
    public String toString() {
        return "Document= { id: " + this.id +
                " title: " + this.title +
                " location: " + this.location +
                " tags: " + this.tags +
                " }";
    }
}
