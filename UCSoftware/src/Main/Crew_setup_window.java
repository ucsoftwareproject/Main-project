package Main;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Crew_setup_window {

	private JFrame frame;
	private JTextField txtDaniel;
	private JTextField txtDavid;
	private JTextField txtTest;
	private JTextField txtTest_1;
	private JTextField textField_4;
	private static game_environment environment;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crew_setup_window window = new Crew_setup_window(environment);
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
	public Crew_setup_window(game_environment engine) {
		environment = engine;
		initialize();
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 458, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSelectYourCrew = new JLabel("Select your crew members:");
		lblSelectYourCrew.setBounds(10, 11, 161, 14);
		frame.getContentPane().add(lblSelectYourCrew);
		
		JLabel lblClass = new JLabel("Class:");
		lblClass.setBounds(10, 43, 46, 14);
		frame.getContentPane().add(lblClass);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 68, 91, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 99, 91, 20);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(10, 132, 91, 20);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(10, 163, 91, 20);
		frame.getContentPane().add(comboBox_3);
		
		
		//add to combo box
		for (Type2 s: environment.master_types) {
			comboBox.addItem(s.get_type_name());
			comboBox_1.addItem(s.get_type_name());
			comboBox_2.addItem(s.get_type_name());
			comboBox_3.addItem(s.get_type_name());
		}
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(113, 43, 46, 14);
		frame.getContentPane().add(lblName);
		
		txtDaniel = new JTextField();
		txtDaniel.setText("Daniel");
		txtDaniel.setBounds(111, 68, 86, 20);
		frame.getContentPane().add(txtDaniel);
		txtDaniel.setColumns(10);
		
		txtDavid = new JTextField();
		txtDavid.setText("David");
		txtDavid.setColumns(10);
		txtDavid.setBounds(111, 99, 86, 20);
		frame.getContentPane().add(txtDavid);
		
		txtTest = new JTextField();
		txtTest.setText("test");
		txtTest.setColumns(10);
		txtTest.setBounds(111, 132, 86, 20);
		frame.getContentPane().add(txtTest);
		
		txtTest_1 = new JTextField();
		txtTest_1.setText("test");
		txtTest_1.setColumns(10);
		txtTest_1.setBounds(111, 163, 86, 20);
		frame.getContentPane().add(txtTest_1);
		
		JLabel lblInformation = new JLabel("Information:");
		lblInformation.setBounds(207, 43, 100, 14);
		frame.getContentPane().add(lblInformation);
		
		//describes classes
		JTextPane txtpnEachClassIs = new JTextPane();
		txtpnEachClassIs.setText("Each class is has different strengths and weaknesses. "
				+ "Engineers are the best at repairing, and decent overall\r\n" + 
				"Athletes have high energy\r\n" + 
				"Scientists have good health and repairs but get tired easily\r\n" + 
				"Pushovers are a weak joke class cause I couldn't think of a sixth one\r\n" + 
				"Cyborgs have high stats overall but need lots of food to stay running\r\n" + 
				"Doctors have good energy and health but are bad at repairs ");
		txtpnEachClassIs.setBounds(207, 68, 225, 181);
		frame.getContentPane().add(txtpnEachClassIs);
		
		JLabel lblNameYourShip = new JLabel("Name your ship:");
		lblNameYourShip.setBounds(10, 221, 117, 14);
		frame.getContentPane().add(lblNameYourShip);
		
		//text field for naming ship
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 256, 161, 20);
		frame.getContentPane().add(textField_4);
		
		
		//button to lock in data
		JButton btnConfirmCrew = new JButton("Confirm ");
		btnConfirmCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				environment.add_member(txtDaniel.getText(), environment.master_types.get(comboBox.getSelectedIndex()));
				environment.add_member(txtDavid.getText(), environment.master_types.get(comboBox_1.getSelectedIndex()));
				
				//checks if a third person has been added (DOES NOT WORK YET)
				if (!("test".contentEquals(txtTest.getText()))) {
					environment.add_member(txtTest.getText(), environment.master_types.get(comboBox_2.getSelectedIndex()));
				}
				
				//checks if a fourth person has been added (DOES NOT WORK YET)
				if (!("test".contentEquals(txtTest_1.getText()))) {
					environment.add_member(txtTest_1.getText(), environment.master_types.get(comboBox_3.getSelectedIndex()));
				}
				environment.set_ship_name(textField_4.getText());
				environment.crew_debug();
				environment.launchconfirmationscreen();
				frame.dispose();
			}
		});
		btnConfirmCrew.setBounds(207, 260, 153, 23);
		frame.getContentPane().add(btnConfirmCrew);
	}
}
