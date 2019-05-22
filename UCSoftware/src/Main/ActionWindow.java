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
	private static crew crewMembers;
	private static member activePerson = crew.Members.get(0);
	private String personStatus;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActionWindow window = new ActionWindow(environment, crewMembers);
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
		crewMembers = crew_info;
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
		
		JTextPane outputPane1 = new JTextPane();
		outputPane1.setBounds(472, 21, 251, 169);
		frame.getContentPane().add(outputPane1);
		
		// button to display the current health and name of the ship
		JButton viewShipStatusButton = new JButton("View Ship Status");
		viewShipStatusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputPane1.setText("Ship Name: " + environment.getShipName() + "\nShield HP: " + environment.getShieldHP() + "\nParts: " 
			+ environment.partsCurrent() + "/" + environment.partsNeeded + "\nMoney: " + environment.Crew.getMoney());
			}
		});
		viewShipStatusButton.setBounds(20, 91, 194, 65);
		frame.getContentPane().add(viewShipStatusButton);
		
		// label displaying the name of the active member and how many actions they have left
		JLabel lblCrewMemberHas = new JLabel(activePerson.getName() + " has " + activePerson.getActions() + " actions left, what should they do?");
		lblCrewMemberHas.setBounds(21, 187, 366, 14);
		frame.getContentPane().add(lblCrewMemberHas);
		
		// selects the current crew member
		JComboBox memberSelect = new JComboBox();
		memberSelect.setBounds(184, 42, 143, 20);
		frame.getContentPane().add(memberSelect);
		for (member item : environment.Crew.getMembers()) {
			memberSelect.addItem(item.getName());
		}
		
		// button that displays the statistics of the currently selected crew member
		JButton viewActiveCrewButton = new JButton("View active crew member status");
		viewActiveCrewButton.setBounds(241, 91, 194, 65);
		frame.getContentPane().add(viewActiveCrewButton);
		viewActiveCrewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activePerson = crew.Members.get(memberSelect.getSelectedIndex());
				if (activePerson.getStatus()) {
					 personStatus = "Sick!";
				}else {
					personStatus = "Normal.";
				}
				String item = "Name: " + activePerson.getName() + "\nType " + activePerson.getTypeName() + 
				"\nHunger level: " + activePerson.getHunger() + "\nCurrent HP: " + activePerson.getHealth() 
				+ "\nEnergy: " + activePerson.getTiredness() + "\nCurrent Status: " + personStatus;
				outputPane1.setText(item);
				frame.getContentPane().add(outputPane1);
			}
		});
		
		// frame to display information on either the ship or character
		JTextPane outputPane2 = new JTextPane();
		outputPane2.setBounds(472, 224, 251, 141);
		frame.getContentPane().add(outputPane2);
		
		// button to let the crew member sleep, as long as they have enough remaining actions for the day
		JButton sleepButton = new JButton("Sleep");
		sleepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				activePerson = crew.Members.get(memberSelect.getSelectedIndex());
				if (activePerson.getActions() > 0) {
					String hungryStatus = "";
					if (activePerson.getHunger() == 0) {
						activePerson.consumeAction();
						activePerson.consumeAction();
						hungryStatus = activePerson.getName() + " is starving! They slept through the whole day so they can't do much else.";
					}
					activePerson.consumeAction();
					lblCrewMemberHas.setText(activePerson.getName() + " has " + activePerson.getActions() + " actions left, what should they do?\n");
					activePerson.sleep();
					outputPane2.setText(activePerson.getName() + " took a nap and recovered 30 points of energy." + hungryStatus);
				}else {
					outputPane2.setText(activePerson.getName() + " is out of actions for the day!.");
				}
				
			}
		});
		sleepButton.setBounds(21, 224, 121, 65);
		frame.getContentPane().add(sleepButton);
		
		// button to repair the shields by the current active members shield repair 
		// stat, as long as the member has enough energy and actions for the day remaining
		JButton repairShieldsButton = new JButton("Repair Shields ");
		repairShieldsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activePerson = crew.Members.get(memberSelect.getSelectedIndex());
				int repair_v = activePerson.getBaseRepair();
				if (activePerson.getTiredness() > 0) {
					if (activePerson.getActions() > 0) {
						String hungryStatus = "";
						if (activePerson.getHunger() == 0) {
							activePerson.consumeAction();
							activePerson.consumeAction();
							hungryStatus = activePerson.getName() + " is starving! Repairing the shields took them the whole day so they can't do much else.";
						}
						environment.addShieldHP(repair_v);
						activePerson.work();
						activePerson.consumeAction();
						lblCrewMemberHas.setText(activePerson.getName() + " has " + activePerson.getActions() + " actions left, what should they do?");
						outputPane2.setText(activePerson.getName() + " repaired the shields for " + activePerson.getBaseRepair() + " points.\n" + hungryStatus);
					} else {
						outputPane2.setText(activePerson.getName() + " is out of actions for the day!");

					}

				}else {
					outputPane2.setText(activePerson.getName() + " doesn't have enough energy to repair the shields!");
				}
				
			}
		});
		repairShieldsButton.setBounds(152, 224, 121, 65);
		frame.getContentPane().add(repairShieldsButton);
		
		// button to open the item use menu
		JButton useItemButton = new JButton("Use an item");
		useItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				environment.launchItemUseWindow();
			}
		});
		useItemButton.setBounds(21, 300, 168, 65);
		frame.getContentPane().add(useItemButton);
		
		// opens the planet changing menu
		JButton changePlanetButton = new JButton("Change Planet");
		changePlanetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launchPlanetChanger();
				frame.dispose();
			}
		});
		changePlanetButton.setBounds(236, 300, 168, 65);
		frame.getContentPane().add(changePlanetButton);
		
		// button that lets the currently active crew member search the planet for parts, as long as they have enough energy and remaining moves for the day
		JButton searchPlanetButton = new JButton("Search Planet");
		searchPlanetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activePerson = crew.Members.get(memberSelect.getSelectedIndex());
				
				if (environment.searched() == false) {
					if (activePerson.getTiredness() > 0) {
						if (activePerson.getActions() > 0) {
							String hungryStatus = "";
							if (activePerson.getHunger() == 0) {
								activePerson.consumeAction();
								activePerson.consumeAction();
								
								hungryStatus = activePerson.getName() + " is starving! Searching took them all day so they can't do much else.";
							}
						outputPane2.setText(hungryStatus + "\n" + activePerson.getName() + " began a search!\n...\n...");
						activePerson.work();
						activePerson.consumeAction();
						lblCrewMemberHas.setText(activePerson.getName() + " has " + activePerson.getActions() + " actions left, what should they do?");
	
						//search
						environment.planetSearched();
						
						//what did the player find
						int random = environment.randomNumber(4);
						switch (random) {
						case 0:
							//part
							System.out.println("found part");
							outputPane2.setText(outputPane2.getText() + "\n\nFound a Ship part!");
							environment.addPart();
							if (environment.currentParts >= environment.getPartsNeeded()){
								environment.launchWin();
								frame.dispose();
							}
							break;
						case 1:
							//item
							System.out.println("found item");
							outputPane2.setText(outputPane2.getText() + "\n\nFound an Item.");
							environment.crewAddItem(environment.get_random_item());
							break;
						case 2:
							//money
							System.out.println("found money");
							outputPane2.setText(outputPane2.getText() + "\n\nFound a pile of money.");
							environment.crewAddMoney(100);
							break;
						case 3:
							//nothing
							System.out.println("found nothing");
							outputPane2.setText(outputPane2.getText() + "\n\nFound nothing.");
							break;
						}
						
						
						
						}else {
							outputPane2.setText(activePerson.getName() + " is out of actions for the day!");
						}
					} else {
						outputPane2.setText(activePerson.getName() + " is too tired to search the planet!");
					}
				}else {
					outputPane2.setText("This planet has already been searched!");
				}
			}
		});
		searchPlanetButton.setBounds(283, 224, 121, 65);
		frame.getContentPane().add(searchPlanetButton);

		
		// button that takes the player to the outpost
		JButton visitOutpostButton = new JButton("Visit the outpost");
		visitOutpostButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launchOutpost();
				frame.dispose();
			}
		});
		visitOutpostButton.setBounds(21, 409, 206, 56);
		frame.getContentPane().add(visitOutpostButton);
		
		// ends the day, triggering a random event and restoring each crew members moves to 3
		JButton endTheDayButton = new JButton("End the day");
		endTheDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String day = environment.getDay();
				if (Integer.valueOf(day) > 1) {
					for (member s: crewMembers.getMembers()) {
						s.setActions(3);
						if (s.getHunger() > 0) {
							s.loseHunger();
						}
						if (s.getStatus()) {
							s.loseHealth(20);
						}
					}
					environment.launchEvent();
					}else {
						environment.launchFailure();
					}
				frame.dispose();
			}
		});
		endTheDayButton.setBounds(517, 409, 206, 56);
		frame.getContentPane().add(endTheDayButton);
		
		// label displaying remaining days
		JLabel daysLabel = new JLabel("New label");
		daysLabel.setText("There are " + environment.getDay() + " days remaining.");
		daysLabel.setBounds(20, 11, 233, 14);
		frame.getContentPane().add(daysLabel);
		
	}
}
