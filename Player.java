import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import java.awt.Rectangle;


public class Player extends GameObject {
    
    Random r  = new Random();
    Handler handler;
    public static int tickCount_ = 0;
    public static int X = 0;
    public static int Y = 0;
    public static int yVel_ = 0;

    public static boolean jumping = false;

    public static int tickCount__ = 0;

    Texture tex = Game.getInstance();

    public static boolean normalJump = true;
    public static boolean fall = true;
     public static int yVel_g = 0;
    public static boolean intersects_ = false;
    public static boolean g = true;
    public static boolean notIntersecting = false;
    public static boolean jumpFromObject = false;
    public static int tickCount = 0;
    public static int gravity = 1;
    
    public static boolean movingD = true;
    public static boolean movingA = true;

    public static int tCount = 0;


    public Player(float x, float y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        this.y = y;
        velY = 0;
        velX = 0;
        setY(0);
 
    }
        
    public Rectangle getBounds(){
        return (new Rectangle((int)x, (int)y, config.playerWidth, config.playerHeight));
    }
           
    public void tick(){

        movingD = true;
        movingA = true;
        

        if(jumping){
        setVelY( yVel_);
        if(jumping == false){
            setVelY(0);
        }
        velY = yVel_;
        }
        else {
            if(tCount > 2){
                tCount = 0;
                velY += gravity;
                if(getVelX() > 1){
                    velY += gravity * 5;
                    setVelY(50);
                }
            }
        }


        

        x += velX;
        y += velY;
        X = (int) getX();
        Y = (int) getY();

       

        if(y <= 0 || y >= config.windowHeight - config.playerHeight){
            if(y >= config.windowHeight - config.playerHeight - config.blockHeight){
                velY = 0;
            }
            y = (int) Game.clamp((int)y, 0, config.windowHeight -config.playerHeight);
        }
        if(x <= 0 || x >= config.windowWidth - config.playerWidth){
            //velX *= -1;
            x = (int) Game.clamp((int) x, 0, config.windowWidth - config.playerWidth);
        }
        collision();
       

        if(jumping == true){
        if (tickCount_ > 1) {
            yVel_++;
            tickCount_ = 0;
        }
       }
       tickCount++;
       tickCount_++;
       tickCount__++;
       tCount++;
    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tObject = handler.object.get(i);

            if(tObject.getId() == ID.Block){
                if(getBounds().intersects(tObject.getBounds()) && y <= tObject.getY()/* && x > tObject.getX() && x < tObject.getVelX() - config.blockWidth*/){
                    setVelY(0);
                    jumping = false;
                    y = (int) Game.clamp((int)y, 0,(int) tObject.getY() - config.playerHeight);

                }
                else if(getBounds().intersects(tObject.getBounds()) && y >= tObject.getY() - config.blockHeight/* && x > tObject.getX() && x  < tObject.getX() - config.blockWidth*/){
                  //  velY *= -1;
                    y = (int) Game.clamp((int) y,(int) tObject.getY() + config.blockHeight, config.windowHeight -config.playerHeight);
                }

                if(getBounds().intersects(tObject.getBounds()) && x >= tObject.getX() - config.playerWidth){

                   movingD = false;
                  tObject.setX((int) Game.clamp((int) tObject.getX(), (int)x, config.windowWidth));

                    for(int j = 0; j < handler.object.size(); j++){

                        GameObject tempObject = handler.object.get(j);

                        if(tempObject.getId() == ID.Block){
                            
                            tempObject.setVelX(0);
                        }
                    }
                }


                if(getBounds().intersects(tObject.getBounds()) && x <= tObject.getX() + config.blockWidth){

                    movingA = false;
 
                    //tObject.setX((int) Game.clamp((int) tObject.getX() - config.blockWidth, 0, (int)x + config.blockWidth));
 
                     for(int j = 0; j < handler.object.size(); j++){
 
                         GameObject tempObject = handler.object.get(j);
 
                         if(tempObject.getId() == ID.Block){
                             
                            // tempObject.setVelX(0);
                         }
                     }
                 }
            }
        }
    }


    public void render(Graphics g){
        if(id == ID.Player){
            g.setColor(Color.BLUE);
        }
       
       g.drawImage(tex.Player[0], (int)x, (int)y, null);
        
    }
    
}