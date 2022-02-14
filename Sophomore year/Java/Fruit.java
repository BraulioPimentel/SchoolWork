/**
 * Fruit exercise.
 */

//this here is the name of the class
public class Fruit {

    public static int banana(int[] a) { //this class, called banana, takes in an array of integers and stores it into array a
        int kiwi = 1;//sets up a varaible known as kiwi, giving it a value of 1
        int i = 0;//sets up an int I and sets it as 0
        while (i < a.length) {//loop, while int i is less than the total length of array a, it'll set the value of kiwi
        	//to the current value of kiwi multiplied by the value at the current itreation of i. after 1 iteration, i will increase 
            kiwi = kiwi * a[i];
            i++;
        }
        return kiwi;//the method will return the total of kiwi after gone through the loops
    }

    public static int grapefruit(int[] a, int grape) {//this sets up a method named grapefruit, which takes in an in array titled a, and an integer titled grape
        for (int i = 0; i < a.length; i++) {//this is a loop, that while the value of i is less than the length of array a, it'll keep looping
        	
            if (a[i] == grape) {//if the value of the int in the array a at value i equals the value of grape, it'll return the value at array a, position i
                return i;
            }
        }
        return -1;//if the loop finishes but there's no matching value, it'll return -1
    }

    public static int pineapple(int[] a, int apple) {//this is a method that takes in int array a, and a regular integer named apple
        int pear = 0;//this sets up an integer named pear that holds the value of 0
        for (int pine: a) {//this is an enhanced for loop that will loop through the entire a array, setting the value of pine to the value of a temporarily 
            if (pine == apple) {//if the value stored in the temmp variable pine equals the value of apple, then the variable pear will increase in value by one.
                pear++;
            }
        }
        return pear;//after finishing the loop, the method will output the final value of pear 
    }
    
    //since there is no main method, this class will not output anything 

}
