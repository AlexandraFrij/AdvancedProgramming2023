package compulsory;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String args[])
    {
        compulsory();
    }
    public static void compulsory()
    {
        // create list of Student objects
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        // create linked list, add students to it
        LinkedList<Student> studentList = new LinkedList<>();
        for(Student s : students)
        {
            studentList.add(s);
        }
        // create a second list of Student objects with the same name as previous, add to the linked list
        var students1 = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        for(Student s : students1)
        {
            studentList.add(s);
        }
        // print without sorting by name
        for(Student s : studentList)
        {
            System.out.println(s.getName());
        }
        // print sorting by names
        Collections.sort(studentList);
        for(Student s : studentList)
        {
            System.out.println(s.getName());
        }
        // create list of Project objects
        var projects = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Project("P" + i) )
                .toArray(Project[]::new);
        // create tree set, add projects to it
        TreeSet<Project> projectList = new TreeSet<>(Arrays.asList(projects));
        // print tree set, already sorted
        for(Project p : projectList)
        {
            System.out.println(p.getName());
        }

    }
}
