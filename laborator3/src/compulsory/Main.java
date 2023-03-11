package compulsory;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        Person person1 = new Person("Alina");
        Person person2 = new Person("Maria");
        Person person3 = new Person("Mihai");
        Company company1 = new Company("Centric");
        Company company2 = new Company("Sevio");
        person1.addRelation(person2, "Friend");
        person2.addRelation(person3, "Husband");
        person3.addRelation(person2, "Wife");
        company1.addEmployee(person1, "Programmer");
        company1.addEmployee(person2, "Programmer");
        company2.addEmployee(person3, "Designer");
        nodes.add(person1);
        nodes.add(person2);
        nodes.add(person3);
        nodes.add(company1);
        nodes.add(company2);
        for(Node node: nodes)
            System.out.println(node.getName());
    }
}