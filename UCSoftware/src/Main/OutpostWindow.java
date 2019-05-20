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

public class OutpostWindow {

	private JFrame frame;
	private static GameEnvironment environment;
	DefaultListModel<String> listModel = new DefaultListModel<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutpostWindow window = new OutpostWindow(environment);
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
	public OutpostWindow(GameEnvironment engine) {
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
		
		JLabel lblWelcome = new JLabel("Welcome to the Alien Outpost!");
		lblWelcome.setBounds(269, 22, 189, 14);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblPlayerMoney = new JLabel("Player money: " + environment.Crew.getMoney() + ".");
		lblPlayerMoney.setBounds(27, 70, 174, 14);
		frame.getContentPane().add(lblPlayerMoney);
		
		JTextPane itemInformationPane = new JTextPane();
		itemInformationPane.setBounds(211, 301, 304, 71);
		frame.getContentPane().add(itemInformationPane);
		
		
		
		
		JButton leaveButton = new JButton("Leave");
		leaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launchActionWindow();
				frame.dispose();
			}
		});
		leaveButton.setBounds(302, 394, 89, 52);
		frame.getContentPane().add(leaveButton);

		for (item s: shop_items) {
			listModel.addElement(s.getName());
		}
		
		JList<String> shopPane = new JList<>(listModel);
		shopPane.setSelectedIndex(0);
		shopPane.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
				//get item in for for display
				String name = shop_items.get(shopPane.getSelectedIndex()).getName() + "\n";
				String type_ = "";
				float imp = shop_items.get(shopPane.getSelectedIndex()).getImprovement();
				float cost = shop_items.get(shopPane.getSelectedIndex()).getCost();
				if (shop_items.get(shopPane.getSelectedIndex()).getType() == 0) {
					type_ = "Type: food\n"; 
				}else if (shop_items.get(shopPane.getSelectedIndex()).getType() == 1) {
					type_ = "Type: meds\n"; 
				}else {
					type_ = "Type: mix\n";
				}
				
				
				itemInformationPane.setText(name + type_ + "Improvement: " + imp + "\ncost: " + cost);
			}
		});
		
		JButton buyButton = new JButton("Buy Item");
		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//buy item
				if (environment.Crew.getMoney() >= shop_items.get(shopPane.getSelectedIndex()).getCost()) {
					environment.Crew.addItem(shop_items.get(shopPane.getSelectedIndex()));
					environment.Crew.subMoney(shop_items.get(shopPane.getSelectedIndex()).getCost());
					shop_items.remove(shopPane.getSelectedIndex());
					System.out.println("\nItems left");
					for (item s: shop_items) {
						System.out.println("\t* " + s.getName());
					}
					System.out.println("\n");
					environment.launchOutpost();
					environment.Crew.debug();
					frame.dispose();
				}
			}
		});
		
		buyButton.setBounds(528, 301, 119, 71);
		frame.getContentPane().add(buyButton);
		shopPane.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		shopPane.setBounds(29, 95, 172, 277);
		frame.getContentPane().add(shopPane);
	}
		
}
