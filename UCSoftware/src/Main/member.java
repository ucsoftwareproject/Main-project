package Main;

public class member {

	private String name;
	private float health;
	private float hunger;
	private float tiredness;
	private boolean sick;
	
	//returns the current health of the crew member
	public float get_health(){
		return health;
	}
	
	//gets the current status of the crew member
	public boolean get_status() {
		return sick;
	}
	
	//gets the tiredness of the crew member
	public float get_tiredness() {
		return tiredness;
	}
	
	//gets the hunger level of the crew member
	public float get_hunger() {
		return hunger;
	}
	
	
}
