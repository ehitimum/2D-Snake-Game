import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gamepanel extends JPanel implements ActionListener,KeyListener {

	private static final long serialVersionUID = 1L;
	final int x[]=new int[Constants.GAME_UNIT];
	final int y[]=new int[Constants.GAME_UNIT];
	boolean running= false ;
	
	int Bodyparts=6;
	char Path = 'R';
	Timer timer;
	
	
	public Gamepanel() {
		setPreferredSize(new Dimension(Constants.WIDTH , Constants.HEIGHT )); 
		this.setFocusable(true);
		start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0 , 0 , Constants.WIDTH , Constants.HEIGHT );
		
		for(int i=0; i < Constants.HEIGHT / Constants.UNIT ; i++ ) {
			g.drawLine(i*Constants.UNIT, 0, i*Constants.UNIT, HEIGHT);
			g.drawLine(0, i*Constants.UNIT, WIDTH, i*Constants.UNIT);
		}
		for(int i=0;i< Bodyparts;i++) {
			if(i==0) {
				g.setColor(Color.yellow);
				g.fillRect(x[i], y[i], Constants.UNIT, Constants.UNIT);
			}
			else {
				g.setColor(Color.pink);
				g.fillRect(x[i], y[i], Constants.UNIT, Constants.UNIT);
			}
		}
	}
	public void move() {
		for(int i= Bodyparts;i>0;i--) {
			x[i]=x[i-1];
			y[i]=y[i-1];
		}
		switch (Path) {
			
			case 'U': 
				y[0]=y[0]-Constants.UNIT;
				break;
			case 'D':
				y[0]=y[0]+Constants.UNIT;
				break;
			case 'L':
				x[0]=x[0]-Constants.UNIT;
				break;
			case 'R':
				x[0]=x[0]+ Constants.UNIT ;
				break;
		
		}
	}
	public void start() {
		
		running = true;
		timer = new Timer(Constants.SPEED,this);
		timer.start();
	}
		
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(running) {
			move();
		}
		repaint();
		

	}

}
