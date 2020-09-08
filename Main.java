import javax.swing.JFrame;

public class Main   {
	
	public Main() {
		JFrame f=new JFrame("Snake Game");
		Gamepanel gamepanel=new Gamepanel();
		f.setSize(1000,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.add(gamepanel);
	}
	
	
	
	public static void main(String Args[]) {
	new Main();
	}
	
	

}
