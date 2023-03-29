package compulsory;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class CatalogUtil {
    /**
     * saves the current catalog in the given path
     * @param catalog the catalog to be saved
     * @param path the path used for saving
     * @throws IOException possible exceptions at input/output
     */
    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }
    /**
     * loads a catalog from the given path
     * @param path the path were the catalog is located
     * @return the catalog
     * @throws InvalidCatalogException custom exception for the class
     */
    public static Catalog load( String path) throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Object loadedObject = objectMapper.readValue(new File(path), Object.class);
            if (loadedObject instanceof Catalog) {
                return (Catalog) loadedObject;
            } else {
                throw new InvalidCatalogException("Object is not a Catalog");
            }
        } catch (IOException e) {
            throw new InvalidCatalogException("Error loading catalog from file");
        }
    }

}
