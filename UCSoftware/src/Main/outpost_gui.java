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
import javax.swing.SwingUtilities;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class outpost_gui {

	private JFrame frame;
	private static game_environment environment;
	DefaultListModel<String> listModel = new DefaultListModel<String>();

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
		
		JTextPane item_info = new JTextPane();
		item_info.setBounds(211, 301, 304, 71);
		frame.getContentPane().add(item_info);
		
		
		
		
		JButton btnLeave = new JButton("Leave");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launch_action_window();
				frame.dispose();
			}
		});
		btnLeave.setBounds(302, 394, 89, 52);
		frame.getContentPane().add(btnLeave);

		for (item s: shop_items) {
			listModel.addElement(s.get_name());
		}
		
		JList<String> Shop = new JList<>(listModel);
		Shop.setSelectedIndex(0);
		Shop.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
				//get item in for for display
				String name = shop_items.get(Shop.getSelectedIndex()).get_name() + "\n";
				String type_ = "";
				float imp = shop_items.get(Shop.getSelectedIndex()).get_improvement();
				float cost = shop_items.get(Shop.getSelectedIndex()).get_cost();
				if (shop_items.get(Shop.getSelectedIndex()).get_type() == 0) {
					type_ = "Type: food\n"; 
				}else if (shop_items.get(Shop.getSelectedIndex()).get_type() == 1) {
					type_ = "Type: meds\n"; 
				}else {
					type_ = "Type: mix\n";
				}
				
				
				item_info.setText(name + type_ + "Improvement: " + imp + "\ncost: " + cost);
			}
		});
		
		JButton btnNewButton = new JButton("Buy Item");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//buy item
				if (environment.Crew.get_money() >= shop_items.get(Shop.getSelectedIndex()).get_cost()) {
					environment.Crew.add_item(shop_items.get(Shop.getSelectedIndex()));
					environment.Crew.sub_money(shop_items.get(Shop.getSelectedIndex()).get_cost());
					shop_items.remove(Shop.getSelectedIndex());
					System.out.println("\nItems left");
					for (item s: shop_items) {
						System.out.println("\t* " + s.get_name());
					}
					System.out.println("\n");
					environment.launch_outpost();
					environment.Crew.debug();
					frame.dispose();
				}
			}
		});
		
		btnNewButton.setBounds(528, 301, 119, 71);
		frame.getContentPane().add(btnNewButton);
		Shop.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Shop.setBounds(29, 95, 172, 277);
		frame.getContentPane().add(Shop);
	}
		
}
