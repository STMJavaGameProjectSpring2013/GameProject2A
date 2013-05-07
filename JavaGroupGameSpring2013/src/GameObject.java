import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class GameObject {

	static int objectIDNum = 0;
	//Instance Variables
	int xLoc, yLoc; 
	int objW; 
	int objH;
	double dx, dy;
	int whoAmI;
	//this establishes a bounding box for the image for collision detection
	//X and Y coordinates are relative(Extra) to xLoc and yLoc
	int bBoxExtraX, bBoxExtraY;
	int bBoxW, bBoxH;
	String objIDString = null;
	
	
	long reproductionCycle = 15000L;  //15 Seconds in Milliseconds
	/////////////////////////1367546758506
	long timeOfCreation;
	long nextSpawnTime;
	long lifeCycle = 29900L;
	long checkOutTime;
	
	Color objColor = Color.white;
	
	//Constructors
	public GameObject(String type, int w, int h) {
		objectIDNum++;
		whoAmI = objectIDNum;
		objIDString = new String ("Obj# ").concat(Integer.toString(objectIDNum) + "("+ type + ")");
		//System.out.println("I just created a game object");
		xLoc = (int)(Math.random()*(w-100))+50;
		yLoc = (int)(Math.random()*(w-100))+50;
		timeOfCreation = System.currentTimeMillis();
		nextSpawnTime = timeOfCreation+reproductionCycle+(long)(Math.random()*8000);
		checkOutTime = timeOfCreation+lifeCycle+(long)(Math.random()*10000);
		System.out.println("object Number " + objectIDNum + " time of creation: " + timeOfCreation);
		System.out.println("CheckoutTime for " + objectIDNum + " is " + checkOutTime);
		System.out.println("ObjIDString is: " + objIDString);
		
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
	
	public boolean checkSpawnTime() {
		boolean timeToSpawn = false;
		long curTime = System.currentTimeMillis();
		if(curTime >= nextSpawnTime){
			timeToSpawn=true;
			nextSpawnTime = curTime + reproductionCycle;
		}
		return timeToSpawn;
	}
	
	
	public boolean timeToKickIt(){
		boolean timeToKick = false;
		
		long curTime = System.currentTimeMillis();
		if(curTime >= checkOutTime){
			timeToKick=true;
		}
		return timeToKick;
	}
	
	public void setBBoxExtras(int extraX, int extraY, int w, int h){
	
		bBoxExtraX = extraX; 
		bBoxExtraY = extraY; 
		bBoxW = w;
		bBoxH = h;
	}
	
	public int getBBoxX(){
		return xLoc + bBoxExtraX;
	}
	
	public int getBBoxY(){
		return yLoc + bBoxExtraY;
	}
	
	public int getBBoxW(){
		return bBoxW;
	}
	
	public int getBBoxH(){
		return bBoxH;
	}
	
	public void checkCollision(ArrayList<GameObject> objectList){
		
		GameObject testObject;
		//Check all the objects and handle any collisions....
		for(int i = 0; i < objectList.size(); ++i){
			testObject = objectList.get(i);
			
			if(testObject != this){
				if(isACollision(testObject) ==true){
					//do something
					System.out.println("Collision between " + this.getObjIDString() + " and " + testObject.getObjIDString());
				}
			}
			
			
		}
		
		
		
	}
	
	public boolean isACollision(GameObject gameObj) {
		
		boolean whatToReturn = true;
		
		if ((gameObj.getBBoxX()+gameObj.getBBoxW()) < this.getBBoxX()) {
			whatToReturn = false;
		} else if (gameObj.getBBoxX() > this.getBBoxX()+this.getBBoxW()) {
			whatToReturn = false;
	
		} else if ((gameObj.getBBoxY()+gameObj.getBBoxH()) < this.getBBoxY()) {
			whatToReturn = false;
		} else if (gameObj.getBBoxY() > (this.getBBoxY()+this.getBBoxH())) {
			whatToReturn = false;
		} 
		
		
		
		return whatToReturn;
	}

	public String getObjIDString(){
		return objIDString;
	}
}
