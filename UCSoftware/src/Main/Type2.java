package Main;
/**
 * @author      Daniel McInnes dmc245@uclive.ac.nz , David
 * @version     1.0
 * @since       1.0
 */
public class Type2 {
	/**
	 * Health buff
	 */
	float healthBuff;
	/**
	 * tiredness Buff
	 */
	float tirednessBuff;
	/**
	 * hunger Buff
	 */
	float hungerBuff;
	/**
	 * is repair Buff
	 */
	int repairBuff;
	/**
	 * type name
	 */
	public String typeName;
	
	/**
	 * used for setting type
	 * @param type type being set
	 */
	public Type2(String type) {
		setStats(type);
	}
	
	/**
	 * set the type and buffs
	 * @param state type to be set
	 */
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
	/**
	 * get base health 
	 * @return returns the buff
	 */
	public float getBaseHealth(){
		return healthBuff;
	}
	
	
	/**
	 *get base tiredness
	 *@return returns the buff
	 */
	public float getBaseTiredness() {
		return tirednessBuff;
	}
	
	/**
	 * get base hunger
	 * @return returns the buff
	 */
	public float getBaseHunger() {
		return hungerBuff;
	}
	
	/**
	 * get base repair
	 * @return returns the buff
	 */
	public int getBaseRepair() {
		return repairBuff;
	}
	
	/**
	 * get name 
	 * @return name of type
	 */
	public String getTypeName() {
		return typeName;
	}
	
	
}
