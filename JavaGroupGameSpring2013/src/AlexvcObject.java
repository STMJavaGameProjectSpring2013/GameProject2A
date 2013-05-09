import java.awt.Color;
import java.awt.Graphics;


public class AlexvcObject extends GameObject{
	
	private int x = xLoc;
	private int y = yLoc;
	
	private int[] xList = {x-30, x+30, x, x-30, x+30};
	private int[] yList = {y-30, y-30, y, y+30, y+30};


	public AlexvcObject(String shapeName, int w, int h){
		
		super(shapeName, w, h);
		
		this.setBBoxExtras(0, -1, 60, 61);
		 objW = 60;
		 objH = 60;
		
		
	}
	
	public void drawObject(Graphics g){
		
		
		xList[0] = xLoc -30;
		xList[1] = xLoc +30;
		xList[2] = xLoc;
		xList[3] = xLoc -30;
		xList[4] = xLoc +30;
		
		yList[0] = yLoc -30;
		yList[1] = yLoc -30;
		yList[2] = yLoc;
		yList[3] = yLoc +30;
		yList[4] = yLoc +30;
		
		g.setColor(Color.RED);
		g.drawRect(xLoc-(int)(objW/2)+bBoxExtraX, yLoc-(int)(objH/2)+bBoxExtraY,bBoxW, bBoxH);
		
		
		g.setColor(Color.BLUE);
		g.fillPolygon(xList, yList, 5);
		
	}
	
}
