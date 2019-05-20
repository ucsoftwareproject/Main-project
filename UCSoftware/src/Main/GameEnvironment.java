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

	
	protected List<item> masterItems = new ArrayList<>();
	protected List<Type2> masterTypes = new ArrayList<>();
	public String shipName;
	public int shieldHp = 10;
	private int days = 3;
	private int currentDay = 0;
	public crew Crew;
	public outpost Outpost = new outpost();
	
	public item get_random_item() {
		
		Random rand = new Random();
		return masterItems.get(rand.nextInt(masterItems.size()));
	}
	
	public void spawnItems(int size) {
		Outpost.clearItems();
		int i = 0;
		while (i < size){
			Outpost.addItems(get_random_item());
			i += 1;
		}
		
		// for testing
		System.out.println("Outpost items:");
		for (item s: Outpost.getItems()) {
			System.out.println("\t* " + s.getName());
		}
		System.out.println("\n");
		
	}
	
	public List<item> shop_items(){
		return Outpost.getItems();
	}
	
	
	//outpost 
	public outpost getOutpost() {
		return Outpost;
	}
	
	// day functions
	public void setDays(int day) {
		days = day;
	}
	public void addDay () {
		if(days < 10) {
			days += 1;}
	}
	// used for setting the day in the GUI
	public void minusDay () {
		if(days > 3) {
			days -= 1;}
	}
	
	//used for ending the day in the game environment
	public void endDay () {
			days -= 1;
			spawnItems(6);
	}
	
	public String getDay() {
		return String.valueOf(days);
	}
	
	public int getShieldHP () {
		return shieldHp;
	}
	
	public void addShieldHP(int repair_v) {
		shieldHp += repair_v;
	}
	
	public void damageShield(int damage_v) {
		shieldHp -= damage_v;
	}
	
	//prints days for debug
	public void dayDebug() {
		System.out.println("total days: " + getDay() + "\n");
	}
	
	//prints days for debug
	public void crewDebug() {
		Crew.debug();
	}
	
	
	//builds Master_ items list
	private void buildItems() {
		
		// food
		masterItems.add( new item("Cake", 0, 40f, 0, 100f));
		masterItems.add( new item("Rations", 1, 10f, 0, 5f));
		masterItems.add( new item("Soda", 2, 1f, 0, 2f));
		masterItems.add( new item("Apple", 3, 25f, 0, 50f));
		
		// meds
		masterItems.add( new item("Med-Kit", 4, 40f, 1, 100f));
		masterItems.add( new item("Bandaid", 5, 5f, 1, 10f));
		masterItems.add( new item("Pain killer", 6, 10f, 1, 15f));
		masterItems.add( new item("Bandage", 7, 25f, 1, 50f));
		
		
		
		// for testing
		System.out.println("Master items:");
		for (item s: masterItems) {
			System.out.println("\t* " + s.getName());
		}
		System.out.println("\n");
	}
		
	private void buildTypes() {
		
		masterTypes.add(new Type2("ENGINEER"));
		masterTypes.add(new Type2("ATHLETE"));
		masterTypes.add(new Type2("SCIENTIST"));
		masterTypes.add(new Type2("PUSHOVER"));
		masterTypes.add(new Type2("CYBORG"));
		masterTypes.add(new Type2("DOCTOR"));
		
		// for testing
		System.out.println("Master types:");
		for (Type2 s: masterTypes) {
			System.out.println("\t* " + s.getTypeName());
		}
		System.out.println("\n");
	}
	
	//main setup controller
	public GameEnvironment() {
		
		//builds master lists
		buildItems();
		buildTypes();
		
		//make crew
		Crew = new crew("temp", 4);
		//spawn shop
		spawnItems(6);
	}
	
	public void addMember(String name, Type2 Type) {
		member Member = new member(name, Type);
		Crew.addMember(Member);
	}
	
	
	
	
	
	//sets the ships name
	public void setShipName(String name) {
		shipName = name;
	}
	
	public String getShipName() {
		return(shipName);
	}
	
	//sets up the GUI
	public void launchMainWindow() {
		GuiWelcomeScreen mainWindow = new GuiWelcomeScreen(this);
	}
	
	public void launchCrewWindow() {
		CrewSetupWindow crew_window = new CrewSetupWindow(this);
	}
	
	public void launchConfirmationScreen() {
		ConfirmationScreen confirm_screen = new ConfirmationScreen(this, Crew);
	}
	
	public void launchActionWindow() {
		ActionWindow action = new ActionWindow(this, Crew);
	}
	
	public void launchOutpost() {
		OutpostWindow outpost = new OutpostWindow(this);
	}
	
	public void launchEvent() {
		EventWindow event = new EventWindow(this);
	}
	
	public void launchFailure() {
		FailureWindow fail = new FailureWindow();
	}
	
	public void launchPlanetChanger() {
		PlanetChangeWindow changer = new PlanetChangeWindow(this, Crew);
	}
	
	public void launchItemUseWindow() {
		ItemUseWindow item = new ItemUseWindow(this, Crew);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameEnvironment engine = new GameEnvironment();
		engine.launchMainWindow();
		
		
	}

}
