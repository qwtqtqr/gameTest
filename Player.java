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
        /*velX = xSpeed;
        velY = ySpeed;
        //setX((50));*/
    }
        
    public Rectangle getBounds(){
        return (new Rectangle((int)x, (int)y, 16, 16));
    }
           
    public void tick(){

        setVelX(5);
        setVelY(5);
        x += velX;
        y += velY;
        X = (int) getX();
        Y = (int) getY();
        
        if(y <= 50 || y >= config.windowHeight - 55){
            velY *= - 1;
            y = Game.clamp((int) y, 50, config.windowHeight - 55);
        }
        if(x <= 0 || x >= config.windowWidth - 32){
            velX *= - 1;
            x = Game.clamp((int) x, 0, config.windowWidth- 32);
        }
       // handler.addObject(new Tail(x, y, ID.Tail, Color.BLUE, 16, 16, 0.06f, handler));
        //collision();
    }

   /* private void collision(){
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tObject = handler.object.get(i);

            if(tObject.getId() == ID.BasicEnemy || tObject.getId() == ID.fastEnemy || tObject.getId() == ID.bossBullets || tObject.getId() == ID.newEnemy){
                if(getBounds().intersects(tObject.getBounds())){
                    HUD.HEALTH -= config.damage;
                    velX *= -1;
                    velY *= -1;
                    if(HUD.HEALTH == 0){
                        Game.gameState = Game.STATE.GameOver;
                    }
                }
            }
        }
    }*/


    public void render(Graphics g){
        if(id == ID.Player){
            g.setColor(Color.BLUE);
        }
        g.fillRect((int) x,(int) y, 16, 16);
        g.setColor(Color.BLACK);
        
        /*Graphics2D g2d = (Graphics2D) g;
        g2d.draw(getBounds());*/
    }
    
}