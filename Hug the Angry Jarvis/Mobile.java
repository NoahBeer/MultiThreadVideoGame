/**
 * Mobile is an abstract class that implements both Runnable and Boardable. Its only method, move(), is abstract.
 * 
 * @author Noah Beer
 */
public abstract class Mobile implements Runnable, Boardable {
	
	/** declares instance variable board to be used in the constructor and all sub classes */
	protected Board board;
	
	/**
	 * the Constructor initializes board.
	 * @param board is initialized to be used in sub classes
	 */
	public Mobile(Board board) {
		this.board = board;
	}
	
	/**
	 * an abstract method that will be implemented in sub classes.
	 */
	protected void move() {
	}
} // end abstract class Mobile