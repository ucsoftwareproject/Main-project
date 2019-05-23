package Main;

/**
 * @author      Daniel McInnes, David Turton
 * @version     1.0
 * @since       1.0
 */
public class member {

	/**
	 * name of crew member
	 */
	private String name;
	/**
	 * health of crew member
	 */
	private float health;
	/**
	 * hunger of crew member
	 */
	private float hunger;
	/**
	 * tiredness of crew member
	 */
	private float tiredness;
	/**
	 * is crew member sick
	 */
	public boolean sick;
	/**
	 * type of crew member
	 */
	private Type2 type;
	/**
	 * actions left
	 */
	private int actions = 3;

	/**
	 * Sets up the member and there base stats
	 * @param Name name on crew member
	 * @param Type crew member Type
	 */
	public member(String Name, Type2 Type) {
		name = Name;
		type = Type;
		health = type.getBaseHealth() * 10;
		tiredness = type.getBaseTiredness() * 10;
		hunger = type.getBaseHunger() * 10;
	}
	/**
	 * makes member sick
	 */
	public void plague() {
		sick = true;
	}

	/**
	 * gets member name
	 * @return member name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * gets member health
	 * @return returns member health
	 */
	public float getHealth(){
		return health;
	}
	
	/**
	 * get Status
	 * @return returns true if sick
	 */
	public boolean getStatus() {
		return sick;
	}
	
	/**
	 * get Tiredness
	 * @return returns Tiredness
	 */
	public float getTiredness() {
		return tiredness;
	}
	
	/**
	 * get members hunger
	 * @return hunger
	 */
	public float getHunger() {
		return hunger;
	}
	/**
	 * get member type
	 * @return returns player type
	 */
	public String getTypeName() {
		return type.getTypeName();
	}
	/**
	 * get Repair
	 * @return returns base repair
	 */
	public int getBaseRepair() {
		return type.getBaseRepair();
	}
	/**
	 * set member action
	 * @param value value of action
	 */
	public void setActions(int value) {
		actions = value;
	}
	/**
	 *  get members actions
	 *  @return actions left
	 */
	public float getActions(){
		return actions;
	}
	/**
	 * make member sleep
	 */
	public void sleep() {
		tiredness += 30;
	}
	/**
	 * make member work
	 */
	public void work() {
		tiredness -= 10;
	}
	/**
	 * use action
	 */
	public void consumeAction() {
		if (actions > 0) {
			actions -= 1;
		}
	}
	/**
	 * eat
	 * @param amount amount of food
	 */
	public void eat(float amount) {
		hunger += amount;
	}
	/**
	 *  make member lose hunger
	 */
	public void loseHunger() {
		hunger -= 10;
	}
	/**
	 * make member lose health
	 * @param value health to be lost
	 */
	public void loseHealth(int value) {
		health -= value;
	}
	/**
	 * make member use meds
	 * @param amount amount of med healing
	 */
	public void meds(float amount) {
		health += amount;
		sick = false;
	}
	/**
	 * use a item
	 * <p>
	 * if a med it heals and stop member form being sick. if food just fills hunger
	 * @param item Item to be used
	 */
	public void useItem(item item) {
		System.out.println("using item: " + item.getName());
		if (item.getType() == 0) {
			eat(item.getImprovement());
		}else if (item.getType() == 1) {
			meds(item.getImprovement());
		}else {
			eat(item.getImprovement());
			meds(item.getImprovement());
		}
			
	}
}
