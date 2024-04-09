package a6;
import java.util.Scanner;

public class Driver {
	//create a Nodes object
    private static Nodes nodes = new Nodes();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        //print options menu to the user
        while (running) {
            System.out.println("Options:");
            System.out.println("1. Fill");
            System.out.println("2. Clear");
            System.out.println("3. Count Nodes");
            System.out.println("4. Count ThreeDNodes");
            System.out.println("5. Sort");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.print("Enter your option: ");

            int userChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (userChoice) {
            	//case to fill the array list
                case 1:
                    fill();
                    break;
                //case to clear the list
                case 2:
                    clear();
                    break;
                //case to count the number of Nodes
                case 3:
                    countNodes();
                    break;
                //case to count the ThreeDNodes
                case 4:
                    countThreeDNodes();
                    break;
                //case to sort the nodes
                case 5:
                    sort();
                    break;
                //case to display the nodes
                case 6:
                    display();
                    break;
                //case to terminate the program
                case 7:
                	System.out.println("\nThank you for using this program.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
        scanner.close();
    }

    //method to fill the array list with Nodes and ThreeDNodes when called
    private static void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        try {
            nodes.fill(size);
            System.out.println("Array has been filled successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //method to clear nodes
    private static void clear() {
        nodes.clear();
        System.out.println("Nodes cleared.");
    }

    //method to count nodes
    private static void countNodes() {
        System.out.println("Number of Nodes: " + nodes.countNodes());
    }

    //method to count ThreeDNodes
    private static void countThreeDNodes() {
        System.out.println("Number of ThreeDNodes: " + nodes.countThreeDNodes());
    }

    //method to sort nodes
    private static void sort() {
        nodes.sort();
        System.out.println("Nodes sorted.");
    }

    //method to display nodes
    private static void display() {
        System.out.println(nodes.toString());
    }
}
