import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class CardTable extends Canvas {

    private Image[][] images;
    private int cardWidth, cardHeight;

    /**
     * Creates a CardTable.
     * cardset is the name of the folder that contains the card images.
     */
    public CardTable() {
        setBackground(new Color(0x088A4B));

        // create a 2-D array of card images
        images = new Image[15][4];

        String cardset = "cardset-oxymoron";
        String suits = "cdhs";

        for (int suit = 0; suit <= 3; suit++) {
            char c = suits.charAt(suit);

            for (int rank = 1; rank <= 13; rank++) {
                String s = String.format("%s/%02d%c.gif",
                                         cardset, rank, c);
                images[rank][suit] = new ImageIcon(s).getImage();
            }
            
        }
        
        String back = String.format("cardset-oxymoron/back191.gif", cardset, 14, 3);
        images[14][3] = new ImageIcon(back).getImage();

        // get the width and height of the cards and set the size of
        // the frame accordingly
        cardWidth = images[1][1].getWidth(null);
        cardHeight = images[1][1].getHeight(null);

        // set the size temporarily to get the insets
        setTableSize(16, 10);
    }

    /**
     * Sets the table size.
     * x and y are in units of card width/height.
     */
    public void setTableSize(double x, double y) {
        setSize((int) (x * cardWidth),
                (int) (y * cardHeight));
    }

    /**
     * Draws a card at the given coordinates.
     * x and y are in units of card width/height.
     */
    public void drawCard(Graphics g, int rank, int suit, double x, double y) {
        Image image = images[rank][suit];
        g.drawImage(image,
                    (int) (x * cardWidth),
                    (int) (y * cardHeight),
                    null);
    }

    /**
     * Special method invoked when the Frame needs to be drawn.
     */
    public void paint(Graphics g) {
    	/**
        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 0; suit <= 3; suit++) {
                double x = rank - 1 + suit / 5.0;
                double y = suit / 2.0;
                drawCard(g, rank, suit, x, y);
            }
        }**/
    	
    	double x = 0;//double that holds the x coordinate value
    	double y = 2;//double that holds the y coordinate value, for placing on canvas
    	int rank = 1;//this int holds the current value of the rank, which can be edited as needed
    	int suit = 0;//this int holds the value of the suit, which can be edited as needed
    	int repeat = 0;//this is an int that is used in adding one more card per interval in the code. 
    	
    	for (int i = 0; i < 14; i+=2) {//this is the inital loop that will go into calculating the x position and drawing it
    		
    		for(int w = 0; w <= repeat; w++) {//this is the loop that will go into calculating the y position and drawing it, relies on the repeat variable for the amount of iterations
    			
    			if(w != repeat) {//this if statement will see if the card is at the end of the stack (the end meaning that that w and repeat equal eachother)
    				//, if it isn't it will draw the backside of the cards
    				drawCard(g, 14, 3, x + i, y+w);
    			}
    			else {//if it is at the end of the deck, it will then draw the card with a given suit and rank
    				drawCard(g, rank, suit, x + i, y+w);//the card will be drawn at the given rank and suit, modified by the current i and w values towards x and y respectively
    			}
		    	rank +=1;//after drawing the card, the rank variable will increase in value
		    		if(rank > 13) {//if the variable is over 13 (the limit), the suit will go up and the rank will be reset to 1
		    			suit+=1;
		    			rank = 1;
		    		}
		    	
    		}
    		repeat += 1;//will increase the amount of repeats by 1 and will loop on itself again
    			
    	}
    	
    	
    	
    	drawCard(g, 14, 3, 0,0);//the final few draws will represent the leftover deck and the card next to it
    	//these are the two cards on the top left part of the game
    	drawCard(g, rank+=1, suit, 3, 0);
    	
    	//drawCard(g, 1, 1, 0, 0);
    }

    public static void main(String[] args) {
        // make the frame
        JFrame frame = new JFrame("Card Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the CardTable
        Canvas canvas = new CardTable();
        frame.getContentPane().add(canvas);

        // show the frame
        frame.pack();
        frame.setVisible(true);
    }

}
