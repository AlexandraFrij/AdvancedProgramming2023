package compulsory;

import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Describes the memory shared by all robots
 */
public class SharedMemory {
    private final LinkedList<Token> tokens;
    private final int size;

    /**
     * initialize the memory
     *
     * @param n dimension
     */
    public SharedMemory(int n) {
        tokens = new LinkedList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n * n * n; i++)
            numbers.add(i);
        Collections.shuffle(numbers);
        for (int number : numbers)
            tokens.add(new Token(number));
        this.size = n;
    }

    /**
     * @return Token objects list
     */
    public LinkedList<Token> getTokens() {
        return tokens;
    }

    /**
     * @return memory size
     */
    public int getSize() {
        return size;
    }

    /**
     * extracts Token objects list that will be added in a matrix
     *
     * @param howMany the number of Token objects
     * @return extracted Tokens
     */
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.poll());
        }
        return extracted;
    }

}
