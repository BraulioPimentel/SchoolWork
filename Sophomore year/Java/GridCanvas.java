import java.awt.Canvas;
import java.awt.Graphics;

/**
 * 2D array of cells representing a rectangular grid.
 */
public class GridCanvas extends Canvas {

    /** Cells stored in row-major order. */
    private Cell[][] array;

    /**
     * Constructs a grid of given size.
     * 
     * @param rows number of rows
     * @param cols number of columns
     * @param size pixels per cell
     */
    public GridCanvas(int rows, int cols, int size) {

        // build 2D array of cells
        array = new Cell[rows][cols];
        for (int r = 0; r < rows; r++) {
            int y = r * size;
            for (int c = 0; c < cols; c++) {
                int x = c * size;
                array[r][c] = new Cell(x, y, size);
            }
        }

        // set the canvas size
        setSize(cols * size, rows * size);
    }

    /**
     * @return number of rows
     */
    public int numRows() {
        return array.length;
    }

    /**
     * @return number of columns
     */
    public int numCols() {
        return array[0].length;
    }

    /**
     * @param r row index
     * @param c column index
     * @return the cell
     */
    public Cell getCell(int r, int c) {
        return array[r][c];
    }

    /**
     * Convenience method that turns on the cell at (r, c).
     * 
     * @param r row index
     * @param c column index
     */
    public void turnOn(int r, int c) {
        array[r][c].turnOn();
    }

    /**
     * Returns 1 if the cell at (r, c) exists and is on. Returns 0 if the cell
     * doesn't exist or is off.
     * 
     * @param r row index
     * @param c column index
     * @return 1 or 0
     */
    public int test(int r, int c) {
        try {
            if (array[r][c].isOn()) {
                return 1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // cell doesn't exist
        }
        return 0;
    }
    
    //this is an instance method that will return the amount of cells that are currently on
    public int countOn() {
    	int amtOn = 0;//this will be the value of the total cells that are on. By default, it will be zero
    	
    	for(int r = 0; r < array.length; r++) {//this is a loop that will go through all the rows
    		
    		for(int c = 0; c < array[0].length; c++) {//this is a loop that will go through all the coloums 
    			
    			if(array[r][c].isOn() == true) {//if the array at the current row and coloum are turned on, the variable that was declared at the beginning will be updated with aa +1 value. 
    				amtOn += 1;//the variable will be updated if it is on. 
    			}
    		}
    	}
    	
    	
    	return amtOn;//once this has gone through the loop, it will return the total number that were on. Since it will be tied with the update function,
    	//it will reset to zero per run and will update accordingly.
    }

    /**
     * Draws the grid, cell by cell.
     * 
     * @param g graphics context
     */
    public void draw(Graphics g) {
        for (Cell[] row : array) {
            for (Cell cell : row) {
                cell.draw(g);
            }
        }
    }

    /**
     * Paints the grid on the screen.
     * 
     * @param g graphics context
     */
    public void paint(Graphics g) {
        draw(g);
    }

    /**
     * Overriding this method helps the simulation run more smoothly. Normally
     * the Canvas is cleared before painting, but there is no need to clear it
     * since the paint method draws the entire grid.
     * 
     * @param g graphics context
     */
    public void update(Graphics g) {
        draw(g);
    }

}
