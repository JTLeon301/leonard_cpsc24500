package a6;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Nodes {
    private ArrayList<INode> nodeList;

    public Nodes() {
        this.nodeList = new ArrayList<>();
    }

    /**
     * Fills the nodeList with nodes of Nodes and ThreeDNodes up to the specified size.
     * If the nodeList is not empty, it will be cleared before filling.
     * @param size The number of nodes to fill.
     * @throws Exception If an error occurs during node creation or adding to the nodeList.
     */
    public void fill(int size) throws Exception {
        this.nodeList.clear(); // Clear the list before filling it, assuming a fresh start each time fill is called.
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            if (random.nextBoolean()) {
                this.nodeList.add(NodeFactory.getNode());
            } else {
                this.nodeList.add(NodeFactory.getThreeDNode());
            }
        }
    }

    public void clear() {
        this.nodeList.clear();
    }

    public int countNodes() {
        int count = 0;
        for (INode node : this.nodeList) {
            if (node instanceof Node && !(node instanceof ThreeDNode)) {
                count++;
            }
        }
        return count;
    }

    public int countThreeDNodes() {
        int count = 0;
        for (INode node : this.nodeList) {
            if (node instanceof ThreeDNode) {
                count++;
            }
        }
        return count;
    }

    // Method to sort nodes using Sorter
    public void sort() {
        this.nodeList.sort(new Sorter());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (INode node : this.nodeList) {
            sb.append(node.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Sorter class for sorting nodes based on the sum of their coordinates.
     */
    private static class Sorter implements Comparator<INode> {
        @Override
        public int compare(INode o1, INode o2) {
            int sum1 = o1.getCoordinateSum();
            int sum2 = o2.getCoordinateSum();
            return Integer.compare(sum1, sum2);
        }
    }
}