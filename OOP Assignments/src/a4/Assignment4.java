package a4;

import java.util.Scanner;
import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Assignment4 {
/*
 * PURPOSE: The purpose of this program is to crate a 2d array from a text file and find the following:
 * 			findLongestRow (longest row in the index), findMaxInRow (max value in the row), and
 * 			findMax (maximum value in the array)
 * STRUGGLES: I could not get it to work in cmd so I'm not entirely sure what I did wrong. I even installed
 * 		      the latest JDK to see if that would help and it did not. I'm 90% sure the program works but
 *            I have no way to test if it does since I could not get it to work even after an hour trying
 *            all the methods I could find online.
 * NOTE: If you have any pointers on my code that could help me improve, please let me know. All feedback
 *       is welcomed; good or bad. Thank you!
 */
	/**
	 * @param filename
	 * @return number of lines in a text file
	 * @throws Exception
	 */
	public static int getNoLines(String filename) throws Exception{
		try (Stream<String> fileStream = Files.lines(Paths.get(filename))) {
			return (int) fileStream.count();
		} 
	}

	/**
	 * @param filename source file
	 * @return two dim array (jagged array), where each row in the array contains the values in one line of the file,
	 * the length of each row depends on the number of values in each line of the file.
	 * @throws Exception
	 */
	public static int[][] create2DArray(String filename) throws Exception {
		//determine number of lines in the file
		int numLines = getNoLines(filename);
		//initialize 2D array
		int[][] array = new int[numLines][];
		//read and populate array
		try (Scanner sc = new Scanner(new File(filename))) {
			int row = 0;
			while (sc.hasNextLine()) {
				//split the line into individual int values
				String[] lineVal = sc.nextLine().trim().split("\\s+");
				array[row] = new int[lineVal.length];
				//store values in the array
				for (int i = 0; i < lineVal.length; i++) {
					array[row][i] = Integer.parseInt(lineVal[i]);
				}
				row++;
			}
		} catch (FileNotFoundException e) {
	        System.err.println("File is not found: " + filename);
	    } catch (NumberFormatException e) {
	        System.err.println("Invalid format of the file: " + filename);
	    } catch (IOException e) {
	        System.err.println("Error reading file: " + filename);
	    }
        return array;
	}
	
	/**
	 * @param array
	 * @return the longest row found within the file
	 */
	public static int findLongestRow(int[][] array) {
		//initialize variables
		int longestRowIndex = 0;
		int maxLength = array[0].length;
		
		//
		for (int i = 1; i < array.length; i++) {
			if (array[i].length > maxLength) {
				maxLength = array[i].length;
				longestRowIndex = i;
			}
		}
		return longestRowIndex;
	}
	
	/**
	 * @param array
	 * @return the maximum number found within the file
	 */
	public static int findMax(int[][] array) {
		//initialize variables
		int max = array[0][0];
		
		//
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] > max) {
					max = array[i][j];
				}
			}
		}
		return max;
	}
	
	/**
	 * 
	 * @param array
	 * @param rowIndex
	 * @return finds the maximum value in the given row
	 */
	public static int findMaxInRow(int[][] array, int rowIndex) {
		//initialize variables
		int max = array[rowIndex][0];
		
		//
		for (int i = 1; i < array[rowIndex].length; i++) {
			if (array[rowIndex][i] > max) {
				max = array[rowIndex][i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		String filename = null;
		if (args.length <1) {
			System.out.println("usage: Assignment4 inputFilename ");
			System.exit(0);
			
		}
		filename = args[0];
		int arr[][] = null;
		try {
			System.out.println("Number of lines in the file ="+ getNoLines(filename));
			arr = create2DArray(filename);
			int longestRow = findLongestRow(arr);
			System.out.println("Longest row in the file is: "+ (longestRow+1 )+" ,with length of: "
			                     +arr[longestRow].length);
			System.out.println("Max value in first row = "+ findMaxInRow(arr, 0));
			System.out.println("Max value in file = "+ findMax(arr));
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
