package homework;
import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) { homework();}
    public static void homework()
    {
        Faker faker = new Faker();
        Student S0 = new Student(faker.name().fullName());
        Student S1 = new Student(faker.name().fullName());
        Student S2 = new Student(faker.name().fullName());
        Student S3 = new Student(faker.name().fullName());
        Project P0 = new Project(faker.app().name());
        Project P1 = new Project(faker.app().name());
        Project P2 = new Project(faker.app().name());
        Project P3 = new Project(faker.app().name());
        Project P4 = new Project(faker.app().name());
        Project P5 = new Project(faker.app().name());
        Project P6 = new Project(faker.app().name());
        S0.addProject(P0);
        S0.addProject(P3);
        S0.addProject(P5);
        S1.addProject(P1);
        S1.addProject(P2);
        S2.addProject(P4);
        S2.addProject(P6);
        S2.addProject(P2);
        S2.addProject(P0);
        S3.addProject(P4);
        S3.addProject(P1);
        S3.addProject(P6);
        Problem problem = new Problem();
        problem.addPreference(S0, S0.getProjects());
        problem.addPreference(S1,S1.getProjects());
        problem.addPreference(S2, S2.getProjects());
        problem.addPreference(S3,S3.getProjects());
        problem.displayStudentsWithLessProjects();
        problem.setProjects();

    }
}
