package compulsory;

import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 * describes the main frame of a board game
 */
public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    /**
     * initialize the frame adding the configuration panel at the top
     */
    public MainFrame() {
        super("My Drawing Application");
        configPanel = new ConfigPanel(this);
        add(configPanel, BorderLayout.NORTH);
        init();
    }

    /**
     * initialize the rest of the frame with a drawing panel and a control panel
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //create the components
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        add(controlPanel, BorderLayout.SOUTH);
        //invoke the layout manager
        pack();
    }
}
