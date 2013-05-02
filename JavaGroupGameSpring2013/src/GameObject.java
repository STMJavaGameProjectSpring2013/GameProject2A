import java.awt.Color;
import java.awt.Graphics;


public class GameObject {

	//Instance Variables
	int xLoc, yLoc; 
	int objW = 20, objH =20;
	double dx, dy;
	
	Color objColor = Color.white;
	
	//Constructors
	public GameObject(int x, int y) {
		System.out.println("I just created a game object");
		xLoc = x;
		yLoc = y;
		
	}

	
	//Methods
	public void moveObject(){
		xLoc += (int)dx;
		yLoc += (int)dy;
	}
	
	public void drawObject(Graphics g){
		g.setColor(objColor);
		g.draw3DRect(xLoc-(int)(objW/2), yLoc-(int)(objH/2), objW, objH, true);
		g.setColor(Color.RED);
		g.fillOval(xLoc-2, yLoc-2, 5, 5);
	}
	
	//Basic Setters and getters....
	
	//These control the setting of X-Y LOCATIONS
	public void setXLoc(int newX){
		xLoc = newX;
	}
	public void setYLoc(int newY){
		yLoc = newY;
	}
	public int getXLoc(){
		return xLoc;
	}
	public int getYLoc(){
		return yLoc;
	}
	
	
	//We might need to know information about width
	public int getObjWidth(){
		return objW;
	}
	public int getObjHeight(){
		return objH;
	}
	
	
	//These methods control the setting of DX-DY Values
	public void setDX(double newDX){
		dx = newDX;
	}
	public void setDY(double newDY){
		dy = newDY;
	}
	public double getDX(){
		return dx;
	}
	public double getDY(){
		return dy;
	}
	public void changeDX(double changeValue){
		dx += changeValue;
	}
	public void changeDY(double changeValue){
		dy += changeValue;
	}
	
	//CheckBounds will allow each object to correct their positioning 
	//so that they all stay visible in the window
	
	public void checkBounds(int panelWidth, int panelHeight){
		
		int rightFrame = 15;
		int bottomFrame = 30;
		
		if(getDX() < 0){
			if(getXLoc()-(int)(getObjWidth()/2) < 0){
				setXLoc((int)(getObjWidth()/2));
				setDX(getDX()*-1);
			}
		}
		
		if(getDX() > 0){
			if((getXLoc()+(int)(getObjWidth()/2)) > (panelWidth-rightFrame)){
				setXLoc(panelWidth-(int)(getObjWidth()/2)-rightFrame);
				setDX(getDX()*-1);
			}
		}
		
		
		if(getDY() < 0){
			if(getYLoc()-(int)(getObjHeight()/2) < 0){
				setYLoc((int)(getObjHeight()/2));
				setDY(getDY()*-1);
			}
		}
		
		
		if(getDY() > 0){
			if(getYLoc()+(int)(getObjHeight()/2) > (panelHeight-bottomFrame)){
				setYLoc(panelHeight-(int)(getObjHeight()/2)-bottomFrame);
				setDY(getDY()*-1);
			}
		}
		
	
	}

}
