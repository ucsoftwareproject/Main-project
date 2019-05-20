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

public class CrewSetupWindow {

	private JFrame frame;
	private JTextField nameEntryOne;
	private JTextField nameEntryTwo;
	private JTextField nameEntryThree;
	private JTextField nameEntryFour;
	private JTextField shipNameEntryField;
	private static GameEnvironment environment;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewSetupWindow window = new CrewSetupWindow(environment);
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
	public CrewSetupWindow(GameEnvironment engine) {
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
		
		// member 1 class selection box
		JComboBox memberOneSelection = new JComboBox();
		memberOneSelection.setBounds(10, 68, 91, 20);
		frame.getContentPane().add(memberOneSelection);
		
		// member 2 class selection 
		JComboBox memberTwoSelection = new JComboBox();
		memberTwoSelection.setBounds(10, 99, 91, 20);
		frame.getContentPane().add(memberTwoSelection);
		
		// member 3 class selection 
		JComboBox memberThreeSelection = new JComboBox();
		memberThreeSelection.setBounds(10, 132, 91, 20);
		frame.getContentPane().add(memberThreeSelection);
		
		// member 4 class selection 
		JComboBox memberFourSelection = new JComboBox();
		memberFourSelection.setBounds(10, 163, 91, 20);
		frame.getContentPane().add(memberFourSelection);
		
		
		//add to combo box
		for (Type2 s: environment.masterTypes) {
			memberOneSelection.addItem(s.getTypeName());
			memberTwoSelection.addItem(s.getTypeName());
			memberThreeSelection.addItem(s.getTypeName());
			memberFourSelection.addItem(s.getTypeName());
		}
		
		// text label
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(113, 43, 46, 14);
		frame.getContentPane().add(lblName);
		
		// member 1 name entry
		nameEntryOne = new JTextField();
		nameEntryOne.setText("Daniel");
		nameEntryOne.setBounds(111, 68, 86, 20);
		frame.getContentPane().add(nameEntryOne);
		nameEntryOne.setColumns(10);
		
		// member 2 name entry
		nameEntryTwo = new JTextField();
		nameEntryTwo.setText("David");
		nameEntryTwo.setColumns(10);
		nameEntryTwo.setBounds(111, 99, 86, 20);
		frame.getContentPane().add(nameEntryTwo);
		
		// member 3 name entry, if name isn't changed then member isn't added
		nameEntryThree = new JTextField();
		nameEntryThree.setText("Enter a name!");
		nameEntryThree.setColumns(10);
		nameEntryThree.setBounds(111, 132, 86, 20);
		frame.getContentPane().add(nameEntryThree);
		
		// member 4 name entry, if name isn't changed then member isn't added
		nameEntryFour = new JTextField();
		nameEntryFour.setText("Enter a name!");
		nameEntryFour.setColumns(10);
		nameEntryFour.setBounds(111, 163, 86, 20);
		frame.getContentPane().add(nameEntryFour);
		
		// text label
		JLabel lblInformation = new JLabel("Information:");
		lblInformation.setBounds(207, 43, 100, 14);
		frame.getContentPane().add(lblInformation);
		
		//describes classes
		JTextPane classDescriptionPane = new JTextPane();
		classDescriptionPane.setText("Each class is has different strengths and weaknesses. "
				+ "Engineers are the best at repairing, and decent overall\r\n" + 
				"Athletes have high energy\r\n" + 
				"Scientists have good health and repairs but get tired easily\r\n" + 
				"Pushovers are a weak joke class cause I couldn't think of a sixth one\r\n" + 
				"Cyborgs have high stats overall but need lots of food to stay running\r\n" + 
				"Doctors have good energy and health but are bad at repairs ");
		classDescriptionPane.setBounds(207, 68, 225, 181);
		frame.getContentPane().add(classDescriptionPane);
		
		// text label
		JLabel lblNameYourShip = new JLabel("Name your ship:");
		lblNameYourShip.setBounds(10, 221, 117, 14);
		frame.getContentPane().add(lblNameYourShip);
		
		//text field for naming ship
		shipNameEntryField = new JTextField();
		shipNameEntryField.setText("Starman's Ship");
		shipNameEntryField.setColumns(10);
		shipNameEntryField.setBounds(10, 256, 161, 20);
		frame.getContentPane().add(shipNameEntryField);
		
		
		//button to lock in data
		JButton confirmCrewButton = new JButton("Confirm ");
		confirmCrewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				environment.addMember(nameEntryOne.getText(), environment.masterTypes.get(memberOneSelection.getSelectedIndex()));
				environment.addMember(nameEntryTwo.getText(), environment.masterTypes.get(memberTwoSelection.getSelectedIndex()));
				
				//checks if a third person has been added 
				if (!("Enter a name!".contentEquals(nameEntryThree.getText()))) {
					environment.addMember(nameEntryThree.getText(), environment.masterTypes.get(memberThreeSelection.getSelectedIndex()));
				}
				
				//checks if a fourth person has been added
				if (!("Enter a name!".contentEquals(nameEntryFour.getText()))) {
					environment.addMember(nameEntryFour.getText(), environment.masterTypes.get(memberFourSelection.getSelectedIndex()));
				}
				environment.setShipName(shipNameEntryField.getText());
				environment.crewDebug();
				environment.launchConfirmationScreen();
				frame.dispose();
			}
		});
		confirmCrewButton.setBounds(207, 260, 153, 23);
		frame.getContentPane().add(confirmCrewButton);
	}
}
