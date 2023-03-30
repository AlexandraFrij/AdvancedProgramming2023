package homework;

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws Exception {
        //use view command to open a file and an uri
        /*ViewCommand view = new ViewCommand("C:/Users/Stefania/OneDrive/Desktop/programare avansata/laborator5/src/main/java/homework/SixOfCrows.txt");
        view.run();
        ViewCommand view1 = new ViewCommand("https://ro.pinterest.com/");
        view1.run();*/
        //create a catalog and few entries
        Catalog catalog1 = new Catalog("Books");
        Book book1 = new Book("12a", "Pride and Prejudice", "src\\main\\java\\homework\\Pride&Prejudice.txt", "Jane Austen", 1813);
        Book book2 = new Book("11a", "Six of Crows", "src\\main\\java\\homework\\SixOfCrows.txt", "Leigh Bardugo", 2015);
        // add documents to catalog
        AddCommand addBook1 = new AddCommand(catalog1, book1);
        addBook1.run();
        AddCommand addBook2 = new AddCommand(catalog1, book2);
        addBook2.run();
        //try to add copy
       /* Book book3 = new Book("11a", "Six of Crows", "src\\main\\java\\homework\\SixOfCrows.txt", "Leigh Bardugo", 2015);
        AddCommand addBook3 = new AddCommand(catalog1, book3);
        addBook3.run();*/
        //try loading a catalog
        /*LoadCommand load =new LoadCommand("catalog.json");
        load.run();*/
        //list the catalog
        ListCommand list = new ListCommand(catalog1);
        list.run();
        //create a report
        ReportCommand report = new ReportCommand(catalog1);
        report.run();

    }

}
