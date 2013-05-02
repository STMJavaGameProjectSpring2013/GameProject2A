import javax.swing.JFrame;


public class JavaGameProject2A {

	/**
	 This is the Git Hub Version of the Java Game
	 Started by Mr. Roche with Alex Dolce, David Eacho, Ethan Pailes, 
	 Paul Tempel and Alex Von Campe, Spring term 2013
	 */
	
	//Instance variables
	static JFrame f;
	static GamePlayerPanel p;
	static int fWidth = 900, fHeight=700;
	public static void main(String[] args) {
		
		//Start of the game, build a frame
		f = new JFrame("The Game with No Name Right Now");
		f.setSize(fWidth, fHeight);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new GamePlayerPanel(fWidth, fHeight);
		f.add(p);
		
		f.setVisible(true);
		

	}

}
