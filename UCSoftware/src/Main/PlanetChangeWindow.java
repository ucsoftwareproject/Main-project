package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlanetChangeWindow {

	private JFrame frame;
	private static GameEnvironment environment;
	private static crew crewMembers;
	private static member activePerson1;
	private static member activePerson2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanetChangeWindow window = new PlanetChangeWindow(environment, crewMembers);
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
	public PlanetChangeWindow(GameEnvironment engine, crew crewInfo) {
		environment = engine;
		crewMembers = crewInfo;
		initialize();
		frame.setVisible(true);		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// button to return to the action screen
		JButton leaveButton = new JButton("Leave");
		leaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launchActionWindow();
				frame.dispose();
			}
		});
		leaveButton.setBounds(149, 308, 107, 49);
		frame.getContentPane().add(leaveButton);
		
		// text label
		JLabel lblSelectWhoShould = new JLabel("Select two crew members to pilot the ship");
		lblSelectWhoShould.setBounds(129, 11, 272, 14);
		frame.getContentPane().add(lblSelectWhoShould);
		
		// combo box to select the first member to pilot
		JComboBox userOneSelect = new JComboBox();
		userOneSelect.setBounds(106, 67, 76, 20);
		frame.getContentPane().add(userOneSelect);
		for (member item : environment.Crew.getMembers()) {
			userOneSelect.addItem(item.getName());
		}
		
		// combo box to select the second member to pilot
		JComboBox userTwoSelect = new JComboBox();
		userTwoSelect.setBounds(229, 67, 76, 20);
		frame.getContentPane().add(userTwoSelect);
		for (member item : environment.Crew.getMembers()) {
			userTwoSelect.addItem(item.getName());
		}
		
		// text pane displaying the outcome of the movement
		JTextPane outputPane = new JTextPane();
		outputPane.setBounds(59, 150, 308, 131);
		frame.getContentPane().add(outputPane);
		
		// button to attempt to launch the ship, launches ship as long as both members have energy and actions remaining
		JButton launchButton = new JButton("Launch!");
		launchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activePerson1 = crew.Members.get(userOneSelect.getSelectedIndex());
				activePerson2 = crew.Members.get(userTwoSelect.getSelectedIndex());
				if (activePerson1 != activePerson2) {
					if (activePerson1.getTiredness() > 0 && activePerson2.getTiredness() > 0 ) {
						if (activePerson1.getActions() > 0 && activePerson2.getActions() > 0) {
							String hungryStatus = "";
							if (activePerson1.getHunger() == 0) {
								activePerson1.consumeAction();
								activePerson1.consumeAction();
								hungryStatus += activePerson1.getName() + " is starving!\n";
							}
							if (activePerson2.getHunger() == 0) {
								activePerson2.consumeAction();
								activePerson2.consumeAction();
								hungryStatus += activePerson2.getName() + " is starving!\n";
							}
							outputPane.setText("good");
							activePerson1.work();
							activePerson2.work();
							activePerson1.consumeAction();
							activePerson2.consumeAction();
							// change planet here
							outputPane.setText(hungryStatus + " Launch successful!");
							
							System.out.println("changing planet");
							environment.spawnItems(6);
							environment.newPlanet();
							
							
						}else {
							outputPane.setText("One of these members is out of actions for the day!");
						}
						
					}else {
						outputPane.setText("One of these members is too tired to pilot the ship!");
					}
				}else {
					outputPane.setText("You need two seperate people to pilot the ship!");
				}

			}
			
		});
		launchButton.setBounds(156, 108, 89, 31);
		frame.getContentPane().add(launchButton);
	}
}
