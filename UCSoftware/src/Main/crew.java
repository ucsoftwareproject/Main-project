package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;


/**
 * @author      Daniel McInnes dmc245@uclive.ac.nz , David
 * @version     1.0
 * @since       1.0
 */

public class crew {
	/**
	 * Name of crew
	 */
	private String name;
	/**
	 * list of members
	 */
	public static List<member> Members = new ArrayList<>();
	/**
	 * max size of crew
	 */
	private int maxSize;
	/**
	 * money the crew has
	 */
	private int money = 100;
	/**
	 * items on the ship
	 */
	private List<item> itemsOnShip = new ArrayList<>();
	
	/**
	 * adds item to crew.
	 * @param  Name Name of the crew
	 * @param Size Size of the crew
	 */
	public crew(String Name, int Size) {
		name = Name;
		maxSize = Size;
	}
	
	/**
	 * For printing debug info to the console
	 */
	public void debug() {
		// for testing
		System.out.println("Crew:");
		for (member s: Members) {
			System.out.println("\t*Name: " + s.getName() + " Type: " + s.getTypeName());
		}
		System.out.println("\n items on ship");
		
		for (item s: itemsOnShip) {
			System.out.println("\t*Item: " + s.getName());
		}
		System.out.println("\n");
	}
	/**
	 * get size of crew
	 * @return size of crew
	 */
	public int getSize() {
		int crewSize = Members.size();
		return crewSize;
	}
	
	/**
	 * removes a member
	 * @param o person to be removed
	 */
	public void removeMember(Object o) {
		Members.remove(o);
	}
		
	/**
	 * Alien attack
	 * <p>
	 * picks a random item from the crew and removes it
	 */
	public void alien() {
		if (itemsOnShip.size() != 0) {
			int size = itemsOnShip.size();
			Random rand = new Random();
			itemsOnShip.remove(rand.nextInt(size));
		}
		
	}
	
	/**
	 * Plage
	 * <p>
	 * makes a random crew member sick
	 */
	public void plage() {
		// if indexing error
		try {
			int size = Members.size();
			Random rand = new Random();
			System.out.println("size of crew: " + size);
			Members.get(rand.nextInt(size)).plague();
		}catch (Exception e) {
			Members.get(0).plague();
			System.out.println("indexing fallback");
		}

	}
	
	/**
	 * add a items to the crew
	 * @param Item Item to be added
	 */
	public void addItem(item Item) {
		itemsOnShip.add(Item);
	}
	
	/**
	 * gets a item form the crew.
	 * @param index index of item
	 * @return item
	 */
	public item getItem(int index) {
		return itemsOnShip.get(index);
	}
	/**
	 * removes a item from the crew.
	 * @param index index of item
	 */
	public void removeItem(int index) {
		itemsOnShip.remove(index);
	}
	/**
	 * Gets the item the crew has
	 * @return returns the items the crew has
	 */
	public List<item> getAllItems(){
		return itemsOnShip;
	}
	
	/**
	 * Sets the name of the crew
	 * @param  Name Name of crew
	 */
	public void setName(String Name) {
		name = Name;
	}
	
	/**
	 * gets the name of the crew
	 * @return returns the name of the crew
	 */
	public String getName() {
		return name;
	}
	/**
	 * Gets the max size of the crew
	 * @return max size
	 */
	public int getMaxSize() {
		return maxSize;
	}
	
	/**
	 * added a member to the crew
	 * @param Member member to be added 
	 */
	public void addMember(member Member) {
		Members.add(Member);
	}
	/**
	 * gets list of crew members
	 * @return list of the members
	 */
	public List<member> getMembers() {
		return Members;
	}
	
	/**
	 * set the crews money
	 * @param amount amount of money
	 */
	public void setMoney(int amount) {
		money = amount;
	}
	/**
	 * get the money the crew has
	 * @return crew money
	 */
	public int getMoney() {
		return money;
	}
	/**
	 * added money to crew
	 * @param amount money to be added
	 */
	public void addMoney(float amount) {
		money += amount;
	}
	/**
	 * remove money to crew
	 * @param amount money to be removed
	 */
	public void subMoney(float amount) {
		money += -amount;
	}

	
}
