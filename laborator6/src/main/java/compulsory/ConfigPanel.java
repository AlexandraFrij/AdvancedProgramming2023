package compulsory;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;

/**
 * describes the configuration panel for a board game
 */
public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;

    /**
     * initiate the panel in the frame
     *
     * @param frame the main frame of the game
     */
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * adds fields for number of vertices and lines
     * adds a "new game" button
     */
    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        linesLabel = new JLabel("Line probability:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesCombo = new JComboBox<>(new Double[]{1.0, 0.75, 0.5, 0.25});
        createButton = new JButton("Create new game");
        //create the rest of the components
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }
}

