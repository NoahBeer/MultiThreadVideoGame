import java.util.Scanner;
/**
 * Game allows the Hug the Angry Jarvis game to be player. This class contains a main. In Game, the Board is set up, Player and Jarvis
 * objects are created, as well as Threads for each of them. When .start is called, the game begins and the quest to hug the angry Jarvis
 * begins.
 * 
 * @author Noah Beer
 */
public class Game {
	
		/**
		 * Main method.
		 * @param args 
		 */
	public static void main(String[] args) {
		
		int height;
		int width;
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the height for your Board.");
		height = input.nextInt();
		System.out.println("Please enter the width for your Board.");
		width = input.nextInt();
		
		Board b = new Board(height, width);
		Player p = new Player(b);
		Jarvis j = new Jarvis(b);
		Player offBoard = new Player(b);
		//b.getColumn(offBoard);
		
		Thread player = new Thread(p);
		Thread jarvis = new Thread(j);
		
		b.placeElement(p, 0, 0);
		b.placeElement(j, height - 1 , width - 1);
		
		player.start();
		jarvis.start();
		
	}
} //end class Game

