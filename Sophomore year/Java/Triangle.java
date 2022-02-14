 /* Write a program named Triangle.java that inputs three integers, and then
	outputs whether you can (or cannot) form a triangle from the given lengths.
	Reuse your code from the previous exercise to validate the inputs. Display an
	error if any of the lengths are negative or zero. */

	//problem ^

import java.util.Scanner; //Importing the scanner class so that we can take in user input

//The  class
public class Triangle {

	//main class
	public static void main(String[] args) {
		//declare the variables, which will be assined user input
		int triS1 = 0;
		int triS2 = 0;
		int triS3 = 0;
		
		//this variable will hold onto the value outputted by triangle method
		boolean isTriangle;
		
		//take in user input and assigning variables
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Please input the first side: ");
		
		//validation code
		//I tried the best, but this is the best validation method I could come up with
		if(input.hasNextInt()) {//will check if the input item is an integer
			triS1 = input.nextInt();//if true, it will assign triangle side 1 to it
			if(triS1 <= 0) {//will check if triS1 is lower than 0
				System.err.println("Please choose a number higher than 0.\nTerminating");//if true, will error and terminate program
				input.close();
				return;
			}
			
		}
		else { //if is not an int, will error and terminate program
			String word = input.next();
			System.err.println(word + " is not an integer\nTerminating");
			input.close();
			return;
		}
		
		
		//second number
		System.out.println("Please input the second side: ");if(input.hasNextInt()) {//will check if the input item is an integer
			triS2 = input.nextInt();//if true, it will assign triangle side 1 to it
			if(triS2 <= 0) {//will check if triS1 is lower than 0
				System.err.println("Please choose a number higher than 0.\nTerminating");//if true, will error and terminate program
				input.close();
				return;
			}
			
		}
		else { //if is not an int, will error and terminate program
			String word = input.next();
			System.err.println(word + " is not an integer\nTerminating");
			input.close();
			return;
		}
		
		//third number
		System.out.println("Please input the third side: ");if(input.hasNextInt()) {//will check if the input item is an integer
			triS3 = input.nextInt();//if true, it will assign triangle side 1 to it
			if(triS3 <= 0) {//will check if triS1 is lower than 0
				System.err.println("Please choose a number higher than 0.\nTerminating");//if true, will error and terminate program

				input.close();
				return;
			}
			
		}
		else { //if is not an int, will error and terminate program
			String word = input.next();
			System.err.println(word + " is not an integer\nTerminating");
			input.close();
			return;
		}
		
		//calls method and stores it's value
		isTriangle = triangle(triS1, triS2, triS3);
		
		//output
		if(isTriangle == true) {
			System.out.print("This is a triangle");
		}
		else if(isTriangle == false) {
			System.out.println("This is not a triangle");
		}
		else {//given that there is an error, I'll use this as a way to tell that there is a problem
			System.out.println("Error: Please try again later");
		}
		
		//closes the scanner
		input.close();
	}
	
	
	//the triangle calculation method
	public static boolean triangle(int side1, int side2, int side3) {
		//this method will take all three sides, and do a check  on each side
		
		//The triangle logic: 
		/* If any of the three lengths is greater than the sum of the other two,
		you cannot form a triangle. */
		
		//variable which will tell the answer
		boolean answer = false;
		
		if(side1 < (side2+side3)) {
			if(side2 < (side1+side3)) {
				if(side3 < (side1+side2)) {
					answer = true;
				}
			}
		}
		else {
			answer = false;
		}
		
		return answer;
	}
	
	
}
