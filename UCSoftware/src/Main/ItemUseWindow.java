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
	private static crew crewMembers;
	private static member activePerson = crew.Members.get(0);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemUseWindow window = new ItemUseWindow(environment, crewMembers);
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
		crewMembers = crew_info;
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
		
		JLabel lblChooseUser = new JLabel("Choose who should use it:");
		lblChooseUser.setBounds(218, 32, 160, 14);
		frame.getContentPane().add(lblChooseUser);
		
		JComboBox userSelect = new JComboBox();
		userSelect.setBounds(218, 75, 129, 20);
		frame.getContentPane().add(userSelect);
		for (member item : environment.Crew.getMembers()) {
			userSelect.addItem(item.getName());
		}
		
		JButton exitButton = new JButton("Leave");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launchActionWindow();
				frame.dispose();
			}
		});
		exitButton.setBounds(148, 341, 89, 23);
		frame.getContentPane().add(exitButton);
		
		JTextPane outputPane = new JTextPane();
		outputPane.setBounds(50, 179, 297, 61);
		frame.getContentPane().add(outputPane);
		
		JButton useItemButton = new JButton("Use");
		useItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activePerson = crew.Members.get(userSelect.getSelectedIndex());
				if (activePerson.getActions() > 0) {
					if (activePerson.getTiredness() > 0) {
						activePerson.consumeAction();
						activePerson.work();
						// USE THE CURRENT ITEM HERE
					}else {
						outputPane.setText(activePerson.getName() + " is too tired to do that!");

					}
				}else {
					outputPane.setText(activePerson.getName() + " is out of actions for the day!");
				}
				
			}
		});
		useItemButton.setBounds(148, 280, 89, 23);
		frame.getContentPane().add(useItemButton);
		

		
	}
}
