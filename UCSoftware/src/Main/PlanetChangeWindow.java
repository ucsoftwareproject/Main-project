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
	private static crew crew_members;
	private static member active_person1;
	private static member active_person2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanetChangeWindow window = new PlanetChangeWindow(environment, crew_members);
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
	public PlanetChangeWindow(GameEnvironment engine, crew crew_info) {
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
		frame.setBounds(100, 100, 450, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// button to return to the action screen
		JButton btnLeave = new JButton("Leave");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launch_action_window();
				frame.dispose();
			}
		});
		btnLeave.setBounds(149, 308, 107, 49);
		frame.getContentPane().add(btnLeave);
		
		// text label
		JLabel lblSelectWhoShould = new JLabel("Select two crew members to pilot the ship");
		lblSelectWhoShould.setBounds(129, 11, 272, 14);
		frame.getContentPane().add(lblSelectWhoShould);
		
		// combo box to select the first member to pilot
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(106, 67, 76, 20);
		frame.getContentPane().add(comboBox);
		for (member item : environment.Crew.get_members()) {
			comboBox.addItem(item.get_name());
		}
		
		// combo box to select the second member to pilot
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(229, 67, 76, 20);
		frame.getContentPane().add(comboBox_1);
		for (member item : environment.Crew.get_members()) {
			comboBox_1.addItem(item.get_name());
		}
		
		// text pane displaying the outcome of the movement
		JTextPane textPane = new JTextPane();
		textPane.setBounds(59, 150, 308, 131);
		frame.getContentPane().add(textPane);
		
		// button to attempt to launch the ship, launches ship as long as both members have energy and actions remaining
		JButton btnLaunch = new JButton("Launch!");
		btnLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				active_person1 = crew.Members.get(comboBox.getSelectedIndex());
				active_person2 = crew.Members.get(comboBox_1.getSelectedIndex());
				if (active_person1 != active_person2) {
					if (active_person1.get_tiredness() > 0 && active_person2.get_tiredness() > 0 ) {
						if (active_person1.get_actions() > 0 && active_person2.get_actions() > 0) {
							textPane.setText("good");
							active_person1.work();
							active_person2.work();
							active_person1.consume_action();
							active_person2.consume_action();
							// change planet here
						}else {
							textPane.setText("One of these members is out of actions for the day!");
						}
						
					}else {
						textPane.setText("One of these members is too tired to pilot the ship!");
					}
				}else {
					textPane.setText("You need two seperate people to pilot the ship!");
				}

			}
			
		});
		btnLaunch.setBounds(156, 108, 89, 31);
		frame.getContentPane().add(btnLaunch);
	}
}
