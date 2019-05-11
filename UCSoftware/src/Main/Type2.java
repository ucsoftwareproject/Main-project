package Main;

public class Type2 {
	static float health_buff;
	float tiredness_buff;
	float hunger_buff;
	float repair_buff;
	public String type_name;
	
	
	public Type2(String type) {
		set_stats(type);
	}
	
	//sets the individual stats of the class
	public void set_stats(String state) {
		switch (state) {
			case "ENGINEER":
				health_buff = 7;
				tiredness_buff = 5;
				hunger_buff = 5;
				repair_buff = 5;
				type_name = "Engineer";
				break;
				
			case "ATHLETE":
				health_buff = 5;
				tiredness_buff = 5;
				hunger_buff = 5;
				repair_buff = 5;
				type_name = "Athlete";
				break;
				
			case "SCIENTIST":
				health_buff = 5;
				tiredness_buff = 5;
				hunger_buff = 5;
				repair_buff = 5;
				type_name = "Scientist";
				break;
				
			case "PUSHOVER":
				health_buff = 5;
				tiredness_buff = 5;
				hunger_buff = 5;
				repair_buff = 5;
				type_name = "Pushover";
				break;
				
			case "CYBORG":
				health_buff = 5;
				tiredness_buff = 5;
				hunger_buff = 5;
				repair_buff = 5;
				type_name = "Cyborg";
				break;
				
			case "DOCTOR":
				health_buff = 5;
				tiredness_buff = 5;
				hunger_buff = 5;
				repair_buff = 5;
				type_name = "DOCTOR";
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
	public float get_base_repair() {
		return repair_buff;
	}
	
	//gets the name
	public String get_type_name() {
		return type_name;
	}
}
