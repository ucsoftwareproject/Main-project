package Main;

import java.util.ArrayList;
import java.util.List;

public class outpost {
	private item food;
	private item meds;
	private int distance;
	protected List<item> items = new ArrayList<>();
	
	//gets the distance from the ships location
	public int get_distance() {
		return distance;
	}
	
	
	public void add_items(item Item) {
		items.add(Item);
	}
	
	public void clear_items() {
		items.clear();
	}
	
	public List<item> get_items(){
		return items;
	}
}
