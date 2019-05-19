package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class planet_change_window {

	private JFrame frame;
	private static game_environment environment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					planet_change_window window = new planet_change_window(environment);
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
	public planet_change_window(game_environment engine) {
		environment = engine;
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
		
		JButton btnLeave = new JButton("Leave");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launch_action_window();
				frame.dispose();
			}
		});
		btnLeave.setBounds(149, 308, 107, 49);
		frame.getContentPane().add(btnLeave);
		
		JLabel lblSelectWhoShould = new JLabel("Select two crew members to pilot the ship");
		lblSelectWhoShould.setBounds(129, 11, 272, 14);
		frame.getContentPane().add(lblSelectWhoShould);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(106, 67, 76, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(229, 67, 76, 20);
		frame.getContentPane().add(comboBox_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(59, 150, 308, 131);
		frame.getContentPane().add(textPane);
		
		JButton btnLaunch = new JButton("Launch!");
		btnLaunch.setBounds(156, 108, 89, 31);
		frame.getContentPane().add(btnLaunch);
	}
}
