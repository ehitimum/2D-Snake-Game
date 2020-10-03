import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class gamePlay2 extends JFrame {

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
					gamePlay2 frame = new gamePlay2();
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
	public gamePlay2() {
		setTitle("Snake");
		Game2 gaming2=new Game2();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(gaming2);
		gaming2.setLayout(null);
		
		JButton btnNewButton = new JButton("Restart");
		btnNewButton.setBounds(515, 324, 101, 48);
		gaming2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			    gamePlay2 f2=new gamePlay2();
				f2.setVisible(true);
				dispose();
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("Quit");
		btnNewButton_1.setBounds(515, 383, 101, 48);
		gaming2.add(btnNewButton_1);
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
