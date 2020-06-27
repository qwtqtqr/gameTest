import java.util.LinkedList;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.*; 
import java.io.FileReader;


public class Handler {

    public static String count = "0";

    public static int spawnCount = 0;
    public static int X = 0;
    public static int Y = 0;
    public static int distance = config.windowWidth;
 
    LinkedList<GameObject> object = new LinkedList<GameObject>();



    public void tick(){

        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }
    // renders all game objects
    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void clearEnemys(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            if(tempObject.getId() == ID.Player){
                object.clear();
                //addObject(new Player(tempObject.getX(), tempObject.getY(), tempObject.getVelX(), tempObject.getVelY(), ID.Player, this));
            }
        }
    }

    public void gameOver(){
        object.clear();
       // addObject(new Player(config.player1XPos, config.player1YPos, config.player1XSpeed, config.player1YSpeed, ID.Player, this));
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }




    public void removeObject(GameObject object){
        this.object.remove(object);
    }

    public void createLevel(){

        for(int xx = 0; xx < config.windowWidth + 32; xx+= config.blockWidth){
            addObject(new Block(xx, config.windowHeight - config.blockHeight, 0, ID.Block, this));
        }
    }

    public int getCounter(){
        try {
            File myObj = new File("objectCount.txt");
            Scanner myReader = new Scanner(myObj);
            count = myReader.next();
           // System.out.println(count);
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int countNum = Integer.parseInt(count);
        return countNum;
    }

    public void createLevel1(){


        try {
            File Obj = new File("level1.txt");
            Scanner myReader = new Scanner(Obj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              String xS = data.substring(0, data.indexOf(" ")).trim();
              String yS = data.substring(data.indexOf(" ")).trim();
              

              int x = Integer.parseInt(xS);
              int y = Integer.parseInt(yS);

              X = x;
              Y = y;

              for(int i = 0; i < getCounter(); i++){
                  addObject(new Block(x, y, 1, ID.Block, this));
              }
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}