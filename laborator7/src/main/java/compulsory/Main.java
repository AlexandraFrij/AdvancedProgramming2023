package compulsory;

public class Main {
    public static void main(String[] args) {
        SharedMemory sharedMemory = new SharedMemory(4);
        ExplorationMap explorationMap = new ExplorationMap(sharedMemory, 4);
        var explore = new Exploration(explorationMap, sharedMemory);
        explore.startRobots();
    }
}
