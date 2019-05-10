package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

import Main.game_environment;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Welcome_Screen {

	private JFrame frmWelcome;
	private static game_environment environment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Welcome_Screen window = new GUI_Welcome_Screen(environment);
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
	public GUI_Welcome_Screen(game_environment engine) {
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
		lblWelcomeToSpace.setBounds(144, 37, 202, 14);
		frmWelcome.getContentPane().add(lblWelcomeToSpace);
		
		JLabel lblSelectTheNumber = new JLabel("Select the number of in-game days you would like:");
		lblSelectTheNumber.setBounds(97, 88, 313, 14);
		frmWelcome.getContentPane().add(lblSelectTheNumber);
		
		//moves to the next page
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnConfirm.setBounds(166, 232, 89, 23);
		frmWelcome.getContentPane().add(btnConfirm);
		
		//label displaying current number of days
		JLabel label = new JLabel("");
		label.setBounds(212, 179, 16, 14);
		frmWelcome.getContentPane().add(label);
		label.setText(environment.get_day());

		
		//takes away a day from the day count
		JButton button = new JButton("-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.minus_day();
				label.setText(environment.get_day());
			}
		});
		button.setBounds(97, 154, 58, 39);
		frmWelcome.getContentPane().add(button);
		
		//adds one day to the day count
		JButton button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.add_day();
				label.setText(environment.get_day());
			}
		});
		button_1.setBounds(288, 154, 58, 39);
		frmWelcome.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("Current days:");
		lblNewLabel.setBounds(188, 154, 128, 14);
		frmWelcome.getContentPane().add(lblNewLabel);



	}
}
