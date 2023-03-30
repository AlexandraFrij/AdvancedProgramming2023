package homework;

/**
 * describes List command for a catalog
 */
public class ListCommand implements Command {
    private Catalog catalog;

    /**
     * constructor method, initialize the catalog
     *
     * @param catalog the catalog to be listed
     */
    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    /**
     * when called, it prints on the screen the content of the catalog
     */
    @Override
    public void run() {
        System.out.println(this.catalog.toString());
    }
}
