package Main;

import java.util.ArrayList;
import java.util.List;

public class crew {

	private String name;
	public List<member> Members = new ArrayList<>();
	
	//name functions
	public void set_name(String Name) {
		name = Name;
	}
	public String get_name() {
		return name;
	}
	
	//members functions
	public void add_member(member Member) {
		Members.add(Member);
	}
	public List<member> get_members() {
		return Members;
	}
		
	
}
