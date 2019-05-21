package Main;

public class Type2 {
	float healthBuff;
	float tirednessBuff;
	float hungerBuff;
	int repairBuff;
	public String typeName;
	
	
	public Type2(String type) {
		setStats(type);
	}
	
	//sets the individual stats of the class
	public void setStats(String state) {
		switch (state) {
			case "ENGINEER":
				healthBuff = 5;
				tirednessBuff = 5;
				hungerBuff = 5;
				repairBuff = 8;
				typeName = "Engineer";
				break;
				
			case "ATHLETE":
				healthBuff = 7;
				tirednessBuff = 8;
				hungerBuff = 5;
				repairBuff = 3;
				typeName = "Athlete";
				break;
				
			case "SCIENTIST":
				healthBuff = 6;
				tirednessBuff = 4;
				hungerBuff = 7;
				repairBuff = 6;
				typeName = "Scientist";
				break;
				
			case "PUSHOVER":
				healthBuff = 2;
				tirednessBuff = 2;
				hungerBuff = 2;
				repairBuff = 2;
				typeName = "Pushover";
				break;
				
			case "CYBORG":
				healthBuff = 7;
				tirednessBuff = 7;
				hungerBuff = 2;
				repairBuff = 7;
				typeName = "Cyborg";
				break;
				
			case "DOCTOR":
				healthBuff = 8;
				tirednessBuff = 8;
				hungerBuff = 4;
				repairBuff = 3;
				typeName = "Doctor";
				break;
		}
	}	
	//gives the base stat for max health
	public float getBaseHealth(){
		return healthBuff;
	}
	
	
	//gets the base stat for tiredness
	public float getBaseTiredness() {
		return tirednessBuff;
	}
	
	//gets the base stat for hunger
	public float getBaseHunger() {
		return hungerBuff;
	}
	
	//gets the base stat for repairing
	public int getBaseRepair() {
		return repairBuff;
	}
	
	//gets the name
	public String getTypeName() {
		return typeName;
	}
	
	
}
