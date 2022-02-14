/**
 * BigInteger exercise.
 */

import java.math.BigInteger;//We'll import the bigInt class



public class Pow {
	
	public static void main(String[] args) {
		//these variables will hold the values of the methods
		int powVar = pow(5,5);
		//this variable will be a larger number to test the limits of integers
		int powVar2 = pow(5000,5000);
		
		//these variables hold the results of the method calls, with smaller and bigger input, respectively
		BigInteger bPowVar = bigPow(5,5);
		BigInteger bPowVar2 = bigPow(5000,5000);
		
		
		//This print statement will test the original pow method
		System.out.println("Pow test with 5,5: " + powVar);
		//test 2, big numbers
		System.out.println("Pow test with 5000,5000: " + powVar2 + "\n");//this is a huge number, so it should error out/not compute
		
		
		
		//This print statement will test the new BigPow Method, that uses big integers
		System.out.println("BigPow test with 5,5: " + bPowVar);
		System.out.println("BigPow test with 5000,5000: " + bPowVar2);
		
	}
	
	//I will rewrite the pow method here but instead it will use bigintegers
	public static BigInteger bigPow(int x, int n) {
		
			
		//this bigint wil hold the output value, allowing for easier returns
		BigInteger output = BigInteger.valueOf(0);
		//due to some unknown issue I was having, I decided to give x it's own bigInt so that it could easilly compute the else statement
		//in truth, all this variable does is hold the value of x
		BigInteger xVal = BigInteger.valueOf(x);
		//henceforth, I try my best to convert the pow method into one that can use bigInts
		
		//if n has a value of 0, it will set the output to a value of 1 and return it
		if (n == 0) {
				output = BigInteger.valueOf(1);
				return output;
			}
			
		//finds x to the n/2 recursively, but in big integers
		BigInteger t = bigPow(x, n/2);
	
	       // if n is even, the result is t squared
	       // if n is odd, the result is t squared times x
	       if (n % 2 == 0) {
	            output = t.multiply(t);//output will be set to t multiplied by t, allowing it to be recursive and still a bigint - then it will return it
	            return output;
	        } 
	       else {//if there is a remainder, it will square t, then multiple it by the bigint value of x - then output it
	        	output = t.multiply(t);
	        	output = output.multiply(xVal);
	        	return output;
	        }
	        
	}
	
	

    /**
     * Integer exponentiation.
     */
    public static int pow(int x, int n) {
        if (n == 0) return 1;

        // find x to the n/2 recursively
        int t = pow(x, n / 2);

        // if n is even, the result is t squared
        // if n is odd, the result is t squared times x
        if (n % 2 == 0) {
            return t * t;
        } else {
            return t * t * x;
        }
        
    }

}
