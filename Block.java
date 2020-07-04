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
    private int spawnNum;
    
    public Block(float x, float y, int type, int spawnNum, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        this.type = type;
        this.spawnNum = spawnNum;
        
    }

    public int getSpawnNum(){
        return this.spawnNum;
    }
        
    public Rectangle getBounds(){
        return (new Rectangle((int)x, (int)y ,config.blockWidth, config.blockHeight));
    }
           
    public void tick(){

        
        x += velX;
        y += velY;
        X = (int) getX();
        Y = (int) getY();
        
    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tObject = handler.object.get(i);
        }
    }


    public void render(Graphics g){
        
        if(type == 0){
            g.drawImage(tex.block[0], (int)x, (int)y, null);  // dirt block
            
        }

        if(type == 1){
            g.drawImage(tex.block[1], (int)x, (int)y, null); // grass block
            
        }
    }
    
}