package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EventWindow {

	private JFrame frame;
	private static GameEnvironment environment;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventWindow window = new EventWindow(environment);
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
	public EventWindow(GameEnvironment engine) {
		environment = engine;
		initialize();
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int temp = environment.randomNumber(4);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEvent = new JLabel("Event");
		lblEvent.setBounds(193, 40, 46, 14);
		frame.getContentPane().add(lblEvent);
		
		// text pane displaying the event and what happened
		JTextPane eventDescriptionPane = new JTextPane();
		eventDescriptionPane.setBounds(72, 87, 298, 269);
		frame.getContentPane().add(eventDescriptionPane);
		
		switch(temp) {
		case 0:
			//Alien pirates
			System.out.println("Alien pirates");
			environment.Crew.alien();
			environment.Crew.debug();
			eventDescriptionPane.setText("Alien pirates attack!!\nA random item was stolen!");
			break;
		case 1:
			//Space plague.
			System.out.println("Space plague");
			environment.Crew.plage();
			eventDescriptionPane.setText("A mysterious space plague has entered the ship.\nSomeone got sick!");
			break;
		case 2:
			//Asteroid belt.
			System.out.println("Asteroid belt");
			int damage_v = environment.getShieldHP() / 3;
			if (damage_v < 3) {
				damage_v = 3;
			}
			environment.damageShield(damage_v);
			if (environment.getShieldHP() <= 0) {
				environment.launchFailure();
				frame.dispose();
			}
			eventDescriptionPane.setText("The ship passed through an asteroid belt.\nThe shields took damage!");
			break;
		case 3:
			//nothing
			System.out.println("Safe Trip");
			eventDescriptionPane.setText("The crew had a safe trip.");
			break;
		}
		
		// returns the player to the action window
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.endDay();
				environment.launchActionWindow();
				frame.dispose();
			}
		});
		continueButton.setBounds(173, 377, 89, 23);
		frame.getContentPane().add(continueButton);
	}

}
