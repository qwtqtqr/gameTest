import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {

    protected float x;
    protected float y;
    protected ID id;
    protected float velX, velY;        // x and y speed
    protected boolean falling = true;
    protected boolean jumping = false;

    public GameObject(float x, float y, ID id){
        this.x = x; 
        this.y = y;
        this.id = id;
    }

    public abstract void tick(/*LinkedList<GameObject> object*/);
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();


    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void setVelX(int velX){
        this.velX = velX;
    }
    public void setVelY(int velY){
        this.velY = velY;
    }
    public float getVelX(){
        return velX;
    }
    public float getVelY(){
        return velY;
    }
    public void setId(ID id){
        this.id = id;
    }
    public ID getId(){
        return id;
    }
    public boolean isFalling(){
        return falling;
    }
    public void setFalling(boolean falling){
        this.falling = falling;
    }
    public boolean isJumping(){
        return jumping;
    }
    public void setJumping(boolean jumping){
        this.jumping = jumping;
    }
}