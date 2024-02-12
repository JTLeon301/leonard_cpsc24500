import java.util.Scanner;

public class TaxCalculator {
	/*
	 * Name: Jaiden Leonard
	 * Class: CPSC-24500-001
	 * Date: February 11th, 2024
	 * 
	 * Purpose: This application takes in the user's name and yearly income and calculates the amount
	 * of income tax that the user will have to pay. In the end, the program will tell the user their
	 * name they inputed, their yearly income (rounded down), and the amount of income tax that they
	 * will be paying on it.
	 */
	
	//method to calculate the tax needed to be applied to the user's income
	public static long calculateIncomeTax(long income) {
		//initialize tax
		long tax = 0;
		
		//calculate the taxable income
		if (income <= 4000) {
			tax = 0;
		} else if (income <= 5500){
			tax = (long) ((income - 4000) * 0.10);
		} else if (income <= 33500) {
			tax = (long) (1500 * 0.10 + (income - 5500) * 0.20);
		} else {
			tax = (long) (1500 * 0.10 + 28000 * 0.20 + (income - 33500) * 0.40);
		}
		
		//return tax
		return tax;
	}

	//main method to gather the user's information and output
	public static void main(String[] args) {
		//initialize variables and scanner
		double income = 0;
		String name;
		Scanner sc = new Scanner(System.in);
		
		//ask user for their name
		System.out.print("Please enter your first and last name (seperated by a space): ");
		name = sc.nextLine();
		
		//do while loop for user's income
		do {
			//ask the user for their income
			System.out.print("Please enter your income (without commas): ");
			income = sc.nextDouble();
			
			//validation for correct income
			if (income < 0) {
				System.out.println("\nInvalid input, income should be zero or more.\n");
			}
		} while (income < 0);
		
		//round down the user's income to remove the decimal
		long incomeRounded = (long) income;
		
		//calculate the user's income tax
		long incomeTax = calculateIncomeTax(incomeRounded);
		
		//output the final message to the console
		System.out.println("\nName: " + name);
		System.out.println("Income: J$" + incomeRounded);
		System.out.println("Income Tax: J$" + incomeTax);
	}

}
