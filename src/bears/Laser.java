/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bears;

import environment.Velocity;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;


/**
 *
 * @author samuelmartinezdelcampo
 */
public class Laser {
    public Laser(Image image, int x, int y, int xVelocity){
        this.image = image;
        this.x = x;
        this.y = y;
        this.xVelocity = xVelocity;
    }
    public void move () {
        setX(getX() + getxVelocity());
    }
    
    private Image image;
    private int x;
    private int y;
    private int xVelocity;
    
   public void draw(Graphics graphics){
       graphics.drawImage(image, getX(), getY(), null);
   }
  
  
    
     public int getxVelocity(){
        return xVelocity;
    }
         
   public void setxVelocity (int xVelocity){
       this.xVelocity = xVelocity;
   }
   public Rectangle rectangle(){
       return new Rectangle(getX(), getY(), image.getWidth(null), image.getHeight(null));
   }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    

}
    

