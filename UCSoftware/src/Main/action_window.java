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

public class action_window {

	private JFrame frame;
	private static game_environment environment;
	private static crew crew_members;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					action_window window = new action_window(environment, crew_members);
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
	public action_window(game_environment engine, crew crew_info) {
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
		lblActiveCrewMember.setBounds(20, 45, 114, 14);
		frame.getContentPane().add(lblActiveCrewMember);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(472, 21, 251, 169);
		frame.getContentPane().add(textPane);
		
		JButton btnViewShipStatus = new JButton("View Ship Status");
		btnViewShipStatus.setBounds(20, 91, 194, 65);
		frame.getContentPane().add(btnViewShipStatus);
		
		JButton btnViewActiveCrew = new JButton("View active crew member status");
		btnViewActiveCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewActiveCrew.setBounds(241, 91, 194, 65);
		frame.getContentPane().add(btnViewActiveCrew);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(143, 42, 143, 20);
		frame.getContentPane().add(comboBox);
		for (member item : environment.Crew.get_members()) {
			comboBox.addItem(item.get_name());
		}
		
		
		
		JButton btnNewButton = new JButton("Sleep");
		btnNewButton.setBounds(21, 224, 121, 65);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRepairShields = new JButton("Repair Shields ");
		btnRepairShields.setBounds(167, 224, 121, 65);
		frame.getContentPane().add(btnRepairShields);
		
		JButton btnEatFood = new JButton("Eat Food");
		btnEatFood.setBounds(21, 309, 121, 65);
		frame.getContentPane().add(btnEatFood);
		
		JButton btnChangePlanet = new JButton("Change Planet");
		btnChangePlanet.setBounds(314, 224, 121, 65);
		frame.getContentPane().add(btnChangePlanet);
		
		JButton btnSearchPlanet = new JButton("Search Planet");
		btnSearchPlanet.setBounds(167, 309, 121, 65);
		frame.getContentPane().add(btnSearchPlanet);
		
		JButton btnUseMedication = new JButton("Use Medication");
		btnUseMedication.setBounds(314, 309, 121, 65);
		frame.getContentPane().add(btnUseMedication);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(472, 224, 251, 141);
		frame.getContentPane().add(textPane_1);
		
		JLabel lblCrewMemberHas = new JLabel("Crew member has x actions left, what should they do?");
		lblCrewMemberHas.setBounds(21, 187, 366, 14);
		frame.getContentPane().add(lblCrewMemberHas);
		
		JButton btnNewButton_1 = new JButton("Visit the outpost");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launch_outpost();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(21, 409, 206, 56);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnEndTheDay = new JButton("End the day");
		btnEndTheDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launch_event();
				frame.dispose();
			}
		});
		btnEndTheDay.setBounds(517, 409, 206, 56);
		frame.getContentPane().add(btnEndTheDay);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setText("There are " + environment.get_day() + " days remaining.");
		lblNewLabel.setBounds(20, 11, 233, 14);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
