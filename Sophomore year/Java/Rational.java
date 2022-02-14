
public class Rational {
	
	private int numerator;//these are private instance variables that are accessed only within the class, meaning that only the class itself can modify and change it
	private int denominator;
	
	//this is a constructor for the class that will give the values of 0 and 1 to numerator and denominator, respectively.
	
	public Rational() {
		this.numerator = 0;
		this.denominator = 1;
	}
	
	//second constructor that allows the use of paraeters and variables. This will set the Rational objects with certain and multiple variables and allow it to be changeable
	public Rational(int num, int denom) {
		this.numerator = num;
		this.denominator = denom;
	}
	
	//this is part of the constructors that will help in getting the values of the instance variables, for both numerator and denominators respectively
	public int getNumerator() {
		return this.numerator;
	}
	
	public int getDenominator() {
		return this.denominator;
	}
	
	
	//this part of the constructors will help in setting the values of the instance variables, for both numerator and denominators respectively
	public void setNumerator(int num) {
		this.numerator = num;
	}
	
	public void setDenominator(int denom) {
		this.denominator = denom;
	}
	
	
	
	//instance method that displays a rational in a reasonable format. 
	public  void printRational() {
		System.out.println(this.numerator + ":" + this.denominator);
	}
	
	//this method takes the rational and turns it into a string
	public String toString() {
		String output = "";
		
		output = this.numerator + ":" + this.denominator;
		
		return output;
	}
	
	//this method reverses the sign of the rational number. IE makikng a positive a negative and such. (will modify)
	public void negate() {
		this.numerator = -(this.numerator);//this will grab the numerator and will negate it and therefore modify it
		
		this.denominator = -(this.denominator);//this will grab the denominator and will negate it
		 //this will have no return because all it is doing is modifying the object.
	}
	
	//this method will take the rational and invert it by switching the location of the the numerator and denominator (modifier)
	public void invert() {
		
		int tempNum = this.numerator, tempDenom = this.denominator;//this will serve as temporary variables that will hold the previous values of the instance variables
		//this will allow an easier transition between the two and will avoid any problems from overwriting each other
		
		this.numerator = tempDenom;//this will set the value of the numerator to the previous value of the denominator
		
		this.denominator = tempNum;//this will set the value of the denominator to the previous value of the numerator
		
		//since this is a modifier, there will be no return
	}
	
	
	//method that converts the rational number to a double and will return the result (will not modify the object)
	public double toDouble() {
		double toDub = 0.0;//this is a variable that will be the output of the method. used only for output and holding it's value
		
		toDub = (double)this.numerator / this.denominator;//this will have the numerator being divided by the denominator, that will result into a long decimal or such. 
		//the double var will hold it value
		
		return toDub;//returns the value in the end after it has been computed. 
	}
	
	//method that will reduce the numbers to their greatest common divisor of both the num and denom. (it will not modify)
	
	public Rational reduce() {//this is the main reduce method that will make a new rational when it is called. 
		int gcd = gcd(this);//this will find the gcd of the given rational
		
		return new Rational(this.numerator/gcd, this.denominator/gcd);//this will return a new rational with it's things reduced by the gcd
		
	}
	
	//in order to simply the process of finding the GCD, this will hold the inforation on finding the gcd and will be called during the reduce method. 
	public int gcd(Rational rat) {
		
		int tempNum = rat.numerator;//variable that is holding the temporary numerator
		int tempDenom = rat.denominator;//variable that is holding the temporary denominator
		
		if(tempNum % tempDenom == 0) { //if the values have no remainder, than it is a gcd
			return tempDenom;
		}
		else {
			return gcd(new Rational(tempDenom, tempNum % tempDenom));//if it find a remainder, then it will recurse on itself and do it again
		}
		
	}
	
	//this will take a rational as a number and add it to this and will make a new rational object
	public Rational add(Rational rat) {
		
		int tempNum = (this.numerator * rat.denominator) + (rat.numerator * this.denominator);//this will make a temporary numerator variable that is used in adding the fractions
		
		int tempDenom = this.denominator * rat.denominator; //this will make a temporary denom variable that is used in adding the fractions
		
		Rational newRat = new Rational(tempNum, tempDenom);//having the formulas finished up top, it will make a new rational object using the temporary nums and denoms
		
		return newRat; //will output the newly made rational number
	}
	
	
	//The main method that will create a new rational type object and will set it's instance variables to a certain value
	public static void main(String[] args) {
		
		//creating the Rational object, used to make a reference and add paraeters for the program
		
		Rational rat = new Rational(8,20);
		
		Rational rat2 = new Rational(10, 15);
		
		
		//this will call the printRational method, which will output the rational in a readable state.
		//the rational will be using the numbers that were set from the object reference above. 
		rat.printRational();
		
		//the rest of the methods will be used below to test and make sure they're working as needed
		
		
		System.out.println(rat.toString());//will make a string of the variables/numbers
		
		//will switch the signs of the rational
		rat.negate();
		rat.printRational();
		rat.negate();//will switch themm back, in order to keep a control
		
		rat.invert();
		rat.printRational();
		rat.invert();//will switch them back, in order to keep a control
		
		System.out.println(rat.toDouble());//will output the rational as a double
		
		Rational ratReduce = rat.reduce();//will get the gcd and reduce it/output it
		ratReduce.printRational();
		
		
		Rational ratAdd = rat.add(rat2);//will add both rationals and output a new one
		ratAdd.printRational();
		
	}

}
