/**
 * 
 */
package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

/**
 * @author      Daniel McInnes, David Turton
 * @version     1.0
 * @since       1.0
 */
public class GameEnvironment {

	/**
	 * MasterList of items.
	 */
	protected List<item> masterItems = new ArrayList<>();
	/**
	 * Master list of types.
	 */
	protected List<Type2> masterTypes = new ArrayList<>();
	/**
	 * The Name of the ship.
	 */
	public String shipName;
	/**
	 * The health of the ship.
	 */
	public int shieldHp = 10;
	/**
	 * The days left.
	 */
	private int days = 3;
	/**
	 * The crew.
	 */
	public crew Crew;
	/**
	 * The outpost.
	 */
	public outpost Outpost = new outpost();
	/**
	 * The total ship parts needed.
	 */
	public int partsNeeded;
	/**
	 * The current number of ship parts.
	 */
	public int currentParts = 0;
	/**
	 * The planet.
	 */
	public Planet planet;
	
	
	
	/**
	 * sets the planet to searched.
	 */
	public void planetSearched() {
		planet.searched();
	}
	
	/**
	 * sets the planet to not searched
	 */
	public void newPlanet() {
		planet.newPlanet();
	}
	
	/**
	 * check if planet is searched.
	 * @return boolean true if searched
	 */
	public boolean searched() {
		return planet.isSearched();
	}
	
	
	
	
	/**
	 * adds money to crew.
	 * @param  maxAmmount max ammount of money to be added.
	 */
	public void crewAddMoney(int maxAmmount) {
		int amount = randomNumber(maxAmmount);
		Crew.addMoney(amount);
	}
	
	
	/**
	 * adds item to crew.
	 * @param  item item to be added
	 */
	public void crewAddItem(item item) {
		Crew.addItem(item);
	}
	
	/**
	 * gets a random number in range.
	 * @param  max max number.
	 * @return random number
	 */
	public int randomNumber(int max) {
		Random rand = new Random();
		return rand.nextInt(max);
	}
	
	/**
	 * gets parts needed.
	 * @return number of parts.
	 */
	public int partsTotal() {
		return partsNeeded;
	}
	/**
	 * Parts the crew has.
	 * @return amount of parts the crew has
	 */
	public int partsCurrent() {
		return currentParts;
	}
	/**
	 * dead function
	 */
	public void addPart() {
		currentParts += 1;
		if (currentParts >= partsNeeded) {
			//win here
		}
		
	}
	/**
	 * Set the amount of parts needed to win
	 * @param days length of the game.
	 */
	public void setPartsNeeded(int days) {
		float temp = days * (2f/3f);
		partsNeeded = (int) temp;
		System.out.println("Parts Needed: " + partsNeeded);
	}
	/**
	 * gets the parts needed.
	 * @return the parts needed.
	 */
	public int getPartsNeeded() {
		return partsNeeded;
	}
	
	/**
	 * gets a random item form the item list. 
	 * @return random item from the master list.
	 */
	public item get_random_item() {
		
		Random rand = new Random();
		return masterItems.get(rand.nextInt(masterItems.size()));
	}
	/**
	 * spawns a new outpost
	 * <p>
	 * clears the old outpost shop and and makes a new one.
	 * 
	 * @param  size size of outpost shop.
	 */
	public void spawnItems(int size) {
		System.out.println("Outpost changing (spawning new items)");
		Outpost.clearItems();
		int i = 0;
		while (i < size){
			Outpost.addItems(get_random_item());
			i += 1;
		}
		System.out.println("Outpost items:");
		for (item s: Outpost.getItems()) {
			System.out.println("\t* " + s.getName());
		}
		System.out.println("\n");
		
	}
	/**
	 * Gets a list of items from the shop
	 * @return list of items in shop.
	 */
	public List<item> shop_items(){
		return Outpost.getItems();
	}
	
	
	/**
	 * gets the outpost
	 * @return returns the outpost
	 */
	public outpost getOutpost() {
		return Outpost;
	}
	
	/**
	 * sets the days
	 * @param  day The day to be set.
	 */
	public void setDays(int day) {
		days = day;
	}
	/**
	 * add one to the day
	 */
	public void addDay () {
		if(days < 10) {
			days += 1;}
	}
	/**
	 * removes a day
	 */
	public void minusDay () {
		if(days > 3) {
			days -= 1;}
	}
	
	/**
	 * end of day
	 */
	public void endDay () {
			days -= 1;
	}
	/**
	 * get current day.
	 * @return the day as a string.
	 */
	public String getDay() {
		return String.valueOf(days);
	}

	/**
	 * get gets the sheilds HP
	 * @return HP of the sheilds.
	 */
	public int getShieldHP () {
		return shieldHp;
	}

	/**
	 * get current day.
	 * @param repair_v ammount to repair the shield
	 */
	public void addShieldHP(int repair_v) {
		shieldHp += repair_v;
	}

	/**
	 * get current day.
	 * @param  damage_v damage the sheilds will take
	 */
	public void damageShield(int damage_v) {
		shieldHp -= damage_v;
	}
	

	/**
	 * console day output
	 */
	public void dayDebug() {
		System.out.println("total days: " + getDay() + "\n");
	}
	

	/**
	 * runs console debug output
	 */
	public void crewDebug() {
		Crew.debug();
	}
	
	
	/**
	 * Builds master item list
	 */
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
		
	/**
	 * Builds main charter types
	 */
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
	
	/**
	 * Main game setup
	 */
	public GameEnvironment() {
		
		//builds master lists
		buildItems();
		buildTypes();
		
		//make crew
		Crew = new crew("temp", 4);
		planet = new Planet();
		//spawn shop
		spawnItems(6);
		
	}
	/**
	 * get current day.
	 * @param name the name of the Member
	 * @param Type the type of the member 
	 */
	public void addMember(String name, Type2 Type) {
		member Member = new member(name, Type);
		Crew.addMember(Member);
	}
	
	/**
	 * sets the name of the ship
	 * @param name set the name of the ship
	 */
	public void setShipName(String name) {
		shipName = name;
	}
	/**
	 * get the name of the ship
	 * @return ship name
	 */
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
		FailureWindow fail = new FailureWindow(this, Crew);
	}
	
	public void launchWin() {
		WinScreenWindow win = new WinScreenWindow(this, Crew);
	}
	
	public void launchPlanetChanger() {
		PlanetChangeWindow changer = new PlanetChangeWindow(this, Crew);
	}
	
	public void launchItemUseWindow() {
		ItemUseWindow item = new ItemUseWindow(this, Crew);
	}
	
	/**
	 * get the score for the game
	 * @return the total score
	 */
	public int getScore() {
		int score = 0;
		for (member s: Crew.getMembers()) {
			score += s.getHunger();
			score += s.getHealth();
			score += s.getTiredness();
			if (s.getTypeName() == "Pushover"){
					score += 500;}
			}
		score += currentParts * 400;
		score += days * 100;
		return score;
		}
	
	/**
	 * program start
	 * @param args main args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameEnvironment engine = new GameEnvironment();
		engine.launchMainWindow();
		
		
	}

}
