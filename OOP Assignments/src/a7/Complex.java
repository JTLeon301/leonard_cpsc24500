/*
 * NAME: Jaiden Leonard
 * CLASS: Object-Oreinted Programming
 * DATE: 4/19/2024
 * ASSIGNMENT 7
 * 
 * PURPOSE:
 * The purpose of this program is to allow the user to input 2 complex numbers and show each of the operations
 * (add, subtract, multiply, divide) and also the absolute value of the complex number.
 * 
 * STRUGGLES:
 * I didn't really have any struggles because we did a similar program/assignment in my Fundamentals class except it
 * didn't go into as much depth as the complex class did in this assignment.
 * 
 * NOTE:
 * If you have any suggestions about my code, please feel free to tell me about it, all criticism is
 * welcome both positive and negative. Thank you!
 */

package a7;

import java.util.Scanner;
import java.text.DecimalFormat;

class Complex implements Comparable<Complex> {
	//initialize variables
    private double real;
    private double imag;

    public Complex(double a, double b) {
        real = a;
        imag = b;
    }

    //complex constructor where b is 0
    public Complex(double a) {
        this(a, 0);
    }

    //copy constructor
    public Complex(Complex complexNumber) {
        this(complexNumber.real, complexNumber.imag);
    }

    //create complex for 0
    public Complex() {
        this(0, 0);
    }

    //get method for real number
    public double getRealPart() {
        return real;
    }

    //get method for imaginary number
    public double getImaginaryPart() {
        return imag;
    }

    /**
     * Adding both complex numbers.
     * @param other The complex numbers to add
     * @return A new complex number representing addition.
     */
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imag + other.imag);
    }

    /**
     * Subtracting both complex numbers.
     * @param other The complex numbers to subtract.
     * @return A new complex number representing subtraction.
     */
    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imag - other.imag);
    }

    /**
     * Multiplying both complex numbers.
     * @param other The complex numbers to multiply.
     * @return A new complex number representing multiplication.
     */
    public Complex multiply(Complex other) {
        double newReal = this.real * other.real - this.imag * other.imag;
        double newImag = this.imag * other.real + this.real * other.imag;
        return new Complex(newReal, newImag);
    }

    /**
     * Dividing both complex numbers.
     * @param other The complex numbers to divide.
     * @return A new complex number representing division (rounded to 4 decimal places).
     */
    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imag * other.imag;
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide the complex number.");
        }
        double newReal = (this.real * other.real + this.imag * other.imag) / denominator;
        double newImag = (this.imag * other.real - this.real * other.imag) / denominator;
        
        //round the result to four decimal places
        DecimalFormat df = new DecimalFormat("#.####");
        newReal = Double.parseDouble(df.format(newReal));
        newImag = Double.parseDouble(df.format(newImag));
        
        return new Complex(newReal, newImag);
    }

    /**
     * Computes absolute value of the complex number.
     * @return The absolute value of the complex number.
     */
    public double abs() {
        return Math.sqrt(real * real + imag * imag);
    }

    //toString method
    @Override
    public String toString() {
        if (imag == 0) {
            return String.valueOf(real);
        }
        return "(" + real + " + " + imag + "i)";
    }

    //compareTo method
    @Override
    public int compareTo(Complex other) {
        return Double.compare(this.abs(), other.abs());
    }

    
    public static void main(String[] args) {
    	//initialize scanner
        Scanner sc = new Scanner(System.in);

	    //ask user for the first complex number
	    System.out.print("Enter the first complex number: ");
	    double a = sc.nextDouble();
	    double b = sc.nextDouble();
	    Complex first = new Complex(a, b);
	
	    //ask user for the second complex number
	    System.out.print("Enter the second complex number: ");
	    double c = sc.nextDouble();
	    double d = sc.nextDouble();
        Complex second = new Complex(c, d);

        //output to console all operations completed
	    System.out.println(first + " + " + second + " = " + first.add(second));
        System.out.println(first + " - " + second + " = " + first.subtract(second));
        System.out.println(first + " * " + second + " = " + first.multiply(second));
	    System.out.println(first + " / " + second + " = " + first.divide(second));
	    System.out.println("|" + first + "| = " + first.abs());
    }
}

