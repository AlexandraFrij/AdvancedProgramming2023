package compulsory;

import java.util.Map;
import java.util.HashMap;

/**
 * Describes a company that has a name, a list of employees and their specialization
 */
public class Company implements Node, Comparable<Company> {
    private String name;
    private Map<Person, String> employees;

    /**
     * constructor method, initialize the company with a given name
     *
     * @param name the name of the company
     */
    public Company(String name) {
        this.name = name;
        this.employees = new HashMap<>();
    }

    /**
     * getter method for the name
     *
     * @return the company's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * add an employee and their specialization to the employees list
     * it also set the employee's company to the current company
     *
     * @param person   the employee
     * @param position the specialization
     */
    public void addEmployee(Person person, String position) {
        employees.put(person, position);
        person.setEmployer(this);
    }

    /**
     * verifies if a person is employed in the company
     *
     * @param person the possible employee
     * @return true id the person is employed, false otherwise
     */
    public boolean isEmployed(Person person) {
        return employees.containsKey(person);
    }

    /**
     * returns a given employee's specialization
     *
     * @param person the employee
     * @return the specialization the employee has
     */
    public String hasThePosition(Person person) {
        return employees.get(person);
    }

    /**
     * compares the company's name with another company's name
     * returns -1 if the company's name is less than the other's name, 0 if the names are equal or 1 otherwise
     *
     * @param other the object to be compared.
     * @return -1 if company's name < other's name, 0 if company's name = other's name, 1 if company's name > other's name
     */
    @Override
    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
    }

    /**
     * returns a representation of the object
     *
     * @return the message "Company name: " followed by the company's name
     */
    @Override
    public String toString() {
        return "Company name: " + this.name;
    }
}
