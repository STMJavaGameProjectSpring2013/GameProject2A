
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class DeachoObject extends GameObject {
    
    private int[] octoX,octoY;
    private int sidelength;
    private int xLoc,yLoc;
    
    public DeachoObject(String typeName, int x, int y){
        super(typeName, x,y);
        xLoc=x;
        yLoc=y;
        sidelength=65;
        
        /*THIS NOTE IS TO SAY
         *
         * That we successfully synched stuff.
         * yayyy.
         */
        
        /* Yes -- I think we sync! 
         * --Mr. Roche
         */
        
    }
    public void drawObject(Graphics g){
        g.setColor(new Color(255,69,0));
        g.fillRect(45,55,2*sidelength-10,sidelength);
        g.setColor(Color.BLACK);
        g.drawString("Help,  Help", xLoc-175, yLoc-50);
        g.drawString("I've fallen and I can't" , xLoc-175, yLoc-35);
        g.drawString("get my dx or dy set...", xLoc-175, yLoc-20);
        
    }
}
