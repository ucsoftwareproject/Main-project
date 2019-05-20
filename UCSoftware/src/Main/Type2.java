package Main;

public class Type2 {
	static float health_buff;
	float tiredness_buff;
	float hunger_buff;
	int repair_buff;
	public String type_name;
	
	
	public Type2(String type) {
		set_stats(type);
	}
	
	//sets the individual stats of the class
	public void set_stats(String state) {
		switch (state) {
			case "ENGINEER":
				health_buff = 5;
				tiredness_buff = 5;
				hunger_buff = 5;
				repair_buff = 8;
				type_name = "Engineer";
				break;
				
			case "ATHLETE":
				health_buff = 7;
				tiredness_buff = 8;
				hunger_buff = 5;
				repair_buff = 3;
				type_name = "Athlete";
				break;
				
			case "SCIENTIST":
				health_buff = 6;
				tiredness_buff = 4;
				hunger_buff = 7;
				repair_buff = 6;
				type_name = "Scientist";
				break;
				
			case "PUSHOVER":
				health_buff = 2;
				tiredness_buff = 2;
				hunger_buff = 2;
				repair_buff = 2;
				type_name = "Pushover";
				break;
				
			case "CYBORG":
				health_buff = 7;
				tiredness_buff = 7;
				hunger_buff = 2;
				repair_buff = 7;
				type_name = "Cyborg";
				break;
				
			case "DOCTOR":
				health_buff = 8;
				tiredness_buff = 8;
				hunger_buff = 4;
				repair_buff = 3;
				type_name = "Doctor";
				break;
		}
	}	
	//gives the base stat for max health
	public float get_base_health(){
		return health_buff;
	}
	
	
	//gets the base stat for tiredness
	public float get_base_tiredness() {
		return tiredness_buff;
	}
	
	//gets the base stat for hunger
	public float get_base_hunger() {
		return hunger_buff;
	}
	
	//gets the base stat for repairing
	public int get_base_repair() {
		return repair_buff;
	}
	
	//gets the name
	public String get_type_name() {
		return type_name;
	}
	
	
}
