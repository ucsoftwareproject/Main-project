package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Event_window {

	private JFrame frame;
	private static game_environment environment;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Event_window window = new Event_window(environment);
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
	public Event_window(game_environment engine) {
		environment = engine;
		initialize();
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEvent = new JLabel("Event");
		lblEvent.setBounds(193, 40, 46, 14);
		frame.getContentPane().add(lblEvent);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(72, 87, 298, 269);
		frame.getContentPane().add(textPane);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.end_day();
				environment.launch_action_window();
				frame.dispose();
			}
		});
		btnContinue.setBounds(173, 377, 89, 23);
		frame.getContentPane().add(btnContinue);
	}

}
