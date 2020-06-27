import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


import java.awt.Rectangle;
import java.awt.Graphics2D;



public class Player extends GameObject {
    
    Random r  = new Random();
    Handler handler;
    public static int X = 0;
    public static int Y = 0;
    private float gravity = 1.5f;
    Texture tex = Game.getInstance();

   /* public static int tickCount_= 0;
    public static boolean normalJump = true;
    public static boolean fall = true;
    public static int yVel_ = 0;
    public static int tickCount__ = 0;
    public static int yVel_g = 0;
    public static boolean intersects_ = false;
    public static boolean g = true;
    public static boolean notIntersecting = false;
    public static boolean jumpFromObject = false;
    public static int tickCount = 0;
*/

    public Player(float x, float y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
 
    }
        
    public Rectangle getBounds(){
        return (new Rectangle((int)x, (int)y, config.playerWidth, config.playerHeight));
    }
           
    public void tick(){
        //setFalling(true);

        /*setVelY(yVel_);

        //40
        if(g == true && fall == true && intersects_ == false){
            if(tickCount__ > 6){
                yVel_g++;
                tickCount__ = 0;
                setVelY(yVel_g);
            }
            //setVelY(yVel_g);
        }
        else{
            yVel_g = 0;
        }*/



        x += velX;
        y += velY;
        X = (int) getX();
        Y = (int) getY();


        /*if(intersects_ == true){
            velY = 0;
            g = true;
            notIntersecting = true;
        }*/

        if(falling || jumping){
            velY += gravity;
        }
       /*if(velY > 15){
            velY = 15;
        }*/
       

        if(y <= 0 || y >= config.windowHeight - config.playerHeight - config.blockHeight){
            if(y >= config.windowHeight - config.playerHeight - config.blockHeight){
                velY = 0;
            }
            y = (int) Game.clamp((int)y, 0, config.windowHeight -config.playerHeight - config.blockHeight);
        }
        if(x <= 0 || x >= config.windowWidth - config.playerWidth){
            //velX *= -1;
            x = (int) Game.clamp((int) x, 0, config.windowWidth - config.playerWidth);
        }
        collision();
        /*if(falling || jumping){
            velY += gravity;
        }*/

       /* if(KeyInput.jump == true && fall == true && normalJump == true) {
            if (tickCount_ > 6) {
                yVel_++;
                tickCount_ = 0;
            }
        }*/
        
    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tObject = handler.object.get(i);

            if(tObject.getId() == ID.Block){
                if(getBounds().intersects(tObject.getBounds()) && y <= tObject.getY()){
                    //velX = 0;
                   // normalJump = false;
                    velY = 0;
                    y = (int) Game.clamp((int)y, 0,(int) tObject.getY() - config.playerHeight);

                    //jumping = false;
                    //falling = false;
                }
                else if(getBounds().intersects(tObject.getBounds()) && y >= tObject.getY() - config.blockHeight - 10){
                    velY *= -1;
                    y = (int) Game.clamp((int) y, 0, (int) tObject.getY() + config.blockHeight);
                }
            }
        }
    }


    public void render(Graphics g){
        if(id == ID.Player){
            g.setColor(Color.BLUE);
        }
       // g.fillRect((int) x,(int) y, config.playerWidth, config.playerHeight);
       // g.setColor(Color.BLACK);
       g.drawImage(tex.Player[0], (int)x, (int)y, null);
        
        /*Graphics2D g2d = (Graphics2D) g;
        g2d.draw(getBounds());*/
    }
    
}