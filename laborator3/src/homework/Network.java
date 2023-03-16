package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/**
 * Describes a network that contains objects of type Node (persons or companies)
 */
public class Network {
    private List<Node> nodes;

    /**
     * constructor method, initialize the array of nodes
     */
    public Network() {
        nodes = new ArrayList<>();
    }

    /**
     * method used to add nodes in the network
     * @param node the object to be added
     */
    public void addNode(Node node) {
        nodes.add(node);
    }

    /**
     * print method for an array of nodes ( a network)
     */
    public void print() {
        for (Node node : nodes) System.out.println(node.toString());
    }

    /**
     * method that computes the importance of a node
     * importance is measured in the number of relationships a node has
     * @param node the object for which the importance will be calculated
     * @return the importance of a node
     */
    public int returnImportance(Node node) {
        int importance = 0;
        if (node instanceof Person) {
            for (Node n : nodes)
                if (n != node && (((Person) node).getRelationships()).containsKey(n)) importance++;
        } else if (node instanceof Company) {
            for (Node n : nodes)
                if (n != node && (((Company) node).getEmployees()).containsKey(n)) importance++;
        }
        return importance;
    }

    /**
     * the method prints the nodes in a network ascending, based of their importance
     */
    public void printByImportance()
    {
        Collections.sort(nodes, new Comparator<Node>()
        {
            @Override
                    public int compare(Node node1, Node node2)
            {
                return Integer.compare(returnImportance(node1), returnImportance(node2));
            }
        });
        for (Node node : nodes) System.out.println(node.toString());
    }
}