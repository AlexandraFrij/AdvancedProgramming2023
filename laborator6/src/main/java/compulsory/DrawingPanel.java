package compulsory;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.*;

/**
 * describes the drawing panel of a board game
 */
public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 700, H = 500;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image

    /**
     * initiate the panel in the main frame
     *
     * @param frame the main frame
     */
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    /**
     * sets window's dimension and border
     */
    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                repaint();
            }
        });
    }

    /**
     * creates the panel
     */
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 700, 500);
    }

    /**
     * creates the game board
     * the graph is drawn
     */
    final void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    /**
     * computes the vertices' coordinates
     */
    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    /**
     * draws the lines of the graph
     */
    private void drawLines() {
        graphics.setColor(Color.GRAY);
        for (int i = 0; i < numVertices - 1; i++)
            for (int j = i + 1; j < numVertices; j++) {
                graphics.drawLine(x[i], y[i], x[j], y[j]);
            }
    }

    /**
     * draws the vertices in the graph
     */
    private void drawVertices() {
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++) {
            graphics.drawOval(x[i] - 3, y[i] - 3, 6, 6);
            graphics.fillOval(x[i] - 3, y[i] - 3, 6, 6);
        }

    }

    @Override
    public void update(Graphics g) {
    } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

}
