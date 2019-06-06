import java.util.Random;

/**
 * public class Jarvis extends Mobile and is of type Boardable. Jarvis moves in a random direction on the board every 250 milliseconds 
 * until he is hugged. Every 4 moves Jarvis is able to place a HomeworkTrap adjacent of himself. Jarvis is invisible on the board, but 
 * if he is made visible, his toString returns a '?'. Upon being hugged, the Player wins the game. Jarvis is controlled using a 
 * Thread in Game
 * 
 * @author Noah Beer
 */
public class Jarvis extends Mobile {
	
	/** counts Jarvis's moves to make sure he lays a trap every four moves */
	private int countMoves;
	
	/** stores each of the possible moves for Jarvis */
	private String[] charMoves;
	
	/** used to generate a random move for Jarvis */
	static Random r = new Random(); 
	
	/**
	 * public Jarvis is the constructor for class Jarvis. super(board) is called referencing the constructor of Mobile. countMoves is
	 * initialized to 0 and charMoves[] is filled with each of the possible moves for Jarvis. Jarvis is also placed on the board.
	 * 
	 * @param board is passed into the constructor in order to reference board methods throughout Jarvis
	 *		 
	 **/
	public Jarvis(Board board) {
		super(board);
		this.countMoves = 0;
		charMoves = new String[] {"a", "q", "w", "e", "d", "z", "x", "c"};
	}
	
	/**
	 * places a HomeworkTrap adjacent of Jarvis
	 */
	private void layTrap() {
		HomeworkTrap hwt = new HomeworkTrap(board); 
		String storeMove;
		boolean didMove;
		didMove = false;
		while(didMove == false) {
			storeMove = charMoves[r.nextInt(charMoves.length)];
			
			if(storeMove.equals("q")) { // checks to see if direction is equal to 'q' and then places element in specified direction
				if(board.getRow(this) - 1 > -1 && board.getColumn(this) - 1 > -1 && board.getRow(this) - 1 < board.getHeight()  && board.getColumn(this) - 1 < board.getWidth()) {
					board.placeElement(hwt, board.getRow(this) - 1, board.getColumn(this) - 1);
					didMove = true;
				}
			}
			if(storeMove.equals("w")) { // checks to see if direction is equal to 'w' and then places element in specified direction
				if(board.getRow(this) - 1 > -1 && board.getColumn(this) > -1 && board.getRow(this) - 1 < board.getHeight()  && board.getColumn(this) < board.getWidth()) {
					board.placeElement(hwt, board.getRow(this) - 1, board.getColumn(this));
					didMove = true;
				}
			}
			if(storeMove.equals("e")) { // checks to see if direction is equal to 'e' and then places element in specified direction
				if(board.getRow(this) - 1 > -1 && board.getColumn(this) + 1 > -1 && board.getRow(this) - 1 < board.getHeight()  && board.getColumn(this) + 1 < board.getWidth()) {
					board.placeElement(hwt, board.getRow(this) - 1, board.getColumn(this) + 1);
					didMove = true;
				}
			}
			if(storeMove.equals("a")) { // checks to see if direction is equal to 'a' and then places element in specified direction
				if(board.getRow(this) > -1 && board.getColumn(this) - 1 > -1 && board.getRow(this) < board.getHeight()  && board.getColumn(this) - 1 < board.getWidth()) {
					board.placeElement(hwt, board.getRow(this), board.getColumn(this) - 1);
					didMove = true;
				}
			}
			if(storeMove.equals("d")) { // checks to see if direction is equal to 'd' and then places element in specified direction
				if(board.getRow(this) > -1 && board.getColumn(this) + 1 > -1 && board.getRow(this) < board.getHeight()  && board.getColumn(this) + 1 < board.getWidth()) {
					board.placeElement(hwt, board.getRow(this), board.getColumn(this) + 1);
					didMove = true;
				}
			}
			if(storeMove.equals("z")) { // checks to see if direction is equal to 'z' and then places element in specified direction
				if(board.getRow(this) + 1 > -1 && board.getColumn(this) - 1 > -1 && board.getRow(this) + 1 < board.getHeight()  && board.getColumn(this) - 1 < board.getWidth()) {
					board.placeElement(hwt, board.getRow(this) + 1, board.getColumn(this) - 1);
					didMove = true;
				}
			}
			if(storeMove.equals("x")) { // checks to see if direction is equal to 'x' and then places element in specified direction
				if(board.getRow(this) + 1 > -1 && board.getColumn(this) > -1 && board.getRow(this) + 1 < board.getHeight()  && board.getColumn(this) < board.getWidth()) {
					board.placeElement(hwt, board.getRow(this) + 1, board.getColumn(this));
					didMove = true;
				}
			}
			if(storeMove.equals("c")) { // checks to see if direction is equal to 'c' and then places element in specified direction
				if(board.getRow(this) + 1 > -1 && board.getColumn(this) + 1 > -1 && board.getRow(this) + 1 < board.getHeight()  && board.getColumn(this) + 1 < board.getWidth()) {
					board.placeElement(hwt, board.getRow(this) + 1, board.getColumn(this) + 1);
					didMove = true;
				}
			}
		}
	}
	
	/**
	 * allows Jarvis to move throughout the board. A random move is generated using the Random class to pick a random index
	 * from moves[] and the value at the randomly chosen index is then stored as storeMove. storeMove is then sent through a series
	 * of if statements checking to see if the value stored is equal to the compared to character. If so, board.move is called and
	 * the correct direction is referenced causing Jarvis to move on the board.
	 */
	protected void move() {
		String storeMove;
		storeMove = charMoves[r.nextInt(charMoves.length)];

		if(storeMove.equals("q")) { // checks to see if direction is equal to 'q' and then calls board.move and tells it to move the Player UP-LEFT
			board.move(Direction.UP_LEFT, this);
		} else if(storeMove.equals("w")) { // checks to see if direction is equal to 'w' and then calls board.move and tells it to move the Player UP
			board.move(Direction.UP, this);
		} else if(storeMove.equals("e")) { // checks to see if direction is equal to 'e' and then calls board.move and tells it to move the Player UP-RIGHT
			board.move(Direction.UP_RIGHT, this);
		} else if(storeMove.equals("a")) { // checks to see if direction is equal to 'q' and then calls board.move and tells it to move the Player LEFT
			board.move(Direction.LEFT, this);
		} else if(storeMove.equals("d")) { // checks to see if direction is equal to 'd' and then calls board.move and tells it to move the Player RIGHT
			board.move(Direction.RIGHT, this);
		} else if(storeMove.equals("z")) { // checks to see if direction is equal to 'z' and then calls board.move and tells it to move the Player DOWN-LEFT
			board.move(Direction.DOWN_LEFT, this);
		} else if(storeMove.equals("x")) { // checks to see if direction is equal to 'x' and then calls board.move and tells it to move the Player DOWN
			board.move(Direction.DOWN, this);
		} else if(storeMove.equals("c")) { // checks to see if direction is equal to 'c' and then calls board.move and tells it to move the Player DOWN_RIGHT
			board.move(Direction.DOWN_RIGHT, this);
		}
		
	}
	
	/**
	 * called when .start() is called by the Jarvis Thread in Game. While Jarvis hasn't been hugged, Jarvis is 
	 * prompted to move. Every four moves Jarvis is prompted to lay a HomeworkTrap. Moves are kept track of using countMoves which
	 * is incremented by one each time run() successfully compiles.
	 */
	public void run() {
		while(this.board.beenHugged() == false) {
			move();
			if(this.countMoves == 4) {
				layTrap();
				this.countMoves = 0;
			}
			try {
				Thread.sleep(250);
				this.countMoves++;
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * isVisible always returns false because Jarvis is not meant to be visible in the Game.
	 * @return false
	 */
	public boolean isVisible() {
		return false;
	}
	
	/**
	 * share() tests to see how Jarvis reacts with each elem. If it's of type Player, setHugged() is set to true and the game ends.
	 * 
	 * @param elem is passed in so the elem can be compared to types to see if Jarvis is able to share a cell with them.
	 * @return returns true if elem is an instance of Mobile. Returns false if not.
	 */
	public boolean share(Boardable elem) {
		if(elem instanceof Mobile) {
			if(elem instanceof Player) {
				this.board.setHugged(true);
				System.out.println("Jarvis has been hugged. Game is now over.");
			}
			return true;
		}
		return false;
	}
	
	/**
	 * toString() returns a "?" to represent Jarvis on the Board
	 * @return "?"
	 */
	public String toString() {
		return "?";
	}
} // end class Jarvis