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
	private static crew crew_members;
	private static member active_person1;
	private static member active_person2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					planet_change_window window = new planet_change_window(environment, crew_members);
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
	public planet_change_window(game_environment engine, crew crew_info) {
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
		for (member item : environment.Crew.get_members()) {
			comboBox.addItem(item.get_name());
		}
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(229, 67, 76, 20);
		frame.getContentPane().add(comboBox_1);
		for (member item : environment.Crew.get_members()) {
			comboBox_1.addItem(item.get_name());
		}
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(59, 150, 308, 131);
		frame.getContentPane().add(textPane);
		
		JButton btnLaunch = new JButton("Launch!");
		btnLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				active_person1 = crew.Members.get(comboBox.getSelectedIndex());
				active_person2 = crew.Members.get(comboBox_1.getSelectedIndex());
				if (active_person1 != active_person2) {
					if (active_person1.get_tiredness() > 1 && active_person2.get_tiredness() > 1 ) {
						textPane.setText("good");
						active_person1.work();
						active_person2.work();
						// change planet here
					}else {
						textPane.setText("One of these members is too tired to pilot the ship!");
					}
				}else {
					textPane.setText("You need two seperate people to pilot the ship!");
				}

			}
			
		});
		btnLaunch.setBounds(156, 108, 89, 31);
		frame.getContentPane().add(btnLaunch);
	}
}
