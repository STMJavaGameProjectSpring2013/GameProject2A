import java.awt.Color;
import java.awt.Graphics;


public class AlexvcObject extends GameObject{
	
	private int x = xLoc;
	private int y = yLoc;
	
	private int[] xList = {x-25, x+25, x, x-25, x+25};
	private int[] yList = {y-25, y-25, y, y+25, y+25};


	public AlexvcObject(String shapeName, int w, int h){
		
		super(shapeName, w, h);
		
		this.setBBoxExtras(0, -1, 50, 51);
		 objW = 50;
		 objH = 50;
		
		
	}
	
	public void drawObject(Graphics g){
		
		
		xList[0] = xLoc -25;
		xList[1] = xLoc +25;
		xList[2] = xLoc;
		xList[3] = xLoc -25;
		xList[4] = xLoc +25;
		
		yList[0] = yLoc -25;
		yList[1] = yLoc -25;
		yList[2] = yLoc;
		yList[3] = yLoc +25;
		yList[4] = yLoc +25;
		
		g.setColor(Color.RED);
		g.drawRect(xLoc-(int)(objW/2)+bBoxExtraX, yLoc-(int)(objH/2)+bBoxExtraY,bBoxW, bBoxH);
		
		
		g.setColor(Color.BLUE);
		g.fillPolygon(xList, yList, 5);
		
	}
	
}
