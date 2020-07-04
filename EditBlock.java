import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Rectangle;
import java.awt.Graphics2D;



public class EditBlock extends GameObject {
    
    Random r  = new Random();
    Handler handler;
    public static int X = 0;
    public static int Y = 0;
    private Texture tex = Game.getInstance();

    public EditBlock(float x, float y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
    }
        
    public Rectangle getBounds(){
        return (new Rectangle((int)x, (int)y ,config.blockWidth, config.blockHeight));
    }
           
    public void tick(){

        
        X = (int) getX();
        Y = (int) getY();
    }

    

    public void render(Graphics g){
        if(Game.gameState == Game.STATE.Edit){
       /* g.setColor(Color.getColor("brown", 5385483));
        g.fillRect((int) x,(int) y, config.blockWidth, config.blockHeight);*/

        g.drawImage(tex.block[1], (int)x,(int)y, null);
        
        }
    }
    
}