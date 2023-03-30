package homework;

/**
 * describes add command for a catalog
 * implements Command interface
 */
public class AddCommand implements Command {
    private Catalog catalog;
    private Document document;

    /**
     * constructor method, initialize the catalog and document
     *
     * @param catalog  where a document will be added
     * @param document the document to be added
     */
    public AddCommand(Catalog catalog, Document document) {
        this.catalog = catalog;
        this.document = document;
    }

    /**
     * when called, it adds the document in the current catalog
     */
    @Override
    public void run() throws Exception {
        for(Document doc: catalog.getDocs())
        {
            if(doc.getId().equals(document.getId()))
                throw new Exception("Document already exists in catalog!");
        }
        catalog.addDoc(document);
        System.out.println("New document added!");
    }
}
