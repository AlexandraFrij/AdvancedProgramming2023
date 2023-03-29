package compulsory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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


}
