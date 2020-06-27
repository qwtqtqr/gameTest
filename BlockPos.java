import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import java.awt.Rectangle;
import java.awt.Graphics2D;



public class BlockPos extends GameObject {
    
    Random r  = new Random();
    Handler handler;
    public static int X = 0;
    public static int Y = 0;

    public Rectangle getBounds(){
        return null;
    }
    
    public BlockPos(float x, float y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        
    }
        
           
    public void tick(){
    }

    public void render(Graphics g){

    }
}