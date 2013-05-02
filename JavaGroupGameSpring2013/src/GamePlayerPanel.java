import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePlayerPanel extends JPanel implements ActionListener {


	private static final long serialVersionUID = 1L;

	
	//Instance variables
	private int panelW;
	private int panelH;
	private Color bColor;
	private double dxRate = 0.01;
	
	//GameObject testObject;
	//MrRocheObject mrRTest;
	ArrayList<MrRocheObject> allMrRocheObjects = new ArrayList<MrRocheObject>();
       // DeachoObject decholol;
	Timer t;
	
	public GamePlayerPanel(int w, int h){
		panelW = w;
		panelH = h;	
		bColor = new Color((int)(Math.random()*25),(int)(Math.random()*25),(int)(Math.random()*150)+50);
		
		//testObject = new GameObject((int)(w/2), (int)(h/2));
		//testObject.setDX(3.0);
		//testObject.setDY(4.0);
		//Add a first Mr. Roche Object
		MrRocheObject mrRocheObj1;
		mrRocheObj1 = new MrRocheObject((int)(w/2), (int)(h/2));
		mrRocheObj1.setDX(0.25);
		mrRocheObj1.setDY(4.0);
		allMrRocheObjects.add(mrRocheObj1);
		
		
        // decholol=new DeachoObject(200,200);
		//decholol.setDX(9.0);
        //  decholol.setDY(6.0);
                
		t= new Timer(20, this);
		t.start();
	}
	
	
	
	public void paintComponent(Graphics g){
		g.setColor(bColor);
		g.fillRect(0, 0, panelW, panelH);
		
	
		drawMrRocheObjects(g);
		//mrRTest.drawObject(g);
		//testObject.drawObject(g);
       // decholol.drawObject(g);
	}
	
	
	public void drawMrRocheObjects(Graphics g){
		
		int listLength = allMrRocheObjects.size();
		for(int i = 0; i < listLength; ++i){
			allMrRocheObjects.get(i).drawObject(g);
		}
	}



	
	public void actionPerformed(ActionEvent e) {
		
		moveMrRocheObjects();
		repaint();	
	}
	
	public void moveMrRocheObjects(){
		int listLength = allMrRocheObjects.size();
		for(int i = 0; i < listLength; ++i){
			allMrRocheObjects.get(i).moveObject();
			allMrRocheObjects.get(i).checkBounds(panelW,panelH);
			allMrRocheObjects.get(i).setCrazyDX();
			if(allMrRocheObjects.get(i).checkSpawnTime()==true){
				
			}
		}
		
	}
	
	
	public void checkBounds(){

		//***** I HAVE MIGRATED THIS FUNCTIONALITY TO GAME OBJECT
		//NOW EACH OBJECT JUST CHECKS ITS OWN BOUNDS
		/*
		int rightFrame = 15;
		int bottomFrame = 30;
		if(testObject.getDX() < 0){
			if(testObject.getXLoc()-(int)(testObject.getObjWidth()/2) < 0){
				testObject.setXLoc(0);
				testObject.setDX(testObject.getDX()*-1);
			}
		}
		
		if(testObject.getDX() > 0){
			if((testObject.getXLoc()+(int)(testObject.getObjWidth()/2)) > (panelW-rightFrame)){
				testObject.setXLoc(panelW-(int)(testObject.getObjWidth()/2)-rightFrame);
				testObject.setDX(testObject.getDX()*-1);
			}
		}
		
		
		if(testObject.getDY() < 0){
			if(testObject.getYLoc()-(int)(testObject.getObjHeight()/2) < 0){
				testObject.setYLoc(0);
				testObject.setDY(testObject.getDY()*-1);
			}
		}
		
		
		if(testObject.getDY() > 0){
			if(testObject.getYLoc()+(int)(testObject.getObjHeight()/2) > (panelH-bottomFrame)){
				testObject.setYLoc(panelH-(int)(testObject.getObjHeight()/2)-bottomFrame);
				testObject.setDY(testObject.getDY()*-1);
			}
		}
		
		*/
		
		/*
		if(decholol.getDX() < 0){
			if(decholol.getXLoc()-(int)(decholol.getObjWidth()/2) < 0){
				decholol.setXLoc(0);
				decholol.setDX(decholol.getDX()*-1);
			}
		}
		
		if(decholol.getDX() > 0){
			if((decholol.getXLoc()+(int)(decholol.getObjWidth()/2)) > (panelW-rightFrame)){
				decholol.setXLoc(panelW-(int)(decholol.getObjWidth()/2)-rightFrame);
				decholol.setDX(decholol.getDX()*-1);
			}
		}
		
		
		if(decholol.getDY() < 0){
			if(decholol.getYLoc()-(int)(decholol.getObjHeight()/2) < 0){
				decholol.setYLoc(0);
				decholol.setDY(decholol.getDY()*-1);
			}
		}
		
		
		if(decholol.getDY() > 0){
			if(decholol.getYLoc()+(int)(decholol.getObjHeight()/2) > (panelH-bottomFrame)){
				decholol.setYLoc(panelH-(int)(decholol.getObjHeight()/2)-bottomFrame);
				decholol.setDY(decholol.getDY()*-1);
			}
		}
		
		*/
	}
	

	
	
	

}
