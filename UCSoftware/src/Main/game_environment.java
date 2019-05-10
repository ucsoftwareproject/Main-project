/**
 * 
 */
package Main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daniel
 *
 */
public class game_environment {

	
	protected List<item> master_items = new ArrayList<>();
	
	private int days = 0;
	crew Crew = new crew();
	
	
	// day functions
	public void set_days(int day) {
		days = day;
	}
	public void add_day () {
		days += 1;
	}
	public int get_day() {
		return days;
	}
	
	
	
	//builds Master_ items list
	private void build_items() {
		
		// food
		master_items.add( new item("cake", 0, 40f, 0, 100f));
		master_items.add( new item("rations", 1, 10f, 0, 5f));
		master_items.add( new item("soda", 2, 1f, 0, 2f));
		master_items.add( new item("apple", 3, 25f, 0, 50f));
		
		//meds
		master_items.add( new item("Med Kit", 4, 40f, 1, 100f));
		master_items.add( new item("band aid", 5, 5f, 1, 10f));
		master_items.add( new item("pain killer", 6, 10f, 1, 15f));
		master_items.add( new item("bandage", 7, 25f, 1, 50f));
		
		
		
		// for testing
		System.out.println("Master items:");
		for (item s: master_items) {
			System.out.println("\t* " + s.get_name());
		}
		System.out.println("\n");
	}
	
	//main setup controller
	public game_environment() {
		build_items();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		game_environment engine = new game_environment();
		
		
	}

}
