/**
 * 
 */
package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

/**
 * @author daniel
 *
 */
public class GameEnvironment {

	
	protected List<item> master_items = new ArrayList<>();
	private List<crew> Master_crew = new ArrayList<>();
	protected List<Type2> master_types = new ArrayList<>();
	public String ship_name;
	public int shield_hp = 10;
	private int days = 3;
	private int current_day = 0;
	public crew Crew;
	public outpost Outpost = new outpost();
	
	public item get_random_item() {
		
		Random rand = new Random();
		return master_items.get(rand.nextInt(master_items.size()));
	}
	
	public void spawn_items(int size) {
		Outpost.clear_items();
		int i = 0;
		while (i < size){
			Outpost.add_items(get_random_item());
			i += 1;
		}
		
		// for testing
		System.out.println("Outpost items:");
		for (item s: Outpost.get_items()) {
			System.out.println("\t* " + s.get_name());
		}
		System.out.println("\n");
		
	}
	
	public List<item> shop_items(){
		return Outpost.get_items();
	}
	
	
	//outpost 
	public outpost get_outpost() {
		return Outpost;
	}
	
	// day functions
	public void set_days(int day) {
		days = day;
	}
	public void add_day () {
		if(days < 10) {
			days += 1;}
	}
	// used for setting the day in the GUI
	public void minus_day () {
		if(days > 3) {
			days -= 1;}
	}
	
	//used for ending the day in the game environment
	public void end_day () {
			days -= 1;
			spawn_items(6);
	}
	
	public String get_day() {
		return String.valueOf(days);
	}
	
	public int get_shield_hp () {
		return shield_hp;
	}
	
	public void add_shield_hp(int repair_v) {
		shield_hp += repair_v;
	}
	
	public void damage_shield(int damage_v) {
		shield_hp -= damage_v;
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
		
		// meds
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
	public GameEnvironment() {
		
		//builds master lists
		build_items();
		build_types();
		
		//make crew
		Crew = new crew("temp", 4);
		//spawn shop
		spawn_items(6);
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
		GuiWelcomeScreen mainWindow = new GuiWelcomeScreen(this);
	}
	
	public void launchcrew_screen() {
		CrewSetupWindow crew_window = new CrewSetupWindow(this);
	}
	
	public void launchconfirmationscreen() {
		ConfirmationScreen confirm_screen = new ConfirmationScreen(this, Crew);
	}
	
	public void launch_action_window() {
		ActionWindow action = new ActionWindow(this, Crew);
	}
	
	public void launch_outpost() {
		OutpostWindow outpost = new OutpostWindow(this);
	}
	
	public void launch_event() {
		EventWindow event = new EventWindow(this);
	}
	
	public void launch_failure() {
		FailureWindow fail = new FailureWindow();
	}
	
	public void launch_planet_changer() {
		PlanetChangeWindow changer = new PlanetChangeWindow(this, Crew);
	}
	
	public void launch_item_use_window() {
		ItemUseWindow item = new ItemUseWindow(this, Crew);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameEnvironment engine = new GameEnvironment();
		engine.launchMainScreen();
		
		
	}

}