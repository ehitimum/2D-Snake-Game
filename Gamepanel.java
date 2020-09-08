import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Gamepanel extends JPanel {
	private static final int WIDTH = 1000 , HEIGHT = 600 ;
	public Gamepanel() {
		setPreferredSize(new Dimension(WIDTH , HEIGHT )); 
		
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0 , 0 , WIDTH , HEIGHT );
		
		
		
		
	}

}
