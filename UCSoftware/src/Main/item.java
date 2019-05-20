package Main;

public class item {

	private String name;
	public int id;
	private float cost;
	private int type;
	private float improvement;
	
	
	
	/**  
	 * Item Types
	 * Type 0 = food
	 * Type 1 = Meds
	 * Type 2 = both
	 * */
	public item(String Name, int Id, float Cost, int Type, float Improvement) {
		name = Name;
		id = Id;
		cost = Cost;
		type = Type;
		improvement = Improvement;
	}
	
	//gets the cost of an item
	public float getCost() {
		return cost;
	}
	
	//gets the type of item
	public float getType() {
		return type;
	}
	
	//gets the name of item
	public String getName() {
		return name;
	}
	
	//gets the quality of item
	public float getImprovement() {
		return improvement;
	}
}
