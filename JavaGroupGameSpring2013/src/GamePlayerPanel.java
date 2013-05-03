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
		ArrayList<Integer> casualties = new ArrayList<Integer>();
		for(int i = 0; i < listLength; ++i){
			allMrRocheObjects.get(i).moveObject();
			allMrRocheObjects.get(i).checkBounds(panelW,panelH);
			allMrRocheObjects.get(i).setCrazyDX();
			if(allMrRocheObjects.get(i).checkSpawnTime()==true){		
				MrRocheObject mrRObj1;
				mrRObj1 = new MrRocheObject(panelW,panelH);
				mrRObj1.setDX(Math.random());
				mrRObj1.setDY(Math.random()*10);
				allMrRocheObjects.add(mrRObj1);
			}
			
			if(allMrRocheObjects.get(i).timeToKickIt() == true){
				casualties.add(new Integer(i));
			}
		}
		
		//Clean up list
		for(int i = 0; i<casualties.size(); ++i){
			allMrRocheObjects.remove(casualties.get(i));
		}
		
	}
	
	
	public void checkBounds(){

		/***** I HAVE MIGRATED THIS FUNCTIONALITY TO GAME OBJECT
		*NOW EACH OBJECT JUST CHECKS ITS OWN BOUNDS.  Instead of
		*calling this method, you just call yourObject.checkBounds( panelW, panelH)
		--Mr. Roche
		*/
		
		
	}
	

	
	
	

}
