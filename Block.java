import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import java.awt.Rectangle;
import java.awt.Graphics2D;



public class Block extends GameObject {
    
    Random r  = new Random();
    Handler handler;
    public static int X = 0;
    public static int Y = 0;
    Texture tex = Game.getInstance();
    private int type;
    
    public Block(float x, float y, int type, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        this.type = type;
        /*velX = xSpeed;
        velY = ySpeed;
        //setX((50));*/
    }
        
    public Rectangle getBounds(){
        return (new Rectangle((int)x, (int)y ,config.blockWidth, config.blockHeight));
    }
           
    public void tick(){

        
        x += velX;
        y += velY;
        X = (int) getX();
        Y = (int) getY();
        
        
       // handler.addObject(new Tail(x, y, ID.Tail, Color.BLUE, 16, 16, 0.06f, handler));
        //collision();
    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tObject = handler.object.get(i);
        }
    }


    public void render(Graphics g){
        /*g.setColor(Color.getColor("brown", 5385483));
        g.fillRect((int) x,(int) y, config.blockWidth, config.blockHeight);
        
        /*Graphics2D g2d = (Graphics2D) g;
        g2d.draw(getBounds());*/

        if(type == 0){
            g.drawImage(tex.block[0], (int)x, (int)y, null);  // dirt block
            g.drawImage(tex.block[0], (int)x + 32, (int)y, null);
            g.drawImage(tex.block[0], (int)x + 64, (int)y, null);
            g.drawImage(tex.block[0], (int)x + 96, (int)y, null);
        }

        if(type == 1){
            g.drawImage(tex.block[1], (int)x, (int)y, null); // grass block
            g.drawImage(tex.block[1], (int)x + 32, (int)y, null);
            g.drawImage(tex.block[1], (int)x + 64, (int)y, null);
            g.drawImage(tex.block[1], (int)x + 96, (int)y, null);
        }
    }
    
}