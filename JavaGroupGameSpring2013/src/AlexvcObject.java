import java.awt.Color;
import java.awt.Graphics;


public class AlexvcObject extends GameObject{
	
	private int x = 200;
	private int y = 300;
	
	private int[] xList = {x-25, x+25, x, x-25, x+25};
	private int[] yList = {y-25, y-25, y, y+25, y+25};


	public AlexvcObject(String shapeName, int w, int h){
		
		super(shapeName, w, h);
		
		
		
	}
	
	public void paintComponent(Graphics g){
		
		g.setColor(Color.BLUE);
		g.fillRect(250, 250, 100, 100);
		g.fillPolygon(xList, yList, 5);
		
		
	}
	
}
