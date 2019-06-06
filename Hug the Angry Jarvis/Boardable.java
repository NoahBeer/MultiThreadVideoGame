/**
 * public interface Boardable provides a method signatures to be implements by other Boardable objects that derive from Boardable. Boardable
 * provides lab5 with method signature isVisible which is used in Stylus.
 * 
 * @author Noah Beer
 */
public interface Boardable {
	
	/**
	 * isVisible() is a method that is able to be used through deriving classes.
	 */
	public boolean isVisible();
	
	/**
	 * share() is a method that is able to be used through deriving classes
	 */
	public boolean share(Boardable elem);
	
	/**
	 * toString() is a method that is able to be used through deriving classes
	 */
	public String toString();
} // end interface Boardable