package compulsory;
import java.util.HashSet;
import java.util.Set;

/**
 * describes a Student that has a name and a set of Projects
 */
public class Student implements Comparable<Student>{
    private String name;
    private Set<Project> projects;

    /**
     * constructor method, initialize a student with a name
     * @param name student's name
     */
    public Student(String name) {
        this.name= name;
        this.projects = new HashSet<>();
    }

    /**
     * getter for name
     * @return student's name
     */
    public String getName() {
        return name;
    }

    /**
     * adds a project in a student's set
     * @param p the project to be added
     */
    public void addProject(Project p)
    {
        projects.add(p);
    }

    /**
     * getter method for project list
     * @return a copy to the projects set
     */
    public Set<Project> getProjects() {
        Set <Project> p = projects;
        return p;
    }

    /**
     * compares by name this Student object with other Student object
     * @param other the object to be compared.
     * @return -1 if this.name < other.name, 0 if equals, 1 otherwise
     */
    @Override
    public int compareTo(Student other)
    {
        return this.name.compareTo(other.name);
    }

    /**
     * describes a Student object
     * @return the name of a student
     */
    @Override
    public String toString()
    {
        return "Student name: " +this.name;
    }

}
