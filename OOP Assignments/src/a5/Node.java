package a5;

/**
 * NAME: Jaiden Leonard
 * CLASS: CSPC-24500-001
 * ASSIGNMENT: Assignment 5
 * DATE: 3/22/2024
 * 
 * PURPOSE:
 * The purpose of this class is to represent a 2D array system with x and y coordinates which can range 
 * from -100 to 100. This can be a multi-use program which has a foundation for complex data structures
 * or applications with spatial data.
 * 
 * STRUGGLES:
 * Honestly I ddin't really struggle with this after watching all the method being created in the in-class
 * example with the shapes. It was a little bit time consuming and the validation took a few minutes to
 * figure out, tweak, and test; but overall the assignment was pretty simple and straight-forward.
 * 
 * NOTE:
 * If you have any suggestions about my code, please feel free to tell me about it, all criticism is
 * welcome both positive and negative. Thank you!
 */

public class Node {
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
	 * Method to validate whether x and y are within the acceptable ranges.
	 * @param x (The current value of x to check).
	 * @param y (The current value of y to check).
	 */
	/*
	private void validateRange(int x, int y) {
		validateX(x);
		validateY(y);
	}
	*/
	
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

}
