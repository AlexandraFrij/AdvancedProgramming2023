package homework;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Collections;
/**
 * describes a Problem that consists of students and a list of projects for each student
 */
public class Problem {
    private Map<Student, List<Project>> prefMap;

    /**
     * constructor method for class, initialize the map
     */
    public Problem() {
        this.prefMap = new HashMap<>();
    }

    /**
     * adds a student and his list of projects to the problem
     * @param student the student added
     * @param projects his list of preferred-projects
     */
    public void addPreference(Student student, List<Project> projects) {
        this.prefMap.put(student, projects);
    }

    /**
     * calculates the average number of projects for students
     * @return the value of average number of projects
     */
    public double avgPreferences() {
        return prefMap.values()
                .stream()
                .mapToLong(List::size)
                .sum() / (double) prefMap.size();
    }

    /**
     * displays the students for which the number of preferred projects is less than the average number
     */
    public void displayStudentsWithLessProjects() {
        double avg = avgPreferences();
        System.out.println("Student with fewer preferences then average are:");
        List<Student> students = prefMap.keySet()
                .stream()
                .filter(student -> prefMap.get(student).size() < avg)
                .toList();
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    /**
     * sets for each student a project from his own list
     * if a project is still available and present in the student's list, then is assigned to that student and not available anymore
     */
    public void setProjects()
    {
        //the map with each student and their corresponding project
        Map <Student, Project> matches = new HashMap<>();
        //list of students from the prefMap, random displayed
        List<Student> students = new ArrayList<>(prefMap.keySet());
        Collections.shuffle(students);
        for(Student student:students)
        {
            // the list of projects for the current student
            List<Project> projects = new ArrayList<>(prefMap.get(student));
            for(Project project:projects)
                //if the project is available, then it is assigned to the students and the loop breaks
                 if(project.isAvailable()) {
                        matches.put(student, project);
                        project.setAvailable(false);
                        break;
                    }
        }
        //display the students and their projects
        for (Map.Entry<Student, Project> entry : matches.entrySet()) {
            System.out.println(entry.getKey().getName() + " is assigned to " + entry.getValue().getName());
        }
    }
    /**
     * describes a Problem object
     * @return the list of students and their preferred projects
     */
    @Override
    public String toString() {
        return "Problem{" +
                "prefMap=" + prefMap +
                '}';
    }
}
