import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Level1 extends JFrame {

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
					Level1 frame = new Level1();
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
	public Level1() {
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Easy");
		btnNewButton.setBounds(296, 184, 219, 31);
		btnNewButton.setBackground(Color.GREEN);
		contentPane.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gamePlay game=new gamePlay();
				game.setVisible(true);
				dispose();
			}
			
		});
		JButton btnNewButton_1 = new JButton("Normal");
		btnNewButton_1.setBounds(296, 226, 219, 31);
		btnNewButton_1.setBackground(Color.GREEN);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gamePlay1 game1=new gamePlay1();
				game1.setVisible(true);
				dispose();
			}
			
		});
		
		JButton btnNewButton_2 = new JButton("Hard");
		btnNewButton_2.setBounds(296, 268, 219, 31);
		btnNewButton_2.setBackground(Color.GREEN);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Highscore");
		btnNewButton_3.setBounds(293, 310, 222, 31);
		btnNewButton_3.setBackground(Color.GREEN);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.setBounds(330, 352, 150, 31);
		btnNewButton_4.setBackground(Color.GREEN);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(254, 48, 304, 86);
		contentPane.add(lblNewLabel);
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gameFrame fr=new gameFrame();
				fr.setVisible(true);
				dispose();
			}
			
		});
		
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HighScore high=new HighScore();
				high.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gamePlay2 game2=new gamePlay2();
				game2.setVisible(true);
				dispose();
			}
			
		});
	
	}
}
