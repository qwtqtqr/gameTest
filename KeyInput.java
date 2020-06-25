import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    public int continousSpeedAll = 5;
    private Handler handler;
    public static int escapeCount = 0;

    public KeyInput(Handler handler){
        this.handler = handler;
    }
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        //System.out.println(key);
        int defaultSpeedAll = continousSpeedAll;

        int defaultSpeedXPlayer1 = defaultSpeedAll;
        int defaultSpeedYPlayer1 = defaultSpeedAll;

        int defaultSpeedXPlayer2 = defaultSpeedAll;
        int defaultSpeedYPlayer2 = defaultSpeedAll;

        /*if(key == KeyEvent.VK_ESCAPE){ 
            if(Game.gameState == Game.STATE.Game || Game.gameState == Game.STATE.Menu){
            // esc
            escapeCount++;
            if(escapeCount % 2 != 0){
                Game.gameState = Game.STATE.Menu;
            }
            else{
               Game.gameState = Game.STATE.Game;
            }
            }
        }*/


        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){
                // key events for Player1
                if(key == 87){   // W         if(key == KeyEvent.VK_W)
                    tempObject.setVelY(- 5);
                    tempObject.setVelX(0);
                }
                else if(key == 83){  // S
                    tempObject.setVelY(5);
                    tempObject.setVelX(0);
                }
                else if(key == 65){  // A
                    tempObject.setVelX(- 5);
                    tempObject.setVelY(0);
                }
                else if(key == 68){  // D
                    tempObject.setVelX(5);
                    tempObject.setVelY(0);
                }
            }
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        int defaultSpeedAll = continousSpeedAll;   // or 0
    
        if(defaultSpeedAll == 0){
           boolean continous = true;
        }
        else {
            boolean continous = false;
        }
        int defaultSpeedXPlayer1 = defaultSpeedAll;
        int defaultSpeedYPlayer1 = defaultSpeedAll;

        int defaultSpeedXPlayer2 = defaultSpeedAll;
        int defaultSpeedYPlayer2 = defaultSpeedAll;


        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){

                
                // key events for Player1
                if(key == 87){   // W         if(key == KeyEvent.VK_W)
                    tempObject.setVelY(- 5);
                    tempObject.setVelX(0);
                }
                else if(key == 83){  // S
                    tempObject.setVelY(5);
                    tempObject.setVelX(0);
                }
                else if(key == 65){  // A
                    tempObject.setVelX(- 5);
                    tempObject.setVelY(0);
                }
                else if(key == 68){  // D
                    tempObject.setVelX(5);
                    tempObject.setVelY(0);
                }
            }
        }
    }
}