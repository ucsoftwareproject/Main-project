package Main;

import java.util.ArrayList;
import java.util.List;

public class crew {

	private String name;
	public static List<member> Members = new ArrayList<>();
	private int max_size;
	private int money = 100;
	private List<item> items_on_ship = new ArrayList<>();
	
	public crew(String Name, int Size) {
		name = Name;
		max_size = Size;
	}
	
	public void debug() {
		// for testing
		System.out.println("Crew:");
		for (member s: Members) {
			System.out.println("\t*Name: " + s.get_name() + " Type: " + s.get_type_name());
		}
		System.out.println("\n items on ship");
		
		for (item s: items_on_ship) {
			System.out.println("\t*Item: " + s.get_name());
		}
		System.out.println("\n");
	}
	
	
	public void add_item(item Item) {
		items_on_ship.add(Item);
	}
	
	public item get_item(int index) {
		return items_on_ship.get(index);
	}
	
	//name functions
	public void set_name(String Name) {
		name = Name;
	}
	public String get_name() {
		return name;
	}
	public int get_max_size() {
		return max_size;
	}
	
	//members functions
	public void add_member(member Member) {
		Members.add(Member);
	}
	public List<member> get_members() {
		return Members;
	}
	
	//money functions
	public void set_money(int amount) {
		money = amount;
	}
	public int get_money() {
		return money;
	}
	public void add_money(float amount) {
		money += amount;
	}
	public void sub_money(float amount) {
		money += -amount;
	}
		
	
}
