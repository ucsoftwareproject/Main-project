package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class crew {

	private String name;
	public static List<member> Members = new ArrayList<>();
	private int maxSize;
	private int money = 100;
	private List<item> itemsOnShip = new ArrayList<>();
	
	public crew(String Name, int Size) {
		name = Name;
		maxSize = Size;
	}
	
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
	
	public int getSize() {
		int crewSize = Members.size();
		return crewSize;
	}
	
	public void removeMember(Object o) {
		int item = getSize();
		System.out.println(item);
		Members.remove(o);
	}
		
	//attack
	public void alien() {
		if (itemsOnShip.size() != 0) {
			int size = itemsOnShip.size();
			Random rand = new Random();
			itemsOnShip.remove(rand.nextInt(size));
		}
		
	}
	

	public void plage() {
		int size = Members.size();
		Random rand = new Random();
		Members.get(rand.nextInt(size)).plague();
	}
	
	
	public void addItem(item Item) {
		itemsOnShip.add(Item);
	}
	
	public item getItem(int index) {
		return itemsOnShip.get(index);
	}
	
	public void removeItem(int index) {
		itemsOnShip.remove(index);
	}
	
	public List<item> getAllItems(){
		return itemsOnShip;
	}
	
	//name functions
	public void setName(String Name) {
		name = Name;
	}
	public String getName() {
		return name;
	}
	public int getMaxSize() {
		return maxSize;
	}
	
	//members functions
	public void addMember(member Member) {
		Members.add(Member);
	}
	public List<member> getMembers() {
		return Members;
	}
	
	//money functions
	public void setMoney(int amount) {
		money = amount;
	}
	public int getMoney() {
		return money;
	}
	public void addMoney(float amount) {
		money += amount;
	}
	public void subMoney(float amount) {
		money += -amount;
	}

	
}
