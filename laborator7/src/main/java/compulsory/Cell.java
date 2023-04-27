package compulsory;

import java.util.List;
import java.util.ArrayList;

/**
 * Describes a list of Tokens
 */
public class Cell {
    private List<Token> tokens;
    private boolean visited;

    /**
     * initialize the Cell
     */
    public Cell() {
        this.tokens = new ArrayList<>();
        visited = false;
    }

    public void addToken(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void wasVisited() {
        this.visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    @Override
    public String toString() {
        return "Cell: " + tokens + " is visited: " + visited;
    }
}
