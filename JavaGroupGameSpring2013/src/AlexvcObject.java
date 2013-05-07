import java.awt.Color;
import java.awt.Graphics;


public class AlexvcObject extends GameObject{
	
	private int x = 200;
	private int y = 300;
	
	private int[] xList = {x-25, x+25, x, x-25, x+25};
	private int[] yList = {y-25, y-25, y, y+25, y+25};


	public AlexvcObject(int w, int h){
		
		super("temp",w, h);
		
		
		
	}
	
	public void paintComponent(Graphics g){
		
		g.setColor(Color.BLUE);
		g.fillPolygon(xList, yList, 5);
		
		
	}
	
}
