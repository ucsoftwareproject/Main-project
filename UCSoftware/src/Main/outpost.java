package Main;

import java.util.ArrayList;
import java.util.List;
/**
 * @author      Daniel McInnes, David Turton
 * @version     1.0
 * @since       1.0
 */

public class outpost {

	/**
	 * list of items in the outpost
	 */
	protected List<item> items = new ArrayList<>();
	
	/**
	 * add item to outpost
	 * @param Item item to be added
	 */
	public void addItems(item Item) {
		items.add(Item);
	}
	/**
	 * clear items in outpost
	 */
	public void clearItems() {
		items.clear();
	}
	/**
	 * get the list of items in the outpost
	 * @return returns list of items
	 */
	public List<item> getItems(){
		return items;
	}
}
