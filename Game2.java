import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game2 extends JPanel implements ActionListener,KeyListener {

	private static final long serialVersionUID = 1L;
	final int x[]=new int[constants.GAME_UNIT];
	final int y[]=new int[constants.GAME_UNIT];
	boolean running= false ;
	int Bodysize=5;
	int foodEaten;
	int foodx;
	int foody;
	char Path = 'R';
	Timer timer;
	Random random;
	String HighScore2="";
	
	public Game2() {
		random=new Random();
		setPreferredSize(new Dimension(constants.WIDTH , constants.HEIGHT )); 
		this.setFocusable(true);
		addKeyListener(this);
		start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void newFood() {
		foodx= random.nextInt((int)(constants.WIDTH/constants.UNIT))*constants.UNIT;
		foody= random.nextInt((int)(constants.HEIGHT/constants.UNIT))*constants.UNIT;
	}
	public void draw(Graphics g) {
		
	
			if(running) {
		
			g.setColor(Color.YELLOW);
			g.fillRect(0 , 0 , constants.WIDTH , constants.HEIGHT );
					g.setColor(Color.RED);
					g.fillOval(foodx, foody, constants.UNIT, constants.UNIT);
				for(int i=0;i< Bodysize;i++) {
						if(i==0) {
							g.setColor(Color.black);
							g.fillOval(x[i], y[i], constants.UNIT, constants.UNIT);
						}
						else {
							g.setColor(Color.black);
							g.fillOval(x[i], y[i], constants.UNIT, constants.UNIT);
						}
					}
				g.setColor(Color.BLUE);
				g.setFont(new Font("TimesRoman",Font.BOLD,20));
				FontMetrics font=getFontMetrics(g.getFont());
				g.drawString("Score:"+foodEaten, (constants.WIDTH-font.stringWidth("Score:"+foodEaten))/3 , g.getFont().getSize() );
				if(HighScore2.equals("")) {
					HighScore2=this.GetHighScore2();
				}
				g.setFont(new Font("TimesRoman",Font.BOLD,20));
				FontMetrics font2=getFontMetrics(g.getFont());
				g.drawString("Highscore:"+HighScore2, (constants.WIDTH-font2.stringWidth("Highscorecore:"+HighScore2)) , g.getFont().getSize() );
		}
		else {
			gameOver(g);
			
		}
		
	}
	public void CheckScore2() {
		//System.out.println(HighScore2);
		if( foodEaten>Integer.parseInt((HighScore2.split(":")[1])) ) {
			String name="Hard-Ehtimam"; 
			HighScore2=name+":"+foodEaten;
			File scoreFile=new File("Highscore2.txt");
			if(!scoreFile.exists()) {
				
				try {
					scoreFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			FileWriter writeFile = null;
			BufferedWriter writer= null;
			try {
				writeFile= new  FileWriter(scoreFile);
				writer=new BufferedWriter(writeFile);
				writer.write(this.HighScore2);
			}catch(Exception e) {
				
			}
			finally{
				try {
					if(writer!=null) {
						writer.close();
					}
				}catch(Exception e) {
					
				}
			}
			
			
			
			
		}
	}
public String GetHighScore2() {
		
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
	public void move() {
		for(int i= Bodysize;i>0;i--) {
			x[i]=x[i-1];
			y[i]=y[i-1];
		}

		switch (Path) {
			
			case 'U': 
				y[0]=y[0]-constants.UNIT;
				break;
			case 'D':
				y[0]=y[0]+constants.UNIT;
				break;
			case 'L':
				x[0]=x[0]-constants.UNIT;
				break;
			case 'R':
				x[0]=x[0]+ constants.UNIT ;
				break;
		
		}
	}
	public void start() {
		newFood();
		running = true;
		timer = new Timer(constants.TURBO,this);
		timer.start();
	}
		
	public void checkCrush() {
		for(int i= Bodysize; i>0 ;i--) {
			if((x[0]==x[i]) && (y[0]==y[i])) {
				running = false;
			}
			if(x[0]<0) {
				running=false;
			}
			if(x[0]> constants.WIDTH) {
				running = false;
			}
			if(y[0]<0) {
				running = false;
			}
			if(y[0]> constants.HEIGHT) {
				running = false;
			}
			if(!running) {
				timer.stop();
			}
		}
	}
	
 @Override
	public void actionPerformed(ActionEvent e) {
		if(running) {
			move();
			checkFood();
			checkCrush();
		}
		repaint();
		

	}
 public void checkFood() {
	 	if((x[0]==foodx)&&(y[0]==foody)) {
	 		Bodysize++;
	 		foodEaten++;
	 		newFood();
	 	}
 }
	
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(Path!= 'R') {
					Path = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(Path!= 'L') {
					Path = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(Path!= 'D') {
			       Path = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(Path!= 'U') {
					Path = 'D';
				}
				break;
				
			}
			
		}
		public void gameOver(Graphics g) {
			g.setColor(Color.BLUE);
			g.setFont(new Font("TimesRoman",Font.BOLD,20));
			FontMetrics font1=getFontMetrics(g.getFont());
			g.drawString("Score:"+foodEaten, (constants.WIDTH-font1.stringWidth("Score:"+foodEaten))/3 , g.getFont().getSize() );
			g.setColor(Color.BLUE);
			g.setFont(new Font("Ink Free",Font.BOLD,12));
			FontMetrics font=getFontMetrics(g.getFont());
			g.drawString("GAME OVER", (constants.WIDTH-font.stringWidth("GAME OVER"))/2 , constants.HEIGHT/2);
			CheckScore2();
			if(HighScore2.equals("")) {
				HighScore2=this.GetHighScore2();
			}
			g.setFont(new Font("TimesRoman",Font.BOLD,20));
			FontMetrics font2=getFontMetrics(g.getFont());
			g.drawString("Highscore:"+HighScore2, (constants.WIDTH-font2.stringWidth("Highscorecore:"+HighScore2)) , g.getFont().getSize() );
			
			
			
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	

			
		
	
	

}
