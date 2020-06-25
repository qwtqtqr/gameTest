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


    public Player(float x, float y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
 
    }
        
    public Rectangle getBounds(){
        return (new Rectangle((int)x, (int)y, config.playerWidth, config.playerHeight));
    }
           
    public void tick(){

        x += velX;
        y += velY;
        X = (int) getX();
        Y = (int) getY();
       

        if(y <= 0 || y >= config.windowHeight - config.playerHeight - config.blockHeight){
            velY *= -1;
            y = (int) Game.clamp((int)y, 0, config.windowHeight -config.playerHeight - config.blockHeight);
        }
        if(x <= 0 || x >= config.windowWidth - config.playerWidth){
            velX *= -1;
            x = (int) Game.clamp((int) x, 0, config.windowWidth - config.playerWidth);
        }
        collision();
    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tObject = handler.object.get(i);

            if(tObject.getId() == ID.Block){
                if(getBounds().intersects(tObject.getBounds())){
                    velX *= -1;
                    velY *= -1;
                }
            }
        }
    }


    public void render(Graphics g){
        if(id == ID.Player){
            g.setColor(Color.BLUE);
        }
        g.fillRect((int) x,(int) y, config.playerWidth, config.playerHeight);
        g.setColor(Color.BLACK);
        
        /*Graphics2D g2d = (Graphics2D) g;
        g2d.draw(getBounds());*/
    }
    
}