import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePlayerPanel extends JPanel implements ActionListener {


	private static final long serialVersionUID = 1L;


	private static final String MrRocheObject = null;

	
	//Instance variables
	private int panelW;
	private int panelH;
	private Color bColor;
	private double dxRate = 0.01;
	private JFrame myFrame;
	
	//GameObject testObject;
	//MrRocheObject mrRTest;
	ArrayList<MrRocheObject> allMrRocheObjects = new ArrayList<MrRocheObject>();
        
	ArrayList<GameObject> allGameObjects = new ArrayList<GameObject>();
       // DeachoObject decholol;
	Timer t;
	
	public GamePlayerPanel(int w, int h, JFrame ff){
		myFrame = ff;
		panelW = w;
		panelH = h;	
		bColor = new Color((int)(Math.random()*25),(int)(Math.random()*25),(int)(Math.random()*150)+50);
		
		
		MrRocheObject mrRocheObj1;
		mrRocheObj1 = new MrRocheObject("Mr. Roche", (int)(w/2), (int)(h/2));
		mrRocheObj1.setDX(0.25);
		mrRocheObj1.setDY(4.0);
                
                DeachoObject decholol;
                decholol=new DeachoObject("EachoObj", (int) w/4,(int)h/6);
                decholol.setDX(5);
                decholol.setDY(.5);
                
                //There is no Alex VC Class That needs to be added.
                AlexvcObject alexvcObj;
                alexvcObj = new AlexvcObject("Alex", (int) w/2, (int) h/2);
                alexvcObj.setDX(0);
                alexvcObj.setDY(0);
                
                
                
		//allMrRocheObjects.add(mrRocheObj1);
		allGameObjects.add(mrRocheObj1);
		allGameObjects.add(decholol);
		allGameObjects.add(alexvcObj);
		
        // decholol=new DeachoObject(200,200);
		//decholol.setDX(9.0);
        //  decholol.setDY(6.0);
                
		t= new Timer(20, this);
		t.start();
	}
	
	
	
	public void paintComponent(Graphics g){
		
		if(myFrame.getWidth() != panelW){
			panelW = myFrame.getWidth();
		}
		
		if(myFrame.getHeight() != panelH){
			panelH = myFrame.getHeight();
		}
		g.setColor(Color.gray);
		g.fillRect(0, 0, myFrame.getWidth(), myFrame.getHeight());
		
	
		//drawMrRocheObjects(g);
		drawAllGameObjects(g);
		
       // decholol.drawObject(g);
	}
	
	
public void drawAllGameObjects(Graphics g){
		
		int listLength = allGameObjects.size();
		for(int i = 0; i < listLength; ++i){
			if(allGameObjects.get(i) instanceof MrRocheObject){
				allGameObjects.get(i).drawObject(g);
			}
                    if(allGameObjects.get(i) instanceof DeachoObject){
			allGameObjects.get(i).drawObject(g);
			}
                        
            //  Alexvc object doenst exist on the git hub.    
                    if(allGameObjects.get(i) instanceof AlexvcObject){
                        allGameObjects.get(i).drawObject(g);
                    }
			
			
		}
	}
	
	



	
	public void actionPerformed(ActionEvent e) {
		
		//moveMrRocheObjects();
		moveAllObjects();
		repaint();	
	}
	
	/* we are migrating from just mR Roche objects....
	public void moveMrRocheObjects(){
		int listLength = allMrRocheObjects.size();
		ArrayList<Integer> casualties = new ArrayList<Integer>();
		for(int i = 0; i < listLength; ++i){
			allMrRocheObjects.get(i).moveObject();
			allMrRocheObjects.get(i).checkBounds(panelW,panelH);
			allMrRocheObjects.get(i).setCrazyDX();
			if(allMrRocheObjects.get(i).checkSpawnTime()==true){		
				MrRocheObject mrRObj1;
				mrRObj1 = new MrRocheObject(panelW,panelH);
				mrRObj1.setDX(Math.random()+.01);
				mrRObj1.setDY(Math.random()*10);
				allMrRocheObjects.add(mrRObj1);
			}
			
			if(allMrRocheObjects.get(i).timeToKickIt() == true){
				System.out.println("it is time to Kick It for arrayList slot: " + i);
				casualties.add(new Integer(i));
				allMrRocheObjects.get(i).setDX(0.0);
				allMrRocheObjects.get(i).setDY(0.0);
				
			}
		}
		
		//Clean up list
		for(int i = 0; i<casualties.size(); ++i){
			allMrRocheObjects.remove(casualties.get(i).intValue());
		}
		
	}
	
	*/
	
	
	
	public void moveAllObjects(){
		int listLength = allGameObjects.size();
		ArrayList<Integer> casualties = new ArrayList<Integer>();
		for(int i = 0; i < listLength; ++i){
			allGameObjects.get(i).moveObject();
			allGameObjects.get(i).checkBounds(panelW,panelH);
			checkCollision(allGameObjects.get(i));
			
			//Now do stuff for Spawning....
			if(allGameObjects.get(i).checkSpawnTime()==true){
				if(allGameObjects.get(i) instanceof MrRocheObject){
					doMrRocheSpawn();
				}
			}
			//And do stuff for Logans Runs Timed obsolescence....
			if(allGameObjects.get(i).timeToKickIt() == true){
				System.out.println("it is time to Kick It for arrayList slot: " + i);
				casualties.add(new Integer(i));
				allGameObjects.get(i).setDX(0.0);
				allGameObjects.get(i).setDY(0.0);
				
			}
			
			//for MrRocheObjects
			if(allGameObjects.get(i) instanceof MrRocheObject){
				((MrRocheObject) allGameObjects.get(i)).setCrazyDX();
			}	
		}  // END OF MAIN LOOP TO RUN THROUGH ALL OBJECTS
		

		//Clean up list
		for(int i = 0; i<casualties.size(); ++i){
			allGameObjects.remove(casualties.get(i).intValue());
		}
		
	}
	
	public void checkBounds(){

		/***** I HAVE MIGRATED THIS FUNCTIONALITY TO GAME OBJECT
		*NOW EACH OBJECT JUST CHECKS ITS OWN BOUNDS.  Instead of
		*calling this method, you just call yourObject.checkBounds( panelW, panelH)
		--Mr. Roche
		*/
		
		
	}
	
	
	public void doMrRocheSpawn(){
		MrRocheObject mrRObj1;
		mrRObj1 = new MrRocheObject("Mr. Roche", panelW,panelH);
		mrRObj1.setDX(Math.random()+.01);
		mrRObj1.setDY(Math.random()*10);
		allGameObjects.add(mrRObj1);
	}
	
	
	public int getPanelW(){
		return panelW;
	}
	
	public int getPanelH(){
		return panelH;
	}
	
	
	public void checkCollision(GameObject testObject){
		
		GameObject otherObject;
		//Check all the objects and handle any collisions....
		for(int i = 0; i < allGameObjects.size(); ++i){
			otherObject = allGameObjects.get(i);
			
			if(testObject != otherObject){
				if(isACollision(testObject, otherObject) ==true){
					//do something
					System.out.println("Collision between " + testObject.getObjIDString() + " and " + otherObject.getObjIDString());
					bounceIt(testObject, otherObject);
				}
			}
			
		}
	}
			




	public boolean isACollision(GameObject testObject, GameObject otherObject) {
		boolean whatToReturn = true;
		
		if ((otherObject.getBBoxX()+otherObject.getBBoxW()) < testObject.getBBoxX()) {
			whatToReturn = false;
		} else if (otherObject.getBBoxX() > testObject.getBBoxX()+testObject.getBBoxW()) {
			whatToReturn = false;
	
		} else if ((otherObject.getBBoxY()+otherObject.getBBoxH()) < testObject.getBBoxY()) {
			whatToReturn = false;
		} else if (otherObject.getBBoxY() > (testObject.getBBoxY()+testObject.getBBoxH())) {
			whatToReturn = false;
		} 

		return whatToReturn;
	}

	
	
	
	public void bounceIt(GameObject testObject, GameObject otherObject){
		 int difference;
		if((testObject.getBBoxX()+testObject.getBBoxW())>= otherObject.getBBoxX()){
			difference =(testObject.getBBoxX()+ testObject.getBBoxW()) - otherObject.getBBoxX();
			testObject.setXLoc(testObject.getXLoc()-(int)(difference/2)-1);
			otherObject.setXLoc(otherObject.getXLoc()+ (int)(difference/2)+1);
		} else if((otherObject.getBBoxX()+otherObject.getBBoxW())>= testObject.getBBoxX()){
				difference = (otherObject.getBBoxX()+otherObject.getBBoxW()) - testObject.getBBoxX();
				otherObject.setXLoc(otherObject.getXLoc()-(int)(difference/2)-1);
				testObject.setXLoc(testObject.getXLoc()+ (int)(difference/2)+1);
			
		}
		
		//switch dx and dy
		double tempX = testObject.getDX();
		testObject.setDX(otherObject.getDX());
		otherObject.setDX(tempX);
		
		double tempY = testObject.getDY();
		testObject.setDY(otherObject.getDY());
		otherObject.setDY(tempY);
		
		repaint();
	}
	

}
