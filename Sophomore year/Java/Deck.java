import java.util.Random;

/**
 * A deck of playing cards (of fixed length).
 */
public class Deck {
	
	

    // This is a class variable so we don't have to create
    // a new Random object every time we call randomInt.
    private static Random random = new Random();

    private Card[] cards;

    /**
     * Constructs a standard deck of 52 cards.
     */
    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    /**
     * Constructs a deck of n cards (all null).
     */
    public Deck(int n) {
        this.cards = new Card[n];
    }

    /**
     * Gets the internal cards array.
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Displays each of the cards in the deck.
     */
    public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    /**
     * Returns a string representation of the deck.
     */
    public String toString() {
        return "TODO";
    }

    /**
     * Randomly permutes the array of cards.
     */
    public void shuffle() {
    	//this will choose a random number between i and length -1
    	//swap the ith card and the randomly-chosen card
    	
    	//using the shuffle algorithm in 13.2, I made it so that it'll go through a deck, and pull out a number
    	//using a for loop, this will go through the length of the deck,and will swap 2 cards each pass. This will allow for pseudo randomness in the shuffleing
    	//this will also not allow any duplications because you're only switching the spots of two cards, rather than modifying the card in it's entirety. 
    	for(int i = 0; i < cards.length; i++) {//
    		swapCards(i, randomInt(i, cards.length-1));
    	}
    	
    }

    /**
     * Chooses a random number between low and high, including both.
     */
    private static int randomInt(int low, int high) {
    	//this will return a number between the low and high
    	//including each
    	int rNum = 0;//this will be the number that will be outputted for the return statement 
    	
    	rNum = random.nextInt(Math.max(high, low) - Math.min(high, low) + 1) + low;//this is the assignment for the random number.
    	//it will take the max number and subtracted by the lowerst +1. It will then be added by the lowest. This will help it get a random number between the range
    	
        return rNum;//once it is finished, it will return the number
    }

    /**
     * Swaps the cards at indexes i and j.
     */
    private void swapCards(int i, int j) {
    	//this method will swap the values of both cards with each other's value
    	Card tempCard = cards[i];//this will create a temporary card that will hold the value of the original i card
    	cards[i] = cards[j];//this will set the value of the i card to the value of the j card
    	cards[j] = tempCard;//going back, we'll use the value of the saved i card and set it to the j card
    	
    	//since there's no return, the thing will end here
    }

    /**
     * Sorts the cards (in place) using selection sort.
     */
    public void selectionSort() {
    }

    /**
     * Finds the index of the lowest card
     * between low and high inclusive.
     */
    private int indexLowest(int low, int high) {
        return 0;
    }

    /**
     * Returns a subset of the cards in the deck.
     */
    public Deck subdeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    /**
     * Combines two previously sorted subdecks.
     */
    private static Deck merge(Deck d1, Deck d2) {
        return null;
    }

    /**
     * Returns a sorted copy of the deck using selection sort.
     */
    public Deck almostMergeSort() {
        return this;
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck mergeSort() {
        return this;
    }

    /**
     * Reorders the cards (in place) using insertion sort.
     */
    public void insertionSort() {
    }

    /**
     * Helper method for insertion sort.
     */
    private void insert(Card card, int i) {
    }

}
