package Main;

import java.util.ArrayList;
import java.util.List;

public class crew {

	private String name;
	public List<member> Members = new ArrayList<>();
	private int max_size;
	
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
		System.out.println("\n");
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
		
	
}
