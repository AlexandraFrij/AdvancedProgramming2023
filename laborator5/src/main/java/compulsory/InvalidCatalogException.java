package compulsory;

/**
 * extends class Exception
 * custom exception for class Catalog
 */
public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(String message) {
        super(message);
    }
}
