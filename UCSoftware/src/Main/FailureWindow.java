package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FailureWindow {

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
					FailureWindow window = new FailureWindow(environment, crewMembers);
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
	public FailureWindow(GameEnvironment engine, crew crewInfo) {
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
		frame.setBounds(100, 100, 254, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYouLose = new JLabel("YOU LOSE");
		lblYouLose.setBounds(88, 31, 106, 14);
		frame.getContentPane().add(lblYouLose);
		
		
		JButton closeGameButton = new JButton("Close Game");
		closeGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		closeGameButton.setBounds(48, 152, 131, 23);
		frame.getContentPane().add(closeGameButton);
		score = environment.getScore();
		JTextPane gameOverPane = new JTextPane();
		gameOverPane.setText("Your crew ran out of time!\nNow they'll be stranded forever.\nGame over.\nYour final score was: " + score);
		gameOverPane.setBounds(10, 60, 218, 74);
		frame.getContentPane().add(gameOverPane);
	}
}
