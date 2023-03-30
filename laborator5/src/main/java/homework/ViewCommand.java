package homework;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * describes View command for a document
 * implements Command interface
 */
public class ViewCommand implements Command {
    private Path path;
    private URI uri;

    /**
     * constructor method, verifies if the path given as string is a URI or file
     *
     * @param path a document's location
     * @throws URISyntaxException exception regarding the URI
     */
    public ViewCommand(String path) throws URISyntaxException {
        if (path.startsWith("https://") || path.startsWith("http://")) {
            try {
                this.uri = new URI(path);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        } else
            this.path = Paths.get(path);
    }

    /**
     * when called, it opens in browser a URI of on desktop other files
     */
    @Override
    public void run() {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                if (path != null)
                    desktop.open(path.toFile());
                else
                    desktop.browse(uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Desktop is not supported");
        }
    }
}
