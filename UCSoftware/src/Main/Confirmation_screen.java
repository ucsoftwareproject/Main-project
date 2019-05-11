package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class Confirmation_screen {

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
					Confirmation_screen window = new Confirmation_screen(environment, crew_members);
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
	
	public Confirmation_screen(game_environment engine, crew crew_info) {
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
		frame.setBounds(100, 100, 364, 351);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAreTheseDetails = new JLabel("Confirm your information");
		lblAreTheseDetails.setBounds(106, 25, 179, 14);
		frame.getContentPane().add(lblAreTheseDetails);
		
		JLabel lblShipNamr = new JLabel("Ship Name:");
		lblShipNamr.setBounds(10, 66, 70, 14);
		frame.getContentPane().add(lblShipNamr);
		
		//ship name label
		JLabel ship_label = new JLabel("");
		ship_label .setBounds(122, 66, 179, 14);
		frame.getContentPane().add(ship_label );
		ship_label .setText(environment.get_ship_name());
		
		JLabel lblCrewMembers = new JLabel("Crew Members:");
		lblCrewMembers.setBounds(10, 136, 97, 14);
		frame.getContentPane().add(lblCrewMembers);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(122, 136, 179, 119);
		frame.getContentPane().add(textPane);
		String item = "";
		for (member s: crew_members.get_members()) {
			item += ("Name: " + s.get_name() + " Type: " + s.get_type_name() + "\n");
		}
		textPane.setText(item);
		frame.getContentPane().add(textPane);
		
		JLabel lblNumberOfDays = new JLabel("Number of days:");
		lblNumberOfDays.setBounds(10, 101, 97, 14);
		frame.getContentPane().add(lblNumberOfDays);
		
		JLabel label = new JLabel("");
		label.setBounds(122, 101, 46, 14);
		frame.getContentPane().add(label);
		label.setText(environment.get_day());
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(130, 278, 89, 23);
		frame.getContentPane().add(btnConfirm);
	}
}