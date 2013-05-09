import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class DeachoObject extends GameObject implements ActionListener{
    private Timer swagbot;
    private int[] octoX,octoY;
    private int sidelength;
    private int r,g,b,c;
    public DeachoObject(String typeName, int x, int y){
        super(typeName, x,y);
        r=g=b=0;
        sidelength=65;
        Timer t = new Timer(1,this);
        this.setBBoxExtras(0,0,2*sidelength-11, sidelength+1);
        t.start();
        
    }
    public void drawObject(Graphics gelf){
        gelf.setColor(new Color(r,g,b));
        gelf.fillRect(xLoc,yLoc,2*sidelength-10,sidelength);
        gelf.setColor(Color.blue);
        gelf.drawString("#SWAGBOT2013", xLoc+15, yLoc+sidelength/2);
        gelf.setColor(Color.BLACK);
        
    }

    public void actionPerformed(ActionEvent yolo) {
        if(r<255&&c==1){
            r++;
        }else if(r==255&&g<255&&c==1){
            g++;
        }else if(r==255&&g==255&&b<255&&c==1){
            b++;
        }else if(b<255&&c==0){
            b++;
        }else if(b==255&&g<255&&c==0){
            g++;
        }else if(b==255&&g==255&&r<255&&c==0){
            r++;
        }else if(g<255&&c==2){
            g++;
        }else if(g==255&&r<255&&c==2){
            r++;
        }else if(g==255&&r==255&&b<255&&c==2){
            b++;
        }else if(r==255&&g==255&&b==255){
            r=g=b=0;
           c++;
            if(c>=3){
            c=0;
            }
        }
    }
    
}
