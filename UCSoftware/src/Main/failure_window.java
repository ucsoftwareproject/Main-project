package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class failure_window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					failure_window window = new failure_window();
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
	public failure_window() {
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
		
		
		JButton btnCloseGame = new JButton("Close Game");
		btnCloseGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		btnCloseGame.setBounds(48, 152, 131, 23);
		frame.getContentPane().add(btnCloseGame);
		
		JTextPane txtpnD = new JTextPane();
		txtpnD.setText("Your crew ran out of time!\nNow they'll be stranded forever.\nGame over.");
		txtpnD.setBounds(10, 60, 218, 74);
		frame.getContentPane().add(txtpnD);
	}
}
