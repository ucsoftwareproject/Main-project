/**
 * 
 */
package Main;

/**
 * @author daniel
 *
 */
public class game_environment {

	
	private int days = 0;
	crew Crew = new crew();
	
	
	// day functions
	public void set_days(int day) {
		days = day;
	}
	public void add_day () {
		days += 1;
	}
	public int get_day() {
		return days;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
