import javax.swing.JFrame;


public class JavaGroupGameSpring2013 {

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
		f = new JFrame("Daddy owns this game.");
		f.setSize(fWidth, fHeight);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new GamePlayerPanel(fWidth, fHeight);
		f.add(p);
		
		f.setVisible(true);
                //Added by David Eacho because i kept accidentally resizing the window and getting tons of useless gray stuff... hehehe... my bad
		f.setResizable(false);

	}

}
