package Main;

import java.util.ArrayList;
import java.util.List;

public class outpost {
	private item food;
	private item meds;
	private int distance;
	protected List<item> items = new ArrayList<>();
	
	//gets the distance from the ships location
	public int getDistance() {
		return distance;
	}
	
	
	public void addItems(item Item) {
		items.add(Item);
	}
	
	public void clearItems() {
		items.clear();
	}
	
	public List<item> getItems(){
		return items;
	}
}
