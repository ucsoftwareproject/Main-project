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
	protected List<Type2> master_types = new ArrayList<>();
	public String ship_name;
	private int days = 3;
	private int current_day = 0;
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
	
	//prints days for debug
	public void day_debug() {
		System.out.println("total days: " + get_day() + "\n");
	}
	
	//prints days for debug
	public void crew_debug() {
		Crew.debug();
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
	
	
	private void build_types() {
		
		master_types.add(new Type2("ENGINEER"));
		master_types.add(new Type2("ATHLETE"));
		master_types.add(new Type2("SCIENTIST"));
		master_types.add(new Type2("PUSHOVER"));
		master_types.add(new Type2("CYBORG"));
		master_types.add(new Type2("DOCTOR"));
		
		// for testing
		System.out.println("Master types:");
		for (Type2 s: master_types) {
			System.out.println("\t* " + s.get_type_name());
		}
		System.out.println("\n");
	}
	
	//main setup controller
	public game_environment() {
		
		//builds master lists
		build_items();
		build_types();
		
		//make crew
		Crew = new crew("temp", 4);
	}
	
	public void add_member(String name, Type2 Type) {
		member Member = new member(name, Type);
		Crew.add_member(Member);
	}
	
	
	
	
	
	//sets the ships name
	public void set_ship_name(String name) {
		ship_name = name;
	}
	
	public String get_ship_name() {
		return(ship_name);
	}
	
	//sets up the GUI
	public void launchMainScreen() {
		GUI_Welcome_Screen mainWindow = new GUI_Welcome_Screen(this);
	}
	
	public void launchcrew_screen() {
		Crew_setup_window crew_window = new Crew_setup_window(this);
	}
	
	public void launchconfirmationscreen() {
		Confirmation_screen confirm_screen = new Confirmation_screen(this, Crew);
	}
	
	public void launch_action_window() {
		action_window action = new action_window(this, Crew);
	}
	
	public void launch_outpost() {
		outpost_gui outpost = new outpost_gui(this);
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
