import java.util.Scanner;//will import 



public class Recursive {

	public static void main(String[] args) {
		String inStr;//the main string variable, will be used in each method
		
		
		Scanner input = new Scanner(System.in);
		
		//We'll use this string for most of the project, as it will be what will be used to check all of it
		System.out.println("Please input a string: ");
		inStr = input.nextLine();
		System.out.println("Output:\n");
		//printString(inStr);
		
		//variables holding method values
		char fLet = first(inStr);//variable holding the first method output
		
		String reLet = rest(inStr);//variable holding the rest method output
		
		String midStr = middle(inStr);//variable holding the middle method output
		
		int lenStr = length(inStr);//variable holding the length method output
		
		String revStr = reverseString(inStr);//variable holding the reverse string method output
		
		
		//outputs, will print to the console
		System.out.println("This is the first letter: " + fLet);//first method output
		System.out.println("This is the rest of the word: " + reLet);//rest method output
		System.out.println("This is the middle, excluding first and last letters: " + midStr);//middle method output
		System.out.println("This is the total length of the string: " + lenStr);//length method output
		
		System.out.println("\nThe string will be printed character by character: ");
		printString(inStr);//printstring method output
		System.out.println("\nThe string will be printed character by character, backwards: ");
		printBackward(inStr);//printbackward method output
		
		System.out.println("The string in reverse: \n" + revStr);//reverse string method output
		System.out.println("is " + inStr + " a palindrome?\n" + isPalindrome(inStr));//palindrome method output
		
		//closes the scanner variable, input
		
		input.close();
		

	}
	
	
	//My methods
	
	//takes a string as a parameter and displays each letter of the string on a different line
	public static void printString(String s) {//takes a string, named s
		
		for(int i = 0; i < s.length(); i++) {//will loop the entire length of the string, and print out each character at said length index per loop interval
			System.out.println(s.charAt(i));
		}
		
	}

	//takes a string as a parameter and displays each letter of the string on a different line, backwards
	public static void printBackward(String s) {//takes a string, named s
		
		for(int i = s.length()-1; i >= 0; i--) {//will loop the entire length of the string, and print out each character at said length index per loop interval,backwards
			System.out.println(s.charAt(i));
		}
		
	}
	
	//this will take a string and will output the same string except backwards, all in one value
	public static String reverseString(String s) {//takes a string, named s
		String output = "";
		
		for(int i = s.length()-1; i >= 0; i--) {
			output += s.charAt(i);
		}
		
		return output;
	}
	
	//this will take a string and will return a boolean indicating if it is or isn't a palindrome
	public static boolean isPalindrome(String s) {
		boolean output = false;
		s = s.toLowerCase();//to avoid problems, s will be converted to lowercase from the beginning
		
		//after looping, if the there is a length of 0 or 1, then it automatically is a palindrome
		//this must be check first, otherwise, odd lengths will error 
		if(s.length() == 0 || s.length() == 1) {
			output = true;
			return output;
		}
		
		//first, we'll check if the length is 0 or 1, if it is, then it is a palindrome b/c it looped until it reached to this point. 
		if(s.charAt(0) == (s.charAt(s.length()-1))) { //this will check the first and last letter of the current string, if they are similar it will call itself again
			String tStr = middle(s);//in order to check the following letters, a temp variable will modify the test string, taking out the first and last character
			return isPalindrome(tStr);//loops on itself again
		}
		
		
		return output;//if the first if statement fails, then it will automatically fail, thus it is not a palindrome
	}
	
	//Book methods
	
	/**
	* Returns the first character of the given String.
	*/
	public static char first(String s) {
		return s.charAt(0);
	}
	
	/**
	* Returns all but the first letter of the given String.
	*/
	public static String rest(String s) {
		return s.substring(1);
	}
	
	/**
	* Returns all but the first and last letter of the String.
	*/
	public static String middle(String s) {
		return s.substring(1, s.length() - 1);
	}
	
	/**
	* Returns the length of the given String.
	*/
	public static int length(String s) {
		return s.length();
	}

}
