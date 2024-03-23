package a5;
/*
 * The purpose of this class is to test out the functionality of the Node class
 */
public class NodeTest {
		public static void main(String[] args) {
	        testDefaultConstructor();
	        testParameterizedConstructor();
	        testCopyConstructor();
	        testSettersAndGetters();
	        testAddMethod();
	        testToString();
	        testEqualsMethod();
	    }

	    public static void testDefaultConstructor() {
	        Node defaultNode = new Node();
	        System.out.println("Default Node: " + defaultNode);
	    }

	    public static void testParameterizedConstructor() {
	        Node paramNode = new Node(10, 20);
	        System.out.println("Param Node: " + paramNode);
	    }

	    public static void testCopyConstructor() {
	        Node paramNode = new Node(10, 20);
	        Node copyNode = new Node(paramNode);
	        System.out.println("Copy of paramNode: " + copyNode);
	    }

	    public static void testSettersAndGetters() {
	        Node node = new Node();
	        node.setX(30);
	        node.setY(40);
	        System.out.println("Node after setting coordinates: " + node);
	        System.out.println("X coordinate: " + node.getX());
	        System.out.println("Y coordinate: " + node.getY());
	    }

	    public static void testAddMethod() {
	        Node node1 = new Node(50, 60);
	        Node node2 = new Node(20, 30);
	        node1.add(node2);
	        System.out.println("After adding node2 to node1: " + node1);
	    }

	    public static void testToString() {
	        Node node = new Node(70, 80);
	        String str = node.toString();
	        System.out.println("String representation of node: " + str);
	    }

	    public static void testEqualsMethod() {
	        Node node1 = new Node(50, 60);
	        Node node2 = new Node(50, 60);
	        System.out.println("Are node1 and node2 equal? " + node1.equals(node2));
	    }
}
