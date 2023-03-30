package homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import compulsory.InvalidCatalogException;

import java.io.File;
import java.io.IOException;

/**
 * describes load command of a catalog
 * implements Command interface
 */
public class LoadCommand implements Command {
    private String path;

    /**
     * constructor method, initialize the path of a catalog
     *
     * @param path location of a catalog
     */
    public LoadCommand(String path) {
        this.path = path;
    }

    /**
     * when called, it loads, if possible, the catalog at the given path
     *
     * @throws InvalidCatalogException exception regarding the state of a catalog (error loading or not a catalog)
     */
    @Override
    public void run() throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Object loadedObject = objectMapper.readValue(new File(path), Object.class);
            if (loadedObject instanceof Catalog) System.out.println("The catalog: " + (Catalog) loadedObject);
            else throw new InvalidCatalogException("Object is not a Catalog");
        } catch (IOException e) {
            throw new InvalidCatalogException("Error loading catalog from file");
        }
    }
}
