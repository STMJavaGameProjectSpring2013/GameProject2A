
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
    
    public DeachoObject(int x, int y){
        super(x,y);
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
        
        
    }
}
