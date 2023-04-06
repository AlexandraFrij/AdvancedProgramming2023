package homework;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.*;
import java.util.HashSet;
import java.lang.Math;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 * describes the drawing panel of a board game
 */
public class DrawingPanel extends JPanel {
    MainFrame frame;
    final static int W = 700, H = 500;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    private int edgesColored;
    private Edges edges;
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
        edgesColored = 0;
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        redrawEdges();
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
        edges = new Edges(numVertices);
        edges.initMatrix();
        int numberOfEdges = (int) (numVertices * edgeProbability);
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < numberOfEdges) {
            set.add(random.nextInt(numVertices));
        }
        graphics.setColor(Color.GRAY);
        for (int i = 0; i < numVertices - 1; i++)
            for (int j : set) {
                graphics.drawLine(x[i], y[i], x[j], y[j]);
                edges.setEdge(i, j);
            }
    }

    /**
     * computes the distances between a given point and all graph's nodes
     *
     * @param x1 x coordinate of the point
     * @param y1 y coordinate
     * @return an array of distances
     */
    public double[] computeDistances(int x1, int y1) {
        double[] distances = new double[numVertices];
        for (int i = 0; i < numVertices; i++) {
            distances[i] = Math.sqrt((x1 - x[i]) * (x1 - x[i]) + (y1 - y[i]) * (y1 - y[i]));
        }
        return distances;
    }

    /**
     * redraws a selected line either in red or blue
     */
    public void redrawEdges() {
        // add a mouse listener
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                //get coordinates of mouse
                int mouseX = e.getX();
                int mouseY = e.getY();
                int edge1 = -1;
                int edge2 = -1;
                // compute distance between mouse and nodes
                double[] distances = computeDistances(mouseX, mouseY);
                for (int i = 0; i < numVertices - 1 && edge1 == -1; i++) {
                    for (int j = i + 1; j < numVertices; j++) {
                        if (edges.getEdge(i, j) == 1) {
                            //using formula for the distance between 2 points, find the edge it was clicked on
                            double distance = Math.sqrt((x[j] - x[i]) * (x[j] - x[i]) + (y[j] - y[i]) * (y[j] - y[i]));
                            if ((int) distance == (int) (distances[i] + distances[j])) {
                                edge1 = i;
                                edge2 = j;
                                break;
                            }
                        }
                    }
                }
                // if the number of colored edges is odd, the edge will be blue, else red
                if (edgesColored % 2 == 0) {
                    graphics.setColor(Color.RED);
                    edges.setColor(edge1, edge2, "red");
                } else {
                    graphics.setColor(Color.BLUE);
                    edges.setColor(edge1, edge2, "blue");
                }
                edgesColored++;
                //draw colored edge
                graphics.drawLine(x[edge1], y[edge1], x[edge2], y[edge2]);
                repaint();
                //verify if there is a winner
                String winner = edges.getWinner();
                if (winner.equals("No winner yet") == false)
                    JOptionPane.showMessageDialog(frame, winner);
            }
        });

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

