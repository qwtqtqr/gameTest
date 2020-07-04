import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {
    public static boolean gameState = true;
    private Handler handler;
    private Game game;
    public static boolean jump = false;
    public static int jumpCount = 0;
    public static int speed = 0;

    private int escapeCount = 0;

    private boolean[] keyDown = new boolean[4];
    private boolean[] keyDown2 = new boolean[4];

    public KeyInput(Handler handler){
        this.handler = handler;

        keyDown[0] = false;  //W
        keyDown[1] = false;  //S
        keyDown[2] = false;  //A
        keyDown[3] = false;  //D


        keyDown2[0] = false;  //up
        keyDown2[1] = false;  //down
        keyDown2[2] = false;  //left
        keyDown2[3] = false;  //right
    }
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
    

        int defaultSpeedXPlayer1 = config.player1XSpeed;
        int defaultSpeedYPlayer1 = config.player1YSpeed;

       
        if(key == KeyEvent.VK_ESCAPE){    // esc
            escapeCount++;
            if(escapeCount % 2 != 0){
                Game.gameState = Game.STATE.Menu;
            }
            else{
               Game.gameState = Game.STATE.Game;
            }

            //escapeCount++;
        }


        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player || tempObject.getId() == ID.Block){
                // key events for Player1
                if(key == KeyEvent.VK_SPACE && Player.tickCount__ > 80 && Player.tickCount > 80){
                    Player.fall = true;
                    Player.jumping = true;
                    Player.g = false;
                    Player.yVel_ = - 10;
                    Player.tickCount__ = 0;
                    Player.jumpFromObject = true;
                }
                if(tempObject.getId() == ID.Block){
                if(key == 65){  // A

                    if(Player.movingA == true){
                   
                    {tempObject.setVelX(defaultSpeedXPlayer1);
                    tempObject.setVelY(0); keyDown[2] = true;}
                    }
            
                }
                }
                if(tempObject.getId() == ID.Block){
                if(key == 68){  // D
                    if(Player.movingD == true){     
                                      
                    {tempObject.setVelX(-defaultSpeedXPlayer1);
                    tempObject.setVelY(0); keyDown[3] = true;}
                    }
                }
                }
                }
            }
        }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        int defaultSpeedXPlayer1 = config.player1XSpeed;
        int defaultSpeedYPlayer1 = config.player1YSpeed;

        
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player || tempObject.getId() == ID.Block){

                

                
                // key events for Player1
                    if(key == 87){   // W       
                        keyDown[0] = false;
                    }
        
                
                    else if(key == 83){  // S
                        keyDown[1] = false;

                    }

                    else if(key == KeyEvent.VK_A){
                        keyDown[2] = false;
                    }

                    else if(key == KeyEvent.VK_D){
                        keyDown[3] = false;
                    }
                    
            if(!keyDown[0] && !keyDown[1]){
                tempObject.setVelY(0);
            }
            if(tempObject.getId() == ID.Block){
            if(!keyDown[2] && !keyDown[3]){
                tempObject.setVelX(0);
            }
            }
        
        }
    }
    }
}