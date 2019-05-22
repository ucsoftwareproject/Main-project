package Main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class WinScreenWindow {

	private JFrame frame;
	private static GameEnvironment environment;
	private static crew crewMembers;
	int score;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinScreenWindow window = new WinScreenWindow(environment, crewMembers);
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
	public WinScreenWindow(GameEnvironment engine, crew crewInfo) {
		environment = engine;
		crewMembers = crewInfo;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 334, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYouLose = new JLabel("YOU WON!!");
		lblYouLose.setBounds(133, 34, 106, 14);
		frame.getContentPane().add(lblYouLose);
		
		
		JButton closeGameButton = new JButton("Close Game");
		closeGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		closeGameButton.setBounds(88, 220, 131, 23);
		frame.getContentPane().add(closeGameButton);
		score = environment.getScore();
		JTextPane gameOverPane = new JTextPane();
		gameOverPane.setText("Your crew managed to find all of the ship parts! They boarded " + environment.getShipName() + " and managed to continue their journey!\nYour final score was: " + score);
		gameOverPane.setBounds(30, 78, 262, 96);
		frame.getContentPane().add(gameOverPane);
	}
}
