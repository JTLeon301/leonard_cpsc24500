import java.util.Random;
import java.util.Scanner;

/**
 * NAME: Jaiden Leonard
 * DATE: February 23rd, 2023
 * CLASS: Object Oriented Programming
 * ASSIGNMENT: Rock, Paper, Scissors
 * 
 * PURPOSE:
 * The purpose of this program is to create a game of rock, paper, scissors, that the user chooses
 * options 1, 2, or 3 depending on what they want and the CPU's choice is created by a RNG and the
 * conditions are tested to determine who the winner is.
 * 
 * STRUGGLES:
 * I have never used JavaDoc comments before so I had to look up how to implement them into my code.
 * I am also not entirely sure what specifically is supposed to be found within JavaDoc comments so I
 * am adding this block comment into it.
 * 
 * NOTE:
 * If you have any advice, tips, or comments to help me improve my code, good or bad, please let me know. 
 * All criticism is welcomed! Thank you!
 */

public class RockPaperScissors {
	//tieBreaker method to continue playing the game until a winner is reached
	private static void tieBreaker(Scanner sc) {
		//initialize variables
		int userOption = 0;
		int cpuOption = 0;
		
		//import RNG
		Random rn = new Random();
		
		//do-while loop to get userOption and validate
		do {
		    System.out.print("What do you choose? (1-3): ");
		    while (!sc.hasNextInt()) {
		        System.out.println("Invalid input! Please enter a number between 1 and 3.");
		        sc.next();
		    }
		    userOption = sc.nextInt();
		    if (userOption < 1 || userOption > 3) {
		        System.out.println("Invalid input! Please enter a number between 1 and 3.");
		    }
		} while (userOption < 1 || userOption > 3);
		
		//generate the CPU's option
		cpuOption = rn.nextInt(3) + 1;
		
		//display the CPU's option
		System.out.println("\nThe CPU chose... ");
		
		//switch statement to show the CPU's option
		switch (cpuOption) {
		case 1:
			System.out.println("Rock!");
			break;
		case 2:
			System.out.println("Paper!");
			break;
		case 3:
			System.out.println("Scissors!");
			break;
		}
		
		//winning conditions
		if (userOption == cpuOption) {
			System.out.println("\nThe game ends in a tie again!");
			System.out.println("Let's do another round!");
			tieBreaker(sc);
		} else if (userOption == 1 && cpuOption == 3) {
			System.out.println("\nCongrats! You win!");
		} else if (userOption == 2 && cpuOption == 1) {
			System.out.println("\nCongrats! You win!");
		} else if (userOption == 3 && cpuOption == 2) {
			System.out.println("\nCongrats! You win!");
		} else System.out.println("\nSorry, you lose.");
	}
	
	//startGame method to start playing the game
	private static void startGame(Scanner sc) {
		//initialize variables
		int userOption = 0;
		int cpuOption = 0;
		
		//import RNG
		Random rn = new Random();
		
		//Display the rules of the game
		System.out.println("Here are the rules:");
		System.out.println("Enter 1 for Rock.");
		System.out.println("Enter 2 for Paper");
		System.out.println("Enter 3 for Scissors");
		System.out.println();
		
		//do-while loop to get userOption and validate
		do {
		    System.out.print("What do you choose? (1-3): ");
		    while (!sc.hasNextInt()) {
		        System.out.println("Invalid input! Please enter a number between 1 and 3.");
		        sc.next();
		    }
		    userOption = sc.nextInt();
		    if (userOption < 1 || userOption > 3) {
		        System.out.println("Invalid input! Please enter a number between 1 and 3.");
		    }
		} while (userOption < 1 || userOption > 3);
			
		//generate the CPU's option
		cpuOption = rn.nextInt(3) + 1;
		
		//display the CPU's option
		System.out.println("\nThe CPU chose... ");
		
		//switch statement to show the CPU's option
		switch (cpuOption) {
		case 1:
			System.out.println("Rock!");
			break;
		case 2:
			System.out.println("Paper!");
			break;
		case 3:
			System.out.println("Scissors!");
			break;
		}
		
		//winning conditions
		if (userOption == cpuOption) {
			System.out.println("\nThe game ends in a tie!");
			System.out.println("Let's do another round!");
			tieBreaker(sc);
		} else if (userOption == 1 && cpuOption == 3) {
			System.out.println("\nCongrats! You win!");
		} else if (userOption == 2 && cpuOption == 1) {
			System.out.println("\nCongrats! You win!");
		} else if (userOption == 3 && cpuOption == 2) {
			System.out.println("\nCongrats! You win!");
		} else System.out.println("\nSorry, you lose.");
	}

	public static void main(String[] args) {
		//initialize variables
		char restart;

		//import scanner
		Scanner sc = new Scanner(System.in);
		
		//print game header
		System.out.println("************************************");
		System.out.println("        Rock Paper Scissors");
		System.out.println("************************************");
		System.out.println();
		
		//do-while loop to run the game
		do {
			startGame(sc);
			
			//ask the user if they want to play again
			System.out.println("\nDo you want to play another? (Y/N): ");
			restart = sc.next().charAt(0);
		} while (restart == 'Y' || restart == 'y');
		//print closing message to console
		System.out.println("\nThank you for playing this game!");
	}
}
