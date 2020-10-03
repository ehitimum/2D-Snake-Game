import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;

public class gamePlay extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gamePlay frame = new gamePlay();
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
	public gamePlay() {
		setTitle("Snake");
		setBackground(new Color(0, 153, 51));
		Game gaming=new Game();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(gaming);
		gaming.setLayout(null);
		
		JButton btnNewButton = new JButton("Quit");
		btnNewButton.setBounds(513, 357, 89, 41);
		gaming.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Level1 level=new Level1();
				level.setVisible(true);
				dispose();
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("Restart");
		btnNewButton_1.setBounds(513, 306, 89, 38);
		gaming.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			    gamePlay f=new gamePlay();
				f.setVisible(true);
				dispose();
			}
			
		});
	}
}
