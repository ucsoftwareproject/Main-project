package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class outpost_gui {

	private JFrame frame;
	private static game_environment environment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					outpost_gui window = new outpost_gui(environment);
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
	public outpost_gui(game_environment engine) {
		environment = engine;
		initialize();
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Alien Outpost!");
		lblWelcomeToThe.setBounds(269, 22, 189, 14);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblPlayerMoney = new JLabel("Player money:");
		lblPlayerMoney.setBounds(27, 70, 102, 14);
		frame.getContentPane().add(lblPlayerMoney);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(27, 136, 174, 236);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(211, 301, 304, 71);
		frame.getContentPane().add(textPane_1);
		
		JButton btnNewButton = new JButton("Buy Item");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(528, 301, 119, 71);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLeave = new JButton("Leave");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launch_action_window();
				frame.dispose();
			}
		});
		btnLeave.setBounds(302, 394, 89, 52);
		frame.getContentPane().add(btnLeave);
	}
}
