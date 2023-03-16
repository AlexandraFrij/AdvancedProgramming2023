package homework;

/**
 * describes a designer which has a favorite project
 * extends class Person
 */
public class Designer extends Person {
    private String favoriteProject;

    /**
     * constructor method for class Designer, initialize an object with the given arguments
     * calls the constructor from Person class
     *
     * @param name      designer's name
     * @param birthdate designer's birthdate
     * @param project   designer's favorite project
     */
    public Designer(String name, String birthdate, String project) {
        super(name, birthdate);
        this.favoriteProject = project;
    }

    /**
     * setter method, updates the favoriteProject with the given value
     *
     * @param favoriteProject the new value for favoriteProject
     */
    public void setFavoriteProject(String favoriteProject) {
        this.favoriteProject = favoriteProject;
    }

    /**
     * getter method for favoriteProject
     *
     * @return the value of favoriteProject
     */
    public String getFavoriteProject() {
        return favoriteProject;
    }

    /**
     * return a representation of an object
     *
     * @return information about a designer such as name, birthdate and favorite project
     */
    @Override
    public String toString() {
        return "Designer name: " + this.getName() +
                " birth date: " + this.getBirthdate() +
                " favorite project is : " + this.favoriteProject;
    }
}
