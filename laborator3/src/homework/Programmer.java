package homework;

/**
 * describes a programmer which has a first learnt programming language
 * extends the Person class
 */
public class Programmer extends Person {
    private String firstProgrammingLanguage;

    /**
     * constructor method, initialize a programmer with the given attributes
     * calls the constructor from the Person class
     *
     * @param name      the programmer's name
     * @param birthdate the programmer's birthdate
     * @param language  programmer's first programming language
     */
    public Programmer(String name, String birthdate, String language) {
        super(name, birthdate);
        this.firstProgrammingLanguage = language;
    }

    /**
     * getter method for the firstProgrammingLanguage
     *
     * @return the first programming language learnt by the programmer
     */
    public String getFirstProgrammingLanguage() {
        return firstProgrammingLanguage;
    }

    /**
     * return a representation of an object
     *
     * @return information about a programmer such as name, birthdate and first programming language
     */
    @Override
    public String toString() {
        return "Programmer name: " + this.getName() +
                " birth date: " + this.getBirthdate() +
                " first programming language is: " + this.firstProgrammingLanguage;
    }
}
