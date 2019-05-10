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
	public float get_cost() {
		return cost;
	}
	
	//gets the type of item
	public float get_type() {
		return type;
	}
	
	//gets the type of item
	public String get_name() {
		return name;
	}
	
	//gets the type of item
	public float get_improvement() {
		return improvement;
	}
}
