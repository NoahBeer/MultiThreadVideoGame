/**
 * HomeworkTrap is a trap that delays the player 5000 mil liseconds when the player enters the same cell that HomeworkTrap is currently
 * in. Upon being "stepped" on by a Player, the HomeworkTrap is then removed from the board. HomeworkTraps are not visible on the board.
 * 
 * @author Noah Beer
 */
public class HomeworkTrap implements Boardable {
	/**The board on which this trap is placed*/
	private Board board;
	
	/**
	 * public HomeworkTrap is the constructor for HomeworkTrap.
	 * @param board passes in a Board to be initialized in the constructor to this.board. board is used throughout the class.
	 */
	public HomeworkTrap(Board board) {
		this.board = board;
	}
	
	/**
	 * Checks to see if what type elem is. If it's a Player, true is returned and the Player is delayed 5000 miliseconds.
	 * If it's a Jarvis, true is returned. Anything else, false is returned.
	 * 
	 * @param elem passes in a Boardable object to be tested to see whether or not it is an instance of Player, Jarvis, or other.
	 * @return true if elem is an instance of Player or Jarvis. False is not.
	 */
	public boolean share(Boardable elem) {
		if(elem instanceof Player) {
			((Player) elem).setDelay(5000);
			board.removeElement(this);
			System.out.println("The player has stepped on a homework trap. The Player is now delayed for 5000 miliseconds.");
			return true;
		}
		else if (elem instanceof Jarvis) {
			return true;
		}else { 
			return false;
		}
	}
	
	/**
	 * always is set to false
	 * 
	 * @return false
	 */
	public boolean isVisible() {
		return false;
	}
	
	/**
	 * returns the toString of HomeworkTrap
	 * 
	 * @return " " returns a space
	 */
	public String toString() {
		return " ";
	}
} // end class HomeworkTrap