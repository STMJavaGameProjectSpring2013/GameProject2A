import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class MrRocheObject extends GameObject {
	
	Image mainImage;
	Image image45;
	Image image135;
	
	boolean pictureLoaded = false;

	public MrRocheObject(int x, int y) {
		super(x, y);
		
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		InputStream input1 = ClassLoader.getSystemResourceAsStream("MrRocheImage1A.png");
		InputStream input2 = cl.getSystemResourceAsStream("MrRocheImage2A.png");
		InputStream input3 = ClassLoader.getSystemResourceAsStream("MrRocheImage8A.png");
		
		
		try{
			
			mainImage = ImageIO.read(input1);
			image45=ImageIO.read(input2);
			image135=ImageIO.read(input3);
			
			objW = mainImage.getWidth(null);
			objH = mainImage.getHeight(null);
			pictureLoaded = true;
			
			this.setBBoxExtras(0, 25, objW, (int)(objH/2)+5);
			
			
		} catch(IOException e){
			System.out.println("We have a problem loading images in MrRoche Object");
			e.printStackTrace();
			
		}
		
	}
	
	public void drawObject(Graphics g){
		
		if(pictureLoaded){
			
			if(getAngle() >29.0 && getAngle() < 61.0){
				g.drawImage(image45, xLoc-(int)(objW/2), yLoc-(int)(objH/2), objW, objH, null);
			} else {
				if(getAngle() >119.0 && getAngle() < 151.0){
					g.drawImage(image135, xLoc-(int)(objW/2), yLoc-(int)(objH/2), objW, objH, null);
				} else {
					g.drawImage(mainImage, xLoc-(int)(objW/2), yLoc-(int)(objH/2), objW, objH, null);
				}
				
			}
			
			g.setColor(Color.RED);
			g.drawRect(xLoc-(int)(objW/2)+bBoxExtraX, yLoc-(int)(objH/2)+bBoxExtraY,bBoxW, bBoxH);
			
			g.setColor(Color.WHITE);
			g.drawString(("Mr.Roche "+whoAmI),  xLoc -(int)(objW/4) , yLoc+(int)(objH/2));
			
		} else {
		g.setColor(objColor);
		g.draw3DRect(xLoc-(int)(objW/2), yLoc-(int)(objH/2), objW, objH, true);
		g.setColor(Color.RED);
		g.fillOval(xLoc-2, yLoc-2, 5, 5);
		
		}
	}
	
	public double getAngle(){
		
		//double radians =  Math.atan2(dy, dx);
		double radians =  Math.atan2(-dy,dx);
		double degrees = (radians * 180)/Math.PI;
		return degrees;
	}
	
	public void setCrazyDX(){
		double dxRate = .005;
		
		changeDX(dxRate);
		if(getDX() > 0){
			if(getDX() > 100){
				dxRate*=-1;
			}
		}
		
		if(getDX() < 0){
			if(getDX() < -100){
				dxRate*=-1;
			}
		}
		
	}
	

}
