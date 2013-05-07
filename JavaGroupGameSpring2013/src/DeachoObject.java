
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
    
    public DeachoObject(String typeName, int x, int y){
        super(typeName, x,y);
        sidelength=65;
        
        this.setBBoxExtras(0,0,2*sidelength-11, sidelength+1);

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
        g.fillRect(xLoc,yLoc,2*sidelength-10,sidelength);
        g.setColor(Color.blue);
        g.drawString("#SWAGBOT2013", xLoc+15, yLoc+sidelength/2);
        g.setColor(Color.BLACK);
        
    }
}
