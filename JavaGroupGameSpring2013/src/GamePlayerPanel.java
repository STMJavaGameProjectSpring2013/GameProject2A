import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	
	//GameObject testObject;
	//MrRocheObject mrRTest;
	ArrayList<MrRocheObject> allMrRocheObjects = new ArrayList<MrRocheObject>();
        
	ArrayList<GameObject> allGameObjects = new ArrayList<GameObject>();
       // DeachoObject decholol;
	Timer t;
	
	public GamePlayerPanel(int w, int h){
		panelW = w;
		panelH = h;	
		bColor = new Color((int)(Math.random()*25),(int)(Math.random()*25),(int)(Math.random()*150)+50);
		
		
		MrRocheObject mrRocheObj1;
		mrRocheObj1 = new MrRocheObject((int)(w/2), (int)(h/2));
		mrRocheObj1.setDX(0.25);
		mrRocheObj1.setDY(4.0);
                
                DeachoObject decholol;
                decholol=new DeachoObject((int) w/4,(int)h/6);
                decholol.setDX(5);
                decholol.setDY(.5);
                
		//allMrRocheObjects.add(mrRocheObj1);
		allGameObjects.add(mrRocheObj1);
		allGameObjects.add(decholol);
		
        // decholol=new DeachoObject(200,200);
		//decholol.setDX(9.0);
        //  decholol.setDY(6.0);
                
		t= new Timer(20, this);
		t.start();
	}
	
	
	
	public void paintComponent(Graphics g){
		g.setColor(bColor);
		g.fillRect(0, 0, panelW, panelH);
		
	
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
		mrRObj1 = new MrRocheObject(panelW,panelH);
		mrRObj1.setDX(Math.random()+.01);
		mrRObj1.setDY(Math.random()*10);
		allGameObjects.add(mrRObj1);
	}
	

	
	
	

}
