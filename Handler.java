import java.util.LinkedList;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Graphics2D;

public class Handler {

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
}