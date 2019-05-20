package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmationScreen {

	private JFrame frame;
	private static GameEnvironment environment;
	private static crew crewMembers;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmationScreen window = new ConfirmationScreen(environment, crewMembers);
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
	
	public ConfirmationScreen(GameEnvironment engine, crew crew_info) {
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
		frame.setBounds(100, 100, 364, 351);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// text label
		JLabel lblConfirmInfo = new JLabel("Confirm your information");
		lblConfirmInfo.setBounds(106, 25, 179, 14);
		frame.getContentPane().add(lblConfirmInfo);
		
		// ship name label
		JLabel lblShipName = new JLabel("Ship Name:");
		lblShipName.setBounds(10, 66, 70, 14);
		frame.getContentPane().add(lblShipName);
		
		// label displaying the name of the ship
		JLabel lblUserShipName = new JLabel("");
		lblUserShipName .setBounds(122, 66, 179, 14);
		frame.getContentPane().add(lblUserShipName );
		lblUserShipName .setText(environment.getShipName());
		
		// crew member label
		JLabel lblCrewMembers = new JLabel("Crew Members:");
		lblCrewMembers.setBounds(10, 136, 97, 14);
		frame.getContentPane().add(lblCrewMembers);
		
		// text pane displaying each member of the crew and their class.
		JTextPane gameInformationPane = new JTextPane();
		gameInformationPane.setBounds(122, 136, 179, 119);
		frame.getContentPane().add(gameInformationPane);
		String item = "";
		for (member s: crewMembers.getMembers()) {
			item += ("Name: " + s.getName() + " Type: " + s.getTypeName() + "\n");
		}
		gameInformationPane.setText(item);
		frame.getContentPane().add(gameInformationPane);
		
		//number of days label
		JLabel lblNumberOfDays = new JLabel("Number of days:");
		lblNumberOfDays.setBounds(10, 101, 97, 14);
		frame.getContentPane().add(lblNumberOfDays);
		
		// displays the number of days
		JLabel lblUserdays = new JLabel("");
		lblUserdays.setBounds(122, 101, 46, 14);
		frame.getContentPane().add(lblUserdays);
		lblUserdays.setText(environment.getDay());
		
		//confirms information and goes to the next screen
		JButton confirmationButton = new JButton("Confirm");
		confirmationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launchActionWindow();
				frame.dispose();
			}
		});
		confirmationButton.setBounds(130, 278, 89, 23);
		frame.getContentPane().add(confirmationButton);
		
	}
}
