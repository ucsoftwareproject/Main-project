package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

import Main.GameEnvironment;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiWelcomeScreen {

	private JFrame frmWelcome;
	private static GameEnvironment environment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiWelcomeScreen window = new GuiWelcomeScreen(environment);
					window.frmWelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiWelcomeScreen(GameEnvironment engine) {
		environment = engine;
		initialize();
		frmWelcome.setVisible(true);
	}
	
	public void closeWindow() {
		frmWelcome.dispose();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("Welcome!");
		frmWelcome.setBounds(100, 100, 455, 350);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToSpace = new JLabel("Welcome to Space Explorer!");
		lblWelcomeToSpace.setBounds(135, 37, 202, 14);
		frmWelcome.getContentPane().add(lblWelcomeToSpace);
		
		JLabel lblSelectTheNumber = new JLabel("Select the number of in-game days you would like:");
		lblSelectTheNumber.setBounds(25, 83, 402, 23);
		frmWelcome.getContentPane().add(lblSelectTheNumber);
		
		//moves to the next page
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				environment.launchCrewWindow();
				environment.dayDebug();
				frmWelcome.dispose();
			}
		});
		confirmButton.setBounds(149, 231, 89, 23);
		frmWelcome.getContentPane().add(confirmButton);
		
		//label displaying current number of days
		JLabel amountOfDaysLabel = new JLabel("");
		amountOfDaysLabel.setBounds(198, 179, 16, 14);
		frmWelcome.getContentPane().add(amountOfDaysLabel);
		amountOfDaysLabel.setText(environment.getDay());

		
		//takes away a day from the day count
		JButton removeDayButton = new JButton("-");
		removeDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.minusDay();
				amountOfDaysLabel.setText(environment.getDay());
			}
		});
		removeDayButton.setBounds(57, 154, 58, 39);
		frmWelcome.getContentPane().add(removeDayButton);
		
		//adds one day to the day count
		JButton addDayButton = new JButton("+");
		addDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.addDay();
				amountOfDaysLabel.setText(environment.getDay());
			}
		});
		addDayButton.setBounds(297, 154, 58, 39);
		frmWelcome.getContentPane().add(addDayButton);
		
		// text label
		JLabel lblDays = new JLabel("Current days:");
		lblDays.setBounds(157, 126, 128, 14);
		frmWelcome.getContentPane().add(lblDays);



	}
}
