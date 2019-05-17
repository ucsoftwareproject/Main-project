package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

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
		
		List<item> shop_items = environment.shop_items();
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Alien Outpost!");
		lblWelcomeToThe.setBounds(269, 22, 189, 14);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblPlayerMoney = new JLabel("Player money: " + environment.Crew.get_money() + ".");
		lblPlayerMoney.setBounds(27, 70, 174, 14);
		frame.getContentPane().add(lblPlayerMoney);
		
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
		
		DefaultListModel listModel;
		listModel = new DefaultListModel();
		for (item s: shop_items) {
			listModel.addElement(s.get_name());
		}
		
		JList Shop = new JList(listModel);
		Shop.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Shop.setBounds(29, 95, 172, 277);
		frame.getContentPane().add(Shop);
	}
}
