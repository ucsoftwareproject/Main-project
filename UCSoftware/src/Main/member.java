package Main;

public class member {

	private String name;
	private float health;
	private float hunger;
	private float tiredness;
	private boolean sick;
	private Type2 type;
	private int actions = 3;

	
	public member(String Name, Type2 Type) {
		name = Name;
		type = Type;
		health = type.getBaseHealth() * 10;
		tiredness = type.getBaseTiredness() * 10;
		hunger = type.getBaseHunger() * 10;
	}
	
	public void plague() {
		sick = true;
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
		tiredness += 30;
	}
	
	public void work() {
		tiredness -= 10;
	}
	
	public void consumeAction() {
		if (actions > 0) {
			actions -= 1;
		}
	}
	
	public void eat(float amount) {
		hunger += amount;
	}
	
	public void loseHunger() {
		hunger -= 10;
	}
	
	public void loseHealth(int value) {
		health -= value;
	}
	public void meds(float amount) {
		health += amount;
		sick = false;
	}
	
	public void useItem(item item) {
		System.out.println("using item: " + item.getName());
		if (item.getType() == 0) {
			eat(item.getImprovement());
		}else if (item.getType() == 1) {
			meds(item.getImprovement());
		}else {
			eat(item.getImprovement());
			meds(item.getImprovement());
		}
			
	}
}
