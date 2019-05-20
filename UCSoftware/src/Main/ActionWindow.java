package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class ActionWindow {

	private JFrame frame;
	private static GameEnvironment environment;
	private static crew crew_members;
	private static member active_person = crew.Members.get(0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActionWindow window = new ActionWindow(environment, crew_members);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ActionWindow(GameEnvironment engine, crew crew_info) {
		environment = engine;
		crew_members = crew_info;
		initialize();
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 763, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblActiveCrewMember = new JLabel("Active Crew Member:");
		lblActiveCrewMember.setBounds(20, 45, 154, 14);
		frame.getContentPane().add(lblActiveCrewMember);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(472, 21, 251, 169);
		frame.getContentPane().add(textPane);
		
		// button to display the current health and name of the ship
		JButton btnViewShipStatus = new JButton("View Ship Status");
		btnViewShipStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("Ship Name: " + environment.get_ship_name() + "\nShield HP: " + environment.get_shield_hp());
			}
		});
		btnViewShipStatus.setBounds(20, 91, 194, 65);
		frame.getContentPane().add(btnViewShipStatus);
		
		// label displaying the name of the active member and how many actions they have left
		JLabel lblCrewMemberHas = new JLabel(active_person.get_name() + " has " + active_person.get_actions() + " actions left, what should they do?");
		lblCrewMemberHas.setBounds(21, 187, 366, 14);
		frame.getContentPane().add(lblCrewMemberHas);
		
		// selects the current crew member
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(184, 42, 143, 20);
		frame.getContentPane().add(comboBox);
		for (member item : environment.Crew.get_members()) {
			comboBox.addItem(item.get_name());
		}
		
		// button that displays the statistics of the currently selected crew member
		JButton btnViewActiveCrew = new JButton("View active crew member status");
		btnViewActiveCrew.setBounds(241, 91, 194, 65);
		frame.getContentPane().add(btnViewActiveCrew);
		btnViewActiveCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				active_person = crew.Members.get(comboBox.getSelectedIndex());
				String item = "Name: " + active_person.get_name() + "\nType " + active_person.get_type_name() + 
				"\nHunger level: " + active_person.get_hunger() + "\nCurrent HP: " + active_person.get_health() 
				+ "\nEnergy: " + active_person.get_tiredness() + "\nCurrent Status: " + active_person.get_status();
				textPane.setText(item);
				frame.getContentPane().add(textPane);
			}
		});
		
		// frame to display information on either the ship or character
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(472, 224, 251, 141);
		frame.getContentPane().add(textPane_1);
		
		// button to let the crew member sleep, as long as they have enough remaining actions for the day
		JButton btnNewButton = new JButton("Sleep");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				active_person = crew.Members.get(comboBox.getSelectedIndex());
				if (active_person.get_actions() > 0) {
					active_person.consume_action();
					lblCrewMemberHas.setText(active_person.get_name() + " has " + active_person.get_actions() + " actions left, what should they do?");
					active_person.sleep();
					textPane_1.setText(active_person.get_name() + " took a nap and recovered 3 points of energy.");
				}else {
					textPane_1.setText(active_person.get_name() + " is out of actions for the day!.");
				}
				
			}
		});
		btnNewButton.setBounds(21, 224, 121, 65);
		frame.getContentPane().add(btnNewButton);
		
		// button to repair the shields by the current active members shield repair 
		// stat, as long as the member has enough energy and actions for the day remaining
		JButton btnRepairShields = new JButton("Repair Shields ");
		btnRepairShields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				active_person = crew.Members.get(comboBox.getSelectedIndex());
				int repair_v = active_person.get_base_repair();
				if (active_person.get_tiredness() > 0) {
					if (active_person.get_actions() > 0) {
						environment.add_shield_hp(repair_v);
						active_person.work();
						active_person.consume_action();
						lblCrewMemberHas.setText(active_person.get_name() + " has " + active_person.get_actions() + " actions left, what should they do?");
						textPane_1.setText(active_person.get_name() + " repaired the shields for " + active_person.get_base_repair() + " points.");
					} else {
						textPane_1.setText(active_person.get_name() + " is out of actions for the day!");

					}

				}else {
					textPane_1.setText(active_person.get_name() + " doesn't have enough energy to repair the shields!");
				}
				
			}
		});
		btnRepairShields.setBounds(152, 224, 121, 65);
		frame.getContentPane().add(btnRepairShields);
		
		// button to let the currently active member eat food, restoring hunger. (NO FUNCTION YET)
		JButton btnEatFood = new JButton("Use an item");
		btnEatFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				environment.launch_item_use_window();
			}
		});
		btnEatFood.setBounds(21, 300, 168, 65);
		frame.getContentPane().add(btnEatFood);
		
		// opens the planet changing menu
		JButton btnChangePlanet = new JButton("Change Planet");
		btnChangePlanet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launch_planet_changer();
				frame.dispose();
			}
		});
		btnChangePlanet.setBounds(236, 300, 168, 65);
		frame.getContentPane().add(btnChangePlanet);
		
		// button that lets the currently active crew member search the planet for parts, as long as they have enough energy and remaining moves for the day
		JButton btnSearchPlanet = new JButton("Search Planet");
		btnSearchPlanet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				active_person = crew.Members.get(comboBox.getSelectedIndex());
				if (active_person.get_tiredness() > 0) {
					if (active_person.get_actions() > 0) {
					textPane_1.setText(active_person.get_name() + " began a search!\n...\n...");
					active_person.work();
					active_person.consume_action();
					lblCrewMemberHas.setText(active_person.get_name() + " has " + active_person.get_actions() + " actions left, what should they do?");
					//GENERATE A VALUE TO DETERMINE IF PART FOUND (if true print that the person found it, if false, print nothing was found)
					}else {
						textPane_1.setText(active_person.get_name() + " is out of actions for the day!");
					}
				} else {
					textPane_1.setText(active_person.get_name() + " is too tired to search the planet!");
				}
			}
		});
		btnSearchPlanet.setBounds(283, 224, 121, 65);
		frame.getContentPane().add(btnSearchPlanet);

		
		// button that takes the player to the outpost
		JButton btnNewButton_1 = new JButton("Visit the outpost");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launch_outpost();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(21, 409, 206, 56);
		frame.getContentPane().add(btnNewButton_1);
		
		// ends the day, triggering a random event and restoring each crew members moves to 3
		JButton btnEndTheDay = new JButton("End the day");
		btnEndTheDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String day = environment.get_day();
				if (Integer.valueOf(day) > 1) {
					for (member s: crew_members.get_members()) {
						s.set_actions(3);
					}
					environment.launch_event();
					}else {
						environment.launch_failure();
					}
				frame.dispose();
			}
		});
		btnEndTheDay.setBounds(517, 409, 206, 56);
		frame.getContentPane().add(btnEndTheDay);
		
		// label displaying remaining days
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setText("There are " + environment.get_day() + " days remaining.");
		lblNewLabel.setBounds(20, 11, 233, 14);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
