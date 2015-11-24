/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bears;

import environment.Environment;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 *
 * @author samuelmartinezdelcampo
 */
class Ice extends Environment {

    Grid grid;
    
    int ovalX;
    int ovalY;
    int slideX;
    int slideXX;

    Image bear;
    Image seal;
    Image iceberg;
    
  
  
    
  
    
    

    public Ice() {
        slideX = 900;
        slideXX = 3400;
        ovalX = 100;
        ovalY= 100;
        grid = new Grid(50, 25, 25, 25, new Point(10, 50), Color.PINK);
        bear = ResourceTools.loadImageFromResource("bears/BEAR.gif");
        seal = ResourceTools.loadImageFromResource("bears/SEAl.png");
        iceberg = ResourceTools.loadImageFromResource("bears/iceberg.png");
    }

    @Override
    public void initializeEnvironment() {
        background =ResourceTools.loadImageFromResource("Bears/ICE.png");
        

    }
    Image background;
    int counter;

    @Override
    public void timerTaskHandler() {
        slideX--;
        slideX--;
        slideX--;
        slideX--;
        slideXX--;
        slideXX--;
        slideXX--;        
        slideXX--;



        
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            System.out.println("Go left!");
            ovalX= ovalX - 17;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ovalX= ovalX + 17;
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT + KeyEvent.VK_UP) {
            ovalX= ovalX + 17;
            ovalY= ovalY -17;
//            System.out.println("Go right!");
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            ovalY= ovalY - 17;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            System.out.println("Go down!");
            ovalY = ovalY +17;
        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("Key released - UP");
        }
           if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("Key released - LEFT");
        }   if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("Key released - DOWN");
        }   if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("Key released - RIGHT");
        }
        
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked at " + e.getPoint());
        System.out.println("Mouse clicked in cell " + grid.getCellLocationFromSystemCoordinate(e.getPoint()));
       
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
      graphics.drawImage(background, 0, 0, this);
        if (grid != null) {
            grid.paintComponent(graphics);
       
           
            
        }
        graphics.drawImage(bear, ovalX, ovalY, this);
        graphics.drawImage(seal, slideX, 15, this);
        graphics.drawImage(iceberg, slideX, 55, this);
        graphics.drawImage(seal, slideXX ++, 20, this);
        graphics.drawImage(iceberg, slideXX, 25, this);

        


    }

}
