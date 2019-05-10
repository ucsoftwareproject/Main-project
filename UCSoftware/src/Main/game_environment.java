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
	private List<crew> Master_crew = new ArrayList<>();
	
	private int days = 3;
	crew Crew;
	
	
	// day functions
	public void set_days(int day) {
		days = day;
	}
	public void add_day () {
		if(days < 10) {
			days += 1;}
	}
	public void minus_day () {
		if(days > 3) {
			days -= 1;}
	}
	public String get_day() {
		return String.valueOf(days);
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
		
		//make crew
		Crew = new crew("temp", 6);
	}
	
	//sets up the GUI
	public void launchMainScreen() {
		GUI_Welcome_Screen mainWindow = new GUI_Welcome_Screen(this);
	}
	
	public void launchcrew_screen() {
		Crew_setup_window crew_window = new Crew_setup_window(this);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		game_environment engine = new game_environment();
		engine.launchMainScreen();
		
		
	}

}
