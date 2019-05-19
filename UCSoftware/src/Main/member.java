package Main;

public class member {

	private String name;
	private static float health;
	private float hunger;
	private float tiredness;
	private boolean sick;
	private Type2 type;
	
	public member(String Name, Type2 Type) {
		name = Name;
		type = Type;
	}

	
	public String get_name() {
		return name;
	}
	
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
	
	public String get_type_name() {
		return type.get_type_name();
	}
	
	public int get_base_repair() {
		return type.get_base_repair();
	}
	
	
	public void sleep() {
		tiredness += 3;
	}
	
	public void work() {
		tiredness -= 1;
	}
}
