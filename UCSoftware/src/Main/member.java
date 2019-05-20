package Main;

public class member {

	private String name;
	private static float health;
	private float hunger;
	private float tiredness;
	private boolean sick;
	private Type2 type;
	private int actions = 3;

	
	public member(String Name, Type2 Type) {
		name = Name;
		type = Type;
	}

	
	public String getName() {
		return name;
	}
	
	//returns the current health of the crew member
	public float getHealth(){
		return health;
	}
	
	//gets the current status of the crew member
	public boolean getStatus() {
		return sick;
	}
	
	//gets the tiredness of the crew member
	public float getTiredness() {
		return tiredness;
	}
	
	//gets the hunger level of the crew member
	public float getHunger() {
		return hunger;
	}
	
	public String getTypeName() {
		return type.getTypeName();
	}
	
	public int getBaseRepair() {
		return type.getBaseRepair();
	}
	
	public void setActions(int value) {
		actions = value;
	}
	
	public float getActions(){
		return actions;
	}
	
	public void sleep() {
		tiredness += 3;
	}
	
	public void work() {
		tiredness -= 1;
	}
	
	public void consumeAction() {
		actions -= 1;
	}
}
