package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Confirmation_screen {

	private JFrame frame;
	private static game_environment environment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirmation_screen window = new Confirmation_screen(environment);
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
	
	public Confirmation_screen(game_environment engine) {
			environment = engine;
			initialize();
			frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 292, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAreTheseDetails = new JLabel("Are these details correct?");
		lblAreTheseDetails.setBounds(71, 24, 195, 14);
		frame.getContentPane().add(lblAreTheseDetails);
		
		JLabel lblShipNamr = new JLabel("Ship Name:");
		lblShipNamr.setBounds(10, 66, 70, 14);
		frame.getContentPane().add(lblShipNamr);
		
		//ship name label
		JLabel ship_label = new JLabel("");
		ship_label .setBounds(115, 66, 46, 14);
		frame.getContentPane().add(ship_label );
		ship_label .setText(environment.get_ship_name());
		
		JLabel lblCrewMembers = new JLabel("Crew Members:");
		lblCrewMembers.setBounds(10, 106, 97, 14);
		frame.getContentPane().add(lblCrewMembers);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(115, 106, 46, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
