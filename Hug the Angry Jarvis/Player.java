import java.io.IOException;
import java.util.Scanner;
/**
 * The Player class is the main character of the game. The Player is able to move, be delayed by traps, and hug the angry Jarvis.
 * The Player is controlled using a Thread in Game.
 * 
 * @author Noah Beer
 */
public class Player extends Mobile {
	
	/** scans in which direction the Player wants to move*/
	private Scanner input;
	
	/** how long the player is delayed from moving*/
	private long delayTime;
	
	/**
	 * Creates a new Player object. Initializes delayTime to 0 and initializes input.
	 * 
	 * @param board is called using super() in order to allow Player to have access to Board methods.
	 */
	public Player(Board board) {
		super(board);
		this.input = new Scanner(System.in);
		this.delayTime = 0;
	}
	
	/**
	 * takes in user input specifying which direction the user would like to move. The entered value is tested using .equals and then
	 * sends the appropriate enum constant and the this pointer to board.move(). 
	 */
	protected void move() {
		this.delay();
		String direction;
		direction = this.input.nextLine();
		
		if(direction.equals("q")) { // checks to see if direction is equal to 'q' and then calls board.move and tells it to move the Player UP-LEFT
			board.move(Direction.UP_LEFT, this);
		}
		else if(direction.equals("w")) { // checks to see if direction is equal to 'w' and then calls board.move and tells it to move the Player UP
			board.move(Direction.UP, this);
		}
		else if(direction.equals("e")) { // checks to see if direction is equal to 'e' and then calls board.move and tells it to move the Player UP-RIGHT
			board.move(Direction.UP_RIGHT, this);
		}
		else if(direction.equals("a")) { // checks to see if direction is equal to 'q' and then calls board.move and tells it to move the Player LEFT
			board.move(Direction.LEFT, this);
		}
		else if(direction.equals("d")) { // checks to see if direction is equal to 'd' and then calls board.move and tells it to move the Player RIGHT
			board.move(Direction.RIGHT, this);
		}
		else if(direction.equals("z")) { // checks to see if direction is equal to 'z' and then calls board.move and tells it to move the Player DOWN-LEFT
			board.move(Direction.DOWN_LEFT, this);
		}
		else if(direction.equals("x")) { // checks to see if direction is equal to 'x' and then calls board.move and tells it to move the Player DOWN
			board.move(Direction.DOWN, this);
		}
		else if(direction.equals("c")) { // checks to see if direction is equal to 'c' and then calls board.move and tells it to move the Player DOWN_RIGHT
			board.move(Direction.DOWN_RIGHT, this);
		}
		else if(direction.equals("s")) { // checks to see if direction is equal to 's' and then stalls
		}
	}

	/**
	 * called when .start is called by the Player Thread in game. Continuously allows the Player to move until Jarvis has been hugged.
	 */
	public void run() {
		while(this.board.beenHugged() == false) {
			move();
		}
	}
	
	/**
	 * delays the user by delayTime, which should always be 5000 milliseconds. Called by HomeworkTrap share().
	 */
	public void delay() {
		try {
			Thread.sleep(this.delayTime);
			for(int i = 0; i < System.in.available(); i++) {
				System.in.read();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.delayTime = 0;
	}
	
	/**
	 * sets delayTime to time
	 * 
	 * @param time sets delayTime to its value
	 */
	public void setDelay(long time) {
		this.delayTime = time;
	}
	
	/**
	 * Sets the visibility of Player. Player is always visible
	 * 
	 * @return true always
	 */
	public boolean isVisible() {
		return true;
	}
	
	/**
	 * Player cannot share with any element
	 * 
	 * @param elem is the Boardable type trying to share with Player
	 * @return false always
	 */
	public boolean share(Boardable elem) {
		return false;
	}
	
	/**
	 * represents Player on the Board.
	 * 
	 * @param "*" always
	 */
	public String toString() {
		return "*";
	}
} // end class Player