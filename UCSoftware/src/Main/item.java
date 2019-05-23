package Main;

/**
 * @author      Daniel McInnes dmc245@uclive.ac.nz , David
 * @version     1.0
 * @since       1.0
 */

public class item {
	/**
	 * Name of item
	 */
	private String name;
	/**
	 * id of item
	 */
	public int id;
	/**
	 * cost of item
	 */
	private float cost;
	/**
	 * type of item
	 * <p>
	 * Item Types
	 * Type 0 = food
	 * Type 1 = Meds
	 * Type 2 = both
	 */
	private int type;
	/**
	 * improvement amount
	 */
	private float improvement;
	/**
	 * main item builder
	 * @param Name name of item
	 * @param Id Id of item
	 * @param Cost cost of item
	 * @param Type Type of item 0,1,2
	 * @param Improvement Improvement amount
	 */
	public item(String Name, int Id, float Cost, int Type, float Improvement) {
		name = Name;
		id = Id;
		cost = Cost;
		type = Type;
		improvement = Improvement;
	}
	
	/**
	 * gets item cost
	 * @return cost of item
	 */
	public float getCost() {
		return cost;
	}
	
	/**
	 * gets item type
	 * @return item type
	 */
	public float getType() {
		return type;
	}
	
	/**
	 * gets item name
	 * @return name of item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * gets improvement amount
	 * @return improvement amount
	 */
	public float getImprovement() {
		return improvement;
	}
}
