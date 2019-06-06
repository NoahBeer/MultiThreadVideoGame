import java.util.ArrayList;
import java.util.HashMap;

/**
 * Board is responsible for displaying sketches. Board contains a grid of cells which can be 1-100 wide and 1-100 tall. The Board is responsible
 * for tracking any placed in Boardable elements within the cell. The Board class will also display the board. 
 * 
 * @author Noah Beer
 */
public class Board {
	
	/** declares instance variable private 2D array of type Cell, board*/
	private Cell[][] board; 
	
	/**how tall the board is*/
	private int height; 
	
	/** How wide the board is */
	private int width; 
	
	/** Stores elements of type Boardable in the assigned Cell*/
	private HashMap<Boardable, Cell> elementPlace; 
	
	/** Keeps track of whether or not Jarvis has been hugged */
	private boolean hugged; 
	
	/**
	 * public Board() is a constructor that creates a Board object. It takes in parameters int height and int width and initializes this.height
	 * to height and this.width to width. 2d array Cell this.board is given its 2 ranges from the parameters, height and width. HashMap 
	 * this.elementPlace is initialized. fillBoard() is called to fill the board to the specified size.
	 * 
	 * @param height is how tall the board is
	 * @param width is how wide the board is
	 */
	public Board(int height, int width) {
		if(height > 100 || height < 1) { // checks to see if height is out of bounds and throws an exception if so
			throw new IllegalArgumentException("Height must be between 1-100 inclusively.");
		}
		if (width > 100 || width < 1) { // checks to see if width is out of bounds and throws an exception if so
			throw new IllegalArgumentException("Width must be between 1-100 inclusively.");
		}
		this.height = height; 
		this.width = width;
		this.board = new Cell[this.height][this.width]; 
		this.elementPlace = new HashMap<Boardable, Cell>();
		fillBoard();
		hugged = false; 
	}
	
	/**
	 * move() moves the elem in the prompted direction and then stores it in its new Cell on the Board.
	 * 
	 * @param dir is the direction the elem is asking to move
	 * @param elem is the type of Boardable trying to move
	 * @return true if elem successfully moves. False otherwise.
	 */
	synchronized public boolean move(Direction dir, Boardable elem) {
		int curCol;
		int curRow;
		
		if(dir == Direction.UP_LEFT) { // prompts if UP_LEFT is passed in for parameter dir
			Cell curCell = elementPlace.get(elem);
			curRow = curCell.row - 1;
			curCol = curCell.col - 1;
			
			if(curRow < 0 || curCol < 0 || curRow > this.width - 1 || curCol > this.height - 1) { // Makes sure index doesn't go out of bounds
				elementPlace.put(elem, curCell);
				return false;
			}else {
				Cell newCell = board[curRow][curCol];
				newCell.addElement(elem);
				this.elementPlace.get(elem).removeElement(elem);
				this.elementPlace.put(elem, newCell);
			}
		}
		if(dir == Direction.UP) { // prompts if UP is passed in for parameter dir
			Cell curCell = elementPlace.get(elem);
			curRow = curCell.row - 1;
			curCol = curCell.col;
			
			if(curRow < 0 || curCol < 0 || curRow > this.width - 1 || curCol > this.height - 1) { // Makes sure index doesn't go out of bounds
				elementPlace.put(elem, curCell);
				return false;
			}else {
				Cell newCell = board[curRow][curCol];
				newCell.addElement(elem);
				this.elementPlace.get(elem).removeElement(elem);
				this.elementPlace.put(elem, newCell);
			}
		}
		if(dir == Direction.UP_RIGHT) { // prompts if UP_RIGHT is passed in for parameter dir
			Cell curCell = elementPlace.get(elem);
			curRow = curCell.row - 1;
			curCol = curCell.col + 1;
			
			if(curRow < 0 || curCol < 0 || curRow > this.width - 1 || curCol > this.height - 1) { // Makes sure index doesn't go out of bounds
				elementPlace.put(elem, curCell);
				return false;
			}else {
				Cell newCell = board[curRow][curCol];
				newCell.addElement(elem);
				this.elementPlace.get(elem).removeElement(elem);
				this.elementPlace.put(elem, newCell);
			}
		}
		if(dir == Direction.RIGHT) { // prompts if RIGHT is passed in for parameter dir
			Cell curCell = elementPlace.get(elem);
			curRow = curCell.row;
			curCol = curCell.col + 1;
			
			if(curRow < 0 || curCol < 0 || curRow > this.width - 1 || curCol > this.height - 1) { // Makes sure index doesn't go out of bounds
				elementPlace.put(elem, curCell);
				return false;
			}else {
				Cell newCell = board[curRow][curCol];
				newCell.addElement(elem);
				this.elementPlace.get(elem).removeElement(elem);
				this.elementPlace.put(elem, newCell);
			}
		}
		if(dir == Direction.DOWN_RIGHT) { // prompts if DOWN_RIGHT is passed in for parameter dir
			Cell curCell = elementPlace.get(elem);
			curRow = curCell.row + 1;
			curCol = curCell.col + 1;
			
			if(curRow < 0 || curCol < 0 || curRow > this.width - 1 || curCol > this.height - 1) { // Makes sure index doesn't go out of bounds
				elementPlace.put(elem, curCell);
				return false;
			}else {
				Cell newCell = board[curRow][curCol];
				newCell.addElement(elem);
				this.elementPlace.get(elem).removeElement(elem);
				this.elementPlace.put(elem, newCell);
			}
		}
		if(dir == Direction.DOWN) { // prompts if DOWN is passed in for parameter dir
			Cell curCell = elementPlace.get(elem);
			System.out.println(curCell);
			curRow = curCell.row + 1;
			curCol = curCell.col;
			
			if(curRow < 0 || curCol < 0 || curRow > this.width - 1 || curCol > this.height - 1) { // Makes sure index doesn't go out of bounds
				elementPlace.put(elem, curCell);
				return false;
			}else {
				Cell newCell = board[curRow][curCol];
				newCell.addElement(elem);
				this.elementPlace.get(elem).removeElement(elem);
				this.elementPlace.put(elem, newCell);
			}
		}
		if(dir == Direction.DOWN_LEFT) { // prompts if DOWN_LEFT is passed in for parameter dir
			Cell curCell = elementPlace.get(elem);
			curRow = curCell.row + 1;
			curCol = curCell.col -1;
			
			if(curRow < 0 || curCol < 0 || curRow > this.width - 1 || curCol > this.height - 1) { // Makes sure index doesn't go out of bounds
				elementPlace.put(elem, curCell);
				return false;
			}else {
				Cell newCell = board[curRow][curCol];
				newCell.addElement(elem);
				this.elementPlace.get(elem).removeElement(elem);
				this.elementPlace.put(elem, newCell);
			}
		}
		if(dir == Direction.LEFT) { // prompts if LEFT is passed in for parameter dir
			Cell curCell = elementPlace.get(elem);
			curRow = curCell.row;
			curCol = curCell.col - 1;
			
			if(curRow < 0 || curCol < 0 || curRow > this.width - 1 || curCol > this.height - 1) { // Makes sure index doesn't go out of bounds
				elementPlace.put(elem, curCell);
				return false;
			}else {
				Cell newCell = board[curRow][curCol];
				newCell.addElement(elem);
				this.elementPlace.get(elem).removeElement(elem);
				this.elementPlace.put(elem, newCell);
			}
		}
		System.out.println("\n");
		printBoard();
		return true; 
	}
	
	/**
	 * places the passed in elem at the specified row and col. It is also syncronized.
	 * 
	 * @param elem is the type of Boardable being passed in. This elem is placed on the board at Cell (row, col)
	 * @param row is the row the elem is to be placed at
	 * @param col is the column the elem is to be placed at
	 * @return true if the elem is successfully place, false otherwise.
	 */
	synchronized public boolean placeElement(Boardable elem, int row, int col) {
		if(row > this.width || row < 0) {
			System.out.println("ERROR: Please enter a row value between 0 and " + this.width);
			return false;
		}
		if(col > this.height || col < 0) {
			System.out.println("ERROR: Please enter col value between 0 and " + this.height);
			return false;
		}
		Cell value = this.board[row][col];
		value.addElement(elem);
		elementPlace.put(elem, value);
		return true;
	}
	
	/**
	 * removes the passed in elem from the board.
	 * 
	 * @param elem is the type of Boardable that is attempting to be removed
	 * @return true if elem is successfully removed. False otherwise
	 */
	synchronized public boolean removeElement(Boardable elem) {
		if(this.elementPlace.containsKey(elem)) {
			Cell curCell = this.elementPlace.remove(elem);
			curCell.removeElement(elem);
			return true;
		}
		return false;
	}
	
	/**
	 * returns the row the passed in elem is at
	 * 
	 * @param elem is the type of Boardable whose row number we'd like to know
	 * @return the row int that elem is located
	 */
	public int getRow(Boardable elem) {
		if(elementPlace.get(elem) == null) {
			throw new IllegalArgumentException("Element is not on the Board.");
		}
		else if(elementPlace.get(elem).row > - 1 && elementPlace.get(elem).row < this.height) {
			return elementPlace.get(elem).row;
		}else {
			throw new IllegalArgumentException("Element is not on the Board");
		}
	}
	
	/**
	 * returns the column the passed in elem is at
	 * 
	 * @param elem is the type of Boardable whose column number we'd like to know
	 * @return the column int that elem is located
	 */
	public int getColumn(Boardable elem) {
		if(elementPlace.get(elem) == null) {
			throw new IllegalArgumentException("Element is not on the Board");
		}
		else if(elementPlace.get(elem).col > - 1 && elementPlace.get(elem).col < this.width) {
			return elementPlace.get(elem).col;
		}else {
			throw new IllegalArgumentException("Element is not on the Board");
		}
	}
	
	/**
	 * prints out the current status of the board using a nested for loop.
	 */
	synchronized public void printBoard() {
		for(int row = 0; row < this.height; row++) {
			System.out.print("\n");
			for(int col = 0; col < this.width; col ++) {
				System.out.print(this.board[row][col]);
			}
		}
	}
	
	/**
	 * called in the constructor and serves the purpose of filling the board with row/col amount of Cells.
	 */
	private void fillBoard() {
		for(int row = 0; row < this.height; row++) {
			for(int col = 0; col < this.width; col++) {
				this.board[row][col] = new Cell(row, col);
			}
		}
	} 
	
	
	/**
	 * updates this.hugged to let beenHugged() be updated to see if Jarvis has been hugged and therefore ending the game.
	 *
	 * @param hugged is passed in and then set this.hugged to its value of true or false
	 */
	public void setHugged(boolean hugged) {
		this.hugged = hugged;
	}
	
	/**
	 * returns true or false depending on if Jarvis has or hasn't been hugged
	 * 
	 * @return the value of this.hugged
	 */
	public boolean beenHugged() {
		return this.hugged;
	}
	
	/**
	 * returns the height of board
	 * 
	 * @return height tells the user the height of the board. Allows HomeworkTrap to be placed
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * returns the width of the board
	 * 
	 * @return width tells the user the width of the board. Allows HomeworkTrap to be placed
	 */
	public int getWidth() {
		return this.width;
	}
	
	
	
	/**
	 * Cell is a nested class with Board. Cell creates a Cell object that is used in Board. It uses instance variables int row,
	 * int col, boolean isVisible, and ArrayList<Boardable> elements.
	 * 
	 * @author Noah Beer
	 */
	public class Cell {
		
		/** stores the int for the row the Cell is at */
		private int row;
		
		/** stores the int for the column the Cell is at */
		private int col; 
		
		/** allows the Cell to either be visible or not be visible to the user */
		private boolean isVisible;
		
		/** stores each created element that is somehwhere on the board */
		private ArrayList<Boardable> elements; 
		
		/**
		 * public Cell() is a constructor that creates a cell object. It takes in parameters int row and int col and initializes this.row to row 
		 * and this.col to col. this.isVisible is initialized to false and ArrayList of type Boardable this.elements is initialized.
		 * 
		 * @param row is the current row for Cell to be at
		 * @param col is the current column for Cell to be at
		 */
		public Cell(int row, int col) {
			this.row = row; 
			this.col = col;
			this.isVisible = false; 
			this.elements = new ArrayList<Boardable>(); 
		}
		
		/**
		 * takes in a Boardable elem as a parameter and then adds it to the elements arraylist. isVisible is then set to true.
		 * 
		 * @param elem is the type of Boardable being added to the Cell
		 */
		public void addElement(Boardable elem) {
			if(this.elements.size() == 0) {
				this.elements.add(elem);
			}
			else if(this.elements.get(this.elements.size() -1 ).share(elem) == true) {
				this.elements.add(elem);
			}
			if(elem.isVisible() == true)
				this.isVisible = true;
		}
		
		/**
		 * takes in a Boardable elem as a parameter and then removes it from the elements arraylist if the elements
		 * arraylist contains Boardable elem.
		 * 
		 * @param elem is the type of Boardable being removed from the Cell
		 */
		public boolean removeElement(Boardable elem) {
			if(this.elements.contains(elem)) {
				this.elements.remove(elem);
				return true;
			}
			return false;
		}
		
		/**
		 * toString() returns '#' if isVisible() is false, the last element in the Cell's toString if isVisible() is true and ArrayList elements isn't empty, and ' ' otherwise.
		 */
		public String toString() {
			if(!this.isVisible) {
				return "#"; 
			}
			else if(this.elements.size() != 0 && this.elements.get(elements.size() - 1).isVisible()) {
				return elements.get(elements.size() - 1).toString();
			}else {
				 return " ";
			}
		}
	} // end class Cell
} // end class Board