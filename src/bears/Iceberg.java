/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bears;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Iceberg {
    
    public void draw(Graphics graphics){
     
//        graphics.drawRect(x, y, image.getWidth(null), image.getHeight(null));
        graphics.drawImage(getImage(), x, y, 100, 100,null);
    }
//
    public Iceberg(int x, int y, int xVelocity, Image image){
        this.x = x;
        this.y = y;
        this.xVelocity = xVelocity;
        this.image = image;
    }
    
    public void move () {
        x = x - getxVelocity();
    }
    public Rectangle rectangle(){
        return new Rectangle (x, y, image.getWidth(null), image.getHeight(null));
    }
    
    
    

//<editor-fold defaultstate="collapsed" desc="Properties">
    /**
     * @return the x
     */
    private int x, y, xVelocity;
    private String type;
    private Image image;
    
    
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
    
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }
    
    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }
    
//</editor-fold>

    /**
     * @return the xVelocity
     */
    public int getxVelocity() {
        return xVelocity;
    }

    /**
     * @param xVelocity the xVelocity to set
     */
    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }
         
   
}
    

