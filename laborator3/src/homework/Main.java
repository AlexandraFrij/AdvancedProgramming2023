package homework;


public class Main {
    public static void main(String[] args) { homework();}
    public static void homework()
    {
        Network network = new Network();
        Programmer programmer1 = new Programmer("Ion", "23/12/1990", "C++");
        Programmer programmer2 = new Programmer("Maria", "09/02/1994", "Phyton");
        Designer designer1 = new Designer("Claudia", "10/10/1992", "Flower shop app");
        Designer designer2 = new Designer("Sofia", "04/07/1997", "Music app");
        Company company1 = new Company("Centric", 12);
        Company company2 = new Company("Sevio", 10);
        programmer1.addRelation(designer1, "wife");
        programmer1.addRelation(company2, "programmer");
        programmer1.addRelation(programmer2, "sister");
        programmer2.addRelation(programmer1, "brother");
        programmer2.addRelation(company1, "designer");
        designer2.addRelation(company2,"designer");
        designer1.addRelation(programmer1, "husband");
        company2.addEmployee(programmer1, "programmer");
        company1.addEmployee(designer1, "designer");
        network.addNode(programmer1);
        network.addNode(programmer2);
        network.addNode(designer1);
        network.addNode(designer2);
        network.addNode(company1);
        network.addNode(company2);
        //System.out.println(programmer1.getName());
       // System.out.println(programmer1.toString());
        network.printByImportance();
       // System.out.println(network.returnImportance(company1));
    }
}