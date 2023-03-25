package compulsory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * describes a catalog that consists of a list of documents and has a name
 */
public class Catalog implements Serializable {
    private String name;
    private List<Document> docs;

    /**
     * constructor method, initialize the name and the list of documents
     *
     * @param name catalog's name
     */
    public Catalog(String name) {
        this.name = name;
        docs = new ArrayList<>();
    }

    /**
     * getter method for name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * setter method for name
     *
     * @param name the value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method for docs
     *
     * @return the documents in the list
     */
    public List<Document> getDocs() {
        return docs;
    }

    /**
     * setter method for docs
     *
     * @param docs a list of documents
     */
    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    /**
     * adds a new document to the list
     *
     * @param document the document to be added
     */
    public void add(Document document) {
        docs.add(document);
    }

    /**
     * returns a description of a Catalog object
     *
     * @return the values for name and docs
     */
    @Override
    public String toString() {
        return "Catalog= { name: " + this.name +
                " documents: " + this.docs;
    }

    /**
     * saves the current catalog in the given path
     *
     * @param path the path used for saving
     * @throws IOException possible exceptions at input/output
     */
    public void save(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), this);
    }

    /**
     * loads a catalog from the given path
     *
     * @param path the path were the catalog is located
     * @return the catalog
     * @throws InvalidCatalogException custom exception for the class
     */
    public static Catalog load(String path) throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Object loadedObject = objectMapper.readValue(new File(path), Object.class);
            if (loadedObject instanceof Catalog) {
                return (Catalog) loadedObject;
            } else {
                throw new InvalidCatalogException("Object is not a Catalog");
            }
        } catch (IOException e) {
            throw new InvalidCatalogException("Error loading catalog from file");
        }
    }

}
