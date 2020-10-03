import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class gamePlay1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gamePlay1 frame = new gamePlay1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gamePlay1() {
		setTitle("Snake");
		Game1 gaming1=new Game1();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(gaming1);
		gaming1.setLayout(null);
		
		JButton btnNewButton = new JButton("Restart");
		btnNewButton.setBounds(516, 292, 89, 43);
		gaming1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			    gamePlay1 f1=new gamePlay1();
				f1.setVisible(true);
				dispose();
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("Quit");
		btnNewButton_1.setBounds(516, 346, 89, 43);
		gaming1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Level1 level=new Level1();
				level.setVisible(true);
				dispose();
			}
			
		});
	}

}
