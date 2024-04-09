package a6;

/**
 * NAME: Jaiden Leonard
 * CLASS: CSPC-24500-001
 * ASSIGNMENT: Assignment 6
 * DATE: 4/8/2024
 * 
 * PURPOSE:
 * The purpose of this program is to allow the user to input the number of nodes they like into
 * an array list (Fill option). It will fill the list with Nodes and ThreeDNodes of random numbers within the
 * specified range. The user this is able to clear, count Nodes, count ThreeDNodes, sort, display, and exit.
 * 
 * STRUGGLES:
 * I had to do a little bit of research online because certain errors that came about during my time
 * doing this assignment didn't fully make sense to me but after a while I was able to figure them out
 * and everything is functional, at least from my testing.
 * 
 * NOTE:
 * If you have any suggestions about my code, please feel free to tell me about it, all criticism is
 * welcome both positive and negative. Thank you!
 */

public class Node implements INode {
	private static final int MINVAL = -100;
	private static final int MAXVAL = 100;
	private int x;
	private int y;
	
	/**
	 * Default constructor that sets the value of x and y to 0.
	 */
	public Node() {;
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Constructor to copy and create a new Node with the same coordinates.
	 * @param other (The Node that it copies from).
	 */
	public Node(Node other) {
		this.x = other.x;
		this.y = other.y;
	}
	
	/**
	 * Constructor that accepts the values for x and y.
	 * @param x (The x coordinate).
	 * @param y (The y coordinate).
	 */
	public Node(int x, int y) {
		validateX(x);
		validateY(y);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Method to validate the current value of x.
	 * @param x (The current value of x).
	 * @thorws IllegalArgumentException if the value of x is outside of the acceptable range.
	 */
	private void validateX(int x) {
		if (x < MINVAL || x > MAXVAL) {
			throw new IllegalArgumentException("The value of x must be in the range of [" + MINVAL + ','
					+ MAXVAL + "].");
		}
		
	}
	
	/**
	 * Method to validate the current value of y.
	 * @param y (The current value of y).
	 * @thorws IllegalArgumentException if the value of y is outside of the acceptable range.
	 */
	private void validateY(int y) {
		if (y < MINVAL || y > MAXVAL) {
			throw new IllegalArgumentException("The value of y must be in the range of [" + MINVAL + ','
					+ MAXVAL + "].");
		}
	}
	
	/**
	 * Sets the coordinate of x.
	 * @param x (The value of x).
	 */
	public void setX(int x) {
		validateX(x);
		this.x = x;
	}
	
	/**
	 * sets the coordinate of y.
	 * @param y (The value of y).
	 */
	public void setY(int y) {
		validateY(y);
		this.y = y;
	}
	
	/**
	 * Gets the x coordinate.
	 * @return the value of x.
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Gets the y coordinate.
	 * @return the value of y.
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Adds the coordinates of the given node to the other.
	 * @param other (The node to add to the current).
	 */
	public void add(Node other) {
		int newX = this.x + other.x;
		int newY = this.y + other.y;
		
		validateX(x);
		validateY(y);
		
		this.x = newX;
		this.y = newY;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Node(x=" + x + ",y=" + y + ")";
	}
	
	//equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Node node = (Node) obj;
		return x == node.x && y == node.y;
	}
	
    /**
     * Compares this node with the specified node for order.
     * @param otherNode The node to compare to.
     * @return a negative integer, zero, or a positive integer as this node is less than, equal to, or greater than the specified node.
     */
    public int compareTo(Node otherNode) {
        // Compare based on the x-coordinate first
        int xComparison = Integer.compare(this.x, otherNode.x);
        if (xComparison != 0) {
            return xComparison;
        }
        // If x-coordinates are equal, compare based on the y-coordinate
        return Integer.compare(this.y, otherNode.y);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Node) {
            Node other = (Node) o;
            int xComparison = Integer.compare(this.x, other.x);
            if (xComparison != 0) {
                return xComparison;
            }
            return Integer.compare(this.y, other.y);
        }
        throw new IllegalArgumentException("Object is not an instance of Node");
    }
    
    public int getCoordinateSum() {
        return getX() + getY();
    }
}
