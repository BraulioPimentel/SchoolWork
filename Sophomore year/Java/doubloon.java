/* 
 * Write a method called isDoubloon that takes a string and checks whether it is
* a doubloon. To ignore case, invoke the toLowerCase method before checking.
 */

//for input, we'll use the scanner class

import java.util.Scanner;


public class doubloon {//class

	//The main class
	public static void main(String[] args) {
		//the scanner class will be initalized here
		Scanner input = new Scanner(System.in);
		
		//We'll ask the user for input
		System.out.println("Please input a word: ");
		
		
		//store the input in a string
		String word = input.nextLine();
		
		//call the function
		boolean tAnswer = isDoubloon(word.toLowerCase());
		
		
		//output the result
		System.out.println("Is " + word + " a dubloon?\n");
		//if tanswer is false, it'll output no
		if(tAnswer == false) {
			System.out.print("No");
			
		}
		//else if, t answer is true, it'll output yes
		else if(tAnswer == true) {
			System.out.print("Yes");
		}
		
		input.close();

	}
	
	
	//this will be the isDoubloon method
	//what this method does is it checks to see if a word is a doubloon
	//it'll go through the word and check it it
	//to make it easier, we'll have two numbers starting at each end, these numbers will keep going towards the middle checking. if a match is not found, they will outupt false
	//if a match is found, they will keep looping ultil the middle
	public static boolean isDoubloon(String tWord) {
		
		//variable that will store the output value
		boolean answer = true;
		//variable that will be the end one
		int endPt = tWord.length()-1;
		
		//will check if the word is even, if it is, it'll continue, if not, then it is automatically not a doubloon
		//else, it'll go into the real logic of the method 
		
		if(((tWord.length()) % 2) != 0) {
			//System.out.println("ping"); //test 
			answer = false;
			return answer;
		}
		else {

			//a loop that will cycle through the word
			for(int i = 0; i < ((tWord.length())/2); i++) {
				
				if(tWord.charAt(i) != tWord.charAt(endPt)) {
					//System.out.println("Pong"); //test
					answer = false;
					return answer;
					
				}
				else {
				answer = true;
				}
				
				endPt--;
				
			}

		}
		
		
		

		return answer;
	}

}
