package compulsory;

/**
 * describes a Project that has a name
 */
public class Project implements Comparable<Project>{
    private String name;

    /**
     * constructor method, initialize a project with a name
     * @param name project's name
     */
    public Project(String name) {
        this.name = name;
    }

    /**
     * getter method for name
     * @return project's name
     */
    public String getName() {
        return name;
    }

    /**
     * compares by name this Project object with other Project object
     * @param other the object to be compared.
     * @return -1 if this.name < other.name, 0 if equals, 1 otherwise
     */
    @Override
    public int compareTo(Project other)
    {
        return this.name.compareTo(other.name);
    }

    /**
     * compares, based on the name, this Project object with another Project object
     * @param obj the object given for comparison
     * @return true if this object equal or have the same name, false if this.name != other.name sau obj is not a Project object
     */
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(!(obj instanceof Project)) return false;
        return this.getName() == ((Project)(obj)).getName();

    }

    /**
     * return a hash code fot this Project object based on the name
     * @return the hash code
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime* result + ((name == null)? 0 : name.hashCode());
        return result;

    }

    /**
     * describes a Project object
     * @return project's name
     */
    @Override
    public String toString()
    {
        return "Project: " + this.name;
    }
}
