package Main;
/**
 * @author      Daniel McInnes, David Turton
 * @version     1.0
 * @since       1.0
 */
public class Planet {
	/**
	 * is planet Searched
	 */
	private boolean Searched = false;
	
	/**
	 * Searched the planet
	 * <p>
	 * set bool to true
	 */
	public void searched() {
		Searched = true;
	}
	/**
	 * get new planet
	 * <p>
	 * set bool to false
	 */
	public void newPlanet() {
		Searched = false;
	}
	/**
	 * check if Searched
	 * @return true if Searched
	 */
	public boolean isSearched() {
		return Searched;
	}
}
