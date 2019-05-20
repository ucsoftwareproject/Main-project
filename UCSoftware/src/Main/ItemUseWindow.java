package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class ItemUseWindow {

	private JFrame frame;
	private static GameEnvironment environment;
	private static crew crew_members;
	private static member active_person = crew.Members.get(0);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemUseWindow window = new ItemUseWindow(environment, crew_members);
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
	public ItemUseWindow(GameEnvironment engine, crew crew_info) {
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
		frame.setBounds(100, 100, 450, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChooseAnItem = new JLabel("Choose an item:");
		lblChooseAnItem.setBounds(50, 32, 107, 14);
		frame.getContentPane().add(lblChooseAnItem);
		
		JLabel lblChooseWhoShould = new JLabel("Choose who should use it:");
		lblChooseWhoShould.setBounds(218, 32, 160, 14);
		frame.getContentPane().add(lblChooseWhoShould);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(218, 75, 129, 20);
		frame.getContentPane().add(comboBox);
		for (member item : environment.Crew.get_members()) {
			comboBox.addItem(item.get_name());
		}
		
		JButton btnNewButton = new JButton("Leave");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launch_action_window();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(148, 341, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(50, 179, 297, 61);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton_1 = new JButton("Use");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				active_person = crew.Members.get(comboBox.getSelectedIndex());
				if (active_person.get_actions() > 0) {
					if (active_person.get_tiredness() > 0) {
						active_person.consume_action();
						active_person.work();
						// USE THE CURRENT ITEM HERE
					}else {
						textPane.setText(active_person.get_name() + " is too tired to do that!");

					}
				}else {
					textPane.setText(active_person.get_name() + " is out of actions for the day!");
				}
				
			}
		});
		btnNewButton_1.setBounds(148, 280, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		

		
	}
}
