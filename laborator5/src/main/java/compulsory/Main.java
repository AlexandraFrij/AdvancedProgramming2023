package compulsory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        compulsory();
    }

    public static void compulsory() {
        // create a book
        var book = new Book("book1", "Six of Crows", "path/book path", "Leigh Bardugo", 2015);
        book.addTag("genre", "fantasy");
        //create a catalog, add book to catalog
        Catalog catalog = new Catalog("booksCatalog");
        catalog.add(book);
        //save catalog and verify the possible exceptions
        try {
            catalog.save("catalog.json");
            System.out.println("Catalog saved!");
        } catch (IOException e) {
            System.out.println("Could not save catalog" + e.getMessage());
        }
        //load catalog and verify the possible exceptions
        try {
            catalog.load("\"C:\\Users\\Stefania\\OneDrive\\Desktop\\programare avansata\\laborator5\\catalog.json\"");
            System.out.println("Catalog loaded! " + catalog.toString());
        } catch (InvalidCatalogException e) {
            System.out.println("Could not load catalog " + e.getMessage());
        }
    }
}
