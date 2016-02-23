/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bears;

import audio.AudioPlayer;
import environment.Environment;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author samuelmartinezdelcampo
 */
class Ice extends Environment implements CellDataProviderIntf {

    Grid grid;

    int ovalX;
    int ovalY;
    int slideX;
    int slideXX;
    int laserX;
    int laserY;
    int icebergHealth;
    
    Image bear;
    Image seal;
    Image iceberg;
    Image laser;
    Image startscreen;
    Image gameover;

    private ArrayList<Barrier> barriers;
    private ArrayList<Seal> items;
    private ArrayList<Iceberg> icebergs;
    private ArrayList<Seal> seals;
    private ArrayList<Laser> lasers;
    private int score;
    private int health;

    public Ice() {
        health = 3;
        ovalX = 100;
        ovalY = 100;
        laserX = ovalX;
        laserY = ovalY;
        grid = new Grid(20, 12, 50, 50, new Point(0, 0), Color.black);
        bear = ResourceTools.loadImageFromResource("bears/BEAR.gif");
        laser = ResourceTools.loadImageFromResource("bears/laser.png");

        seal = ResourceTools.loadImageFromResource("bears/SEAl.png");
        iceberg = ResourceTools.loadImageFromResource("bears/iceberg.png");

        //<editor-fold defaultstate="collapsed" desc="barriers">
        barriers = new ArrayList<>();
        barriers.add(new Barrier(-1, 0, Color.BLACK, this));
        barriers.add(new Barrier(-1, 1, Color.BLACK, this));
        barriers.add(new Barrier(-1, 2, Color.BLACK, this));
        barriers.add(new Barrier(-1, 3, Color.BLACK, this));
        barriers.add(new Barrier(-1, 4, Color.BLACK, this));
        barriers.add(new Barrier(-1, 5, Color.BLACK, this));
        barriers.add(new Barrier(-1, 6, Color.BLACK, this));
        barriers.add(new Barrier(-1, 7, Color.BLACK, this));
        barriers.add(new Barrier(-1, 8, Color.BLACK, this));
        barriers.add(new Barrier(-1, 9, Color.BLACK, this));
        barriers.add(new Barrier(-1, 10, Color.BLACK, this));
        barriers.add(new Barrier(-1, 11, Color.BLACK, this));
        barriers.add(new Barrier(0, -1, Color.BLACK, this));
        barriers.add(new Barrier(1, -1, Color.BLACK, this));
        barriers.add(new Barrier(2, -1, Color.BLACK, this));
        barriers.add(new Barrier(3, -1, Color.BLACK, this));
        barriers.add(new Barrier(4, -1, Color.BLACK, this));
        barriers.add(new Barrier(5, -1, Color.BLACK, this));
        barriers.add(new Barrier(6, -1, Color.BLACK, this));
        barriers.add(new Barrier(7, -1, Color.BLACK, this));
        barriers.add(new Barrier(8, -1, Color.BLACK, this));
        barriers.add(new Barrier(9, -1, Color.BLACK, this));
        barriers.add(new Barrier(10, -1, Color.BLACK, this));
        barriers.add(new Barrier(11, -1, Color.BLACK, this));
        barriers.add(new Barrier(12, -1, Color.BLACK, this));
        barriers.add(new Barrier(13, -1, Color.BLACK, this));
        barriers.add(new Barrier(14, -1, Color.BLACK, this));
        barriers.add(new Barrier(15, -1, Color.BLACK, this));
        barriers.add(new Barrier(16, -1, Color.BLACK, this));
        barriers.add(new Barrier(17, -1, Color.BLACK, this));
        barriers.add(new Barrier(18, -1, Color.BLACK, this));
        barriers.add(new Barrier(19, -1, Color.BLACK, this));
        barriers.add(new Barrier(20, -1, Color.BLACK, this));
        barriers.add(new Barrier(21, -1, Color.BLACK, this));
        barriers.add(new Barrier(22, -1, Color.BLACK, this));
        barriers.add(new Barrier(20, 0, Color.BLACK, this));
        barriers.add(new Barrier(20, 1, Color.BLACK, this));
        barriers.add(new Barrier(20, 2, Color.BLACK, this));
        barriers.add(new Barrier(20, 3, Color.BLACK, this));
        barriers.add(new Barrier(20, 4, Color.BLACK, this));
        barriers.add(new Barrier(20, 5, Color.BLACK, this));
        barriers.add(new Barrier(20, 6, Color.BLACK, this));
        barriers.add(new Barrier(20, 7, Color.BLACK, this));
        barriers.add(new Barrier(20, 8, Color.BLACK, this));
        barriers.add(new Barrier(20, 9, Color.BLACK, this));
        barriers.add(new Barrier(20, 10, Color.BLACK, this));
        barriers.add(new Barrier(20, 11, Color.BLACK, this));
        barriers.add(new Barrier(20, 12, Color.BLACK, this));
        barriers.add(new Barrier(0, 12, Color.BLACK, this));
        barriers.add(new Barrier(1, 12, Color.BLACK, this));
        barriers.add(new Barrier(2, 12, Color.BLACK, this));
        barriers.add(new Barrier(3, 12, Color.BLACK, this));
        barriers.add(new Barrier(4, 12, Color.BLACK, this));
        barriers.add(new Barrier(5, 12, Color.BLACK, this));
        barriers.add(new Barrier(6, 12, Color.BLACK, this));
        barriers.add(new Barrier(7, 12, Color.BLACK, this));
        barriers.add(new Barrier(8, 12, Color.BLACK, this));
        barriers.add(new Barrier(9, 12, Color.BLACK, this));
        barriers.add(new Barrier(10, 12, Color.BLACK, this));
        barriers.add(new Barrier(11, 12, Color.BLACK, this));
        barriers.add(new Barrier(12, 12, Color.BLACK, this));
        barriers.add(new Barrier(13, 12, Color.BLACK, this));
        barriers.add(new Barrier(14, 12, Color.BLACK, this));
        barriers.add(new Barrier(15, 12, Color.BLACK, this));
        barriers.add(new Barrier(16, 12, Color.BLACK, this));
        barriers.add(new Barrier(17, 12, Color.BLACK, this));
        barriers.add(new Barrier(18, 12, Color.BLACK, this));
        barriers.add(new Barrier(19, 12, Color.BLACK, this));
        barriers.add(new Barrier(20, 12, Color.BLACK, this));
//</editor-fold>

        icebergs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            icebergs.add(new Iceberg(getRandomValue(2000, 2300), getRandomValue(50, 400), getRandomValue(1, 5), iceberg));
        }
//         seals = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            seals.add(new sea(getRandomValue(700, 950), getRandomValue(50, 400), getRandomValue(1, 5), iceberg));
//        }
        seals = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            seals.add(new Seal(getRandomValue(10, 750), getRandomValue(50, 400), getRandomValue(1, 3), seal));
        }
        lasers = new ArrayList<>();
    }

    public int getRandomValue(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

//    
    @Override
    public void initializeEnvironment() {
        background = ResourceTools.loadImageFromResource("Bears/ICE.png");

    }
    Image background;
    int counter;

    @Override
    public void timerTaskHandler() {

        checkIntersection();
        System.out.println(health);

        if (icebergs != null) {
            for (Iceberg iceberg : icebergs) {
                //if the iceberg is off the screen to the the LEFT, then
                //   - give it a NEW random velocity
                //   - give it a new random x & y value
                if (iceberg.getX() < -60) {
                    iceberg.setX(getRandomValue(1000, 1400));
                    iceberg.setY(getRandomValue(50, 550));
                    iceberg.setxVelocity(getRandomValue(3, 11));
                    score++;
                    score++;
                    score++;
                    score++;
                    score++;
                    score++;
                    score++;
                    score++;
                    score++;
                    score++;
                }

                iceberg.move();

            }
            if (lasers != null) {
                for (Laser laser : lasers) {
                    laser.move();
                }
            }
        }

        if (seals != null) {
            for (Seal seal : seals) {
                //if the iceberg is off the screen to the the LEFT, then
                //   - give it a NEW random velocity
                //   - give it a new random x & y value
                if (seal.getY() < -60) {
                    seal.setX(getRandomValue(10, 650));
                    seal.setY(getRandomValue(950, 1550));
                    seal.setyVelocity(getRandomValue(1, 3));
                }

                seal.move();

            }
        }

    }

    @Override
    public void keyPressedHandler(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            System.out.println("Go left!");
            ovalX = ovalX - 17;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ovalX = ovalX + 17;
        } //            System.out.println("Go right!");
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            ovalY = ovalY - 17;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            System.out.println("Go down!");
            ovalY = ovalY + 17;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            AudioPlayer.play("/bears/Laser.wav");
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (health <= 1) {
            lasers.add(new Laser(laser, ovalX, ovalY, 60));
        }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (health <= 0) {
                ovalX = 0;
                ovalY = 0;
                score = 0;
                health = 3;
            }
        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("Key released - UP");
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("Key released - LEFT");
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("Key released - DOWN");
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
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

        if (lasers != null) {
            for (Laser laser : lasers) {
                laser.draw(graphics);
            }
        }

        if (icebergs != null) {
            for (Iceberg iceberg : icebergs) {
                iceberg.draw(graphics);
            }
        }
        if (seals != null) {
            for (Seal seal : seals) {
                seal.draw(graphics);
            }
        }

        if (items != null) {
            for (int i = 0; i < items.size(); i++) {
                items.get(i).draw(graphics);
            }
        }

        if (health >= 0) {
            if (bear != null) {
                graphics.drawImage(bear, ovalX, ovalY, this);
            }
        }//       graphics.drawImage(seal, slideX, 15, this);
//        graphics.drawImage(icebergs, slideX, 55, this);
////        graphics.drawImage(seal, slideXX++, 20, this);
//        graphics.drawImage(icebergs, slideXX, 25, this);
        if (barriers != null) {
            for (int i = 0; i < barriers.size(); i++) {

                barriers.get(i).draw(graphics);
            }
        }

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Calibri", Font.BOLD, 35));
        graphics.drawString("Score: " + score, 10, 40);

        graphics.setColor(Color.red);
        graphics.setFont(new Font("Calibri", Font.BOLD, 25));
        graphics.drawString("Health: " + health, 800, 40);

//        graphics.drawRect(ovalX, ovalY, bear.getWidth(null), bear.getHeight(null));
    }

    public void checkIntersection() {
        if (bear != null) {
            if (seals != null) {
                for (Seal seal : seals) {
                    if (rectangle().intersects(seal.rectangle())) {
                        health += 1;
                        //moveiceberg
                        seal.setY(-1000);
                    }

                }
            }
        }

        if (icebergs != null) {
            for (Iceberg iceberg : icebergs) {
                if (rectangle().intersects(iceberg.rectangle())) {
                    health -= 1;
                    //moveiceberg
                    iceberg.setX(getRandomValue(1000, 1400));
                    iceberg.setY(getRandomValue(50, 550));
                    iceberg.setxVelocity(getRandomValue(3, 14));
                }
                for (Laser laser : lasers) {
                    if (iceberg.rectangle().intersects(laser.rectangle())) {
                        icebergHealth = icebergHealth - 1;
                        iceberg.setX(getRandomValue(1000, 1400));
                    iceberg.setY(getRandomValue(50, 550));
                    iceberg.setxVelocity(getRandomValue(3, 14));
                        laser.setX(1000);
                        laser.setY(-1000);
                    }
                }

            }
        }
        
    }

    @Override
    public int getCellWidth() {
        return grid.getCellWidth();
    }

    @Override
    public int getCellHeight() {
        return grid.getCellHeight();
    }

    @Override
    public int getSystemCoordX(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).x;
    }

    @Override
    public int getSystemCoordY(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).y;

    }

//    @Override
////    public Point validateMove(Point proposedLocation) {
////        if(proposedLocation.x < 0){
////            proposedLocation.x = grid.getColumns() - 1;
////        }else if(proposedLocation. > grid.getColumns() - 1){
////            proposedLocation.x = 0;
////        } if (proposedLocation.y < 0){
////            proposedLocation.y = grid.getRows() - 1;
////        }
////        return proposedLocation;
////        
////    
//
//    }
    public Rectangle rectangle() {
        return new Rectangle(ovalX, ovalY, bear.getWidth(null), bear.getHeight(null));
    }

}
//</editor-fold>
