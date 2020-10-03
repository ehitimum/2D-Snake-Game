import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HighScore extends JFrame {

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
					HighScore frame = new HighScore();
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
	public HighScore() {
		setTitle("Snake");
		String highscore1 ="";
		String highscore2 ="";
		String highscore3 ="";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 413);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		if(highscore1.equals("")) {
			highscore1=this.GetHigh();
		}
		if(highscore2.equals("")) {
			highscore2=this.GetHigh1();
		}
		if(highscore3.equals("")) {
			highscore3=this.GetHigh2();
		}
		
		
		JLabel lblNewLabel = new JLabel(highscore1);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(20, 11, 246, 87);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(highscore2);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(20, 109, 246, 87);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(highscore3);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(20, 207, 246, 87);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(20, 324, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Level1 level=new Level1();
				level.setVisible(true);
				dispose();
			}
			
		});
		
	}
public String GetHigh() {
		
		FileReader readFile=null;
		BufferedReader reader=null;
		try {
			readFile = new FileReader("Highscore.txt");
			reader=new BufferedReader(readFile);
			return reader.readLine();
		}catch(Exception e) {
			return "Nobody : 0";
		}
		finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
public String GetHigh1() {
	
	FileReader readFile=null;
	BufferedReader reader=null;
	try {
		readFile = new FileReader("Highscore1.txt");
		reader=new BufferedReader(readFile);
		return reader.readLine();
	}catch(Exception e) {
		return "Nobody : 0";
	}
	finally {
		if(reader!=null) {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public String GetHigh2() {
	
	FileReader readFile=null;
	BufferedReader reader=null;
	try {
		readFile = new FileReader("Highscore2.txt");
		reader=new BufferedReader(readFile);
		return reader.readLine();
	}catch(Exception e) {
		return "Nobody : 0";
	}
	finally {
		if(reader!=null) {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
}

