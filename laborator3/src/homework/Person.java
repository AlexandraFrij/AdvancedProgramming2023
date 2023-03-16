package homework;

import java.util.Map;
import java.util.HashMap;

/**
 * Represents a person, including their name, relationships, and employer
 */
public class Person implements Node, Comparable<Person> {
    private String name;
    private String birthdate;
    private Map<Node, String> relationships;
    private Company employer;

    /**
     * constructor method, initialize a person's name
     *
     * @param name the person's name
     */
    public Person(String name, String birthDate) {
        this.name = name;
        this.birthdate = birthDate;
        this.relationships = new HashMap<>();
        this.employer = null;
    }

    /**
     * getter method for the name
     *
     * @return the person's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * getter method for the birthDate field
     *
     * @return the birthdate of a person
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * getter method for relationships field
     *
     * @return the map of relationships for a person
     */

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    /**
     * setter method for employer
     *
     * @param employer the company where the person is working
     */
    public void setEmployer(Company employer) {
        this.employer = employer;
    }

    /**
     * getter method for the company
     *
     * @return the company where the person is working
     */
    public Company getEmployer() {
        return this.employer;
    }

    /**
     * add a new person and the relationship it has with the current person
     *
     * @param node an object that can be either a person or company
     * @param type the relationship
     */
    public void addRelation(Node node, String type) {
        relationships.put(node, type);
    }

    /**
     * gets the relationship between 2 persons
     *
     * @param person an object of type Person
     * @return the relationship between person (parameter) and the current person
     */
    public String getRelationBetween(Person person) {
        return relationships.get(person);
    }

    /**
     * compares the person's name with another person's name
     * returns -1 if the person's name is less than the other's name, 0 if the names are equal or 1 otherwise
     *
     * @param other the object to be compared.
     * @return -1 if person's name < other's name, 0 if person's name = other's name, 1 if person's name > other's name
     */
    @Override
    public int compareTo(Person other) {
        if (other instanceof Person)
            return this.name.compareTo(other.name);
        return -1;
    }

    /**
     * returns a representation of the object
     *
     * @return information about a person such as name and birthdate
     */
    @Override
    public String toString() {
        return "Person name: " + this.name + "birth date: " + this.birthdate;
    }
}

