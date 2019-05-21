package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ItemUseWindow {

	private JFrame frame;
	private static GameEnvironment environment;
	private static crew crewMembers;
	private static member activePerson = crew.Members.get(0);
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	
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
		
		List<item> Crew_items = environment.Crew.getAllItems();
		
		for (item s: Crew_items) {
			listModel.addElement(s.getName());
		}
		
		
		JList<String> list_items = new JList<>(listModel);
		
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
				//environment.launchActionWindow();
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
						activePerson.useItem(Crew_items.get(list_items.getSelectedIndex()));
						crewMembers.removeItem(list_items.getSelectedIndex());
						environment.launchItemUseWindow();;
						environment.Crew.debug();
						frame.dispose();
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
		
		
		
		list_items.setSelectedIndex(0);
		
		list_items.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String name = Crew_items.get(list_items.getSelectedIndex()).getName() + "\n";
				String type_ = "";
				float imp = Crew_items.get(list_items.getSelectedIndex()).getImprovement();
				if (Crew_items.get(list_items.getSelectedIndex()).getType() == 0) {
					type_ = "Type: food\n"; 
				}else if (Crew_items.get(list_items.getSelectedIndex()).getType() == 1) {
					type_ = "Type: meds\n"; 
				}else {
					type_ = "Type: mix\n";
				}
				
				
				outputPane.setText(name + "Type: " +type_ + "Improvement: " + imp);
				
			}
		});
		list_items.setBounds(50, 75, 160, 100);
		frame.getContentPane().add(list_items);
		

		
	}
}
