package compulsory;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

/**
 * describes the control panel of a board game
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    //create all buttons (Load, Exit, etc.)

    /**
     * initiate the panel in the main frame
     *
     * @param frame the main frame of the game
     */
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * adds exit, save, reset and load buttons
     */
    private void init() {
        //add all buttons
        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
    }

    /**
     * when exit buttons is pressed, closes the window
     *
     * @param e the current action
     */
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void saveGame(ActionEvent e) {
    }

    private void resetGame(ActionEvent e) {
    }

    private void loadGame(ActionEvent e) {
    }
}