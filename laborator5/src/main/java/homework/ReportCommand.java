package homework;

import freemarker.template.TemplateException;
import freemarker.template.Template;
import freemarker.template.Configuration;

import java.io.*;

/**
 * describes Report command for a catalog
 * implements Command interface
 */
public class ReportCommand implements Command {
    private Catalog catalog;

    /**
     * constructor method, initialize the catalog
     *
     * @param catalog
     */
    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    /**
     * when called, it creats a report for the catalog
     *
     * @throws Exception exceptions for input/output or regarding the template
     */
    @Override
    public void run() throws Exception {
        try {
            Configuration config = new Configuration(Configuration.VERSION_2_3_31);
            config.setDirectoryForTemplateLoading(new File("C:/Users/Stefania/OneDrive/Desktop/programare avansata/laborator5/src/main/java/homework"));
            Template template = config.getTemplate("Template.ftl");
            Writer out = new OutputStreamWriter(new FileOutputStream("C:/Users/Stefania/OneDrive/Desktop/programare avansata/laborator5/src/main/java/homework/" + catalog.getName() + ".html"));
            template.process(catalog, out);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
