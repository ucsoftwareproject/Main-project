package Main;

public class Planet {

	private boolean Searched = false;
	
	
	public void searched() {
		Searched = true;
	}
	
	public void newPlanet() {
		Searched = false;
	}
	
	public boolean isSearched() {
		return Searched;
	}
}
