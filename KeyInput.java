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
        //System.out.println(key);
    

        int defaultSpeedXPlayer1 = config.player1XSpeed;
        int defaultSpeedYPlayer1 = config.player1YSpeed;

       // int defaultSpeedXPlayer2 = config.player2XSpeed;
       // int defaultSpeedYPlayer2 = config.player2YSpeed;

        /*if(key == KeyEvent.VK_ESCAPE){    // esc
            escapeCount++;
            if(escapeCount % 2 != 0){
                Game.gameState = Game.STATE.Menu;
            }
            else{
               Game.gameState = Game.STATE.Game;
            }

            //escapeCount++;
        }*/


        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){
                // key events for Player1
               /* if(key == KeyEvent.VK_SPACE && Player.tickCount__ > 80 && Player.tickCount > 80){
                    Player.fall = true;
                    jump = true;
                    Player.g = false;
                    Player.yVel_ = - 5;
                    Player.tickCount__ = 0;
                    Player.jumpFromObject = true;
                }*/
                if(key == 87){   // W         if(key == KeyEvent.VK_W)
                    {tempObject.setVelY(- defaultSpeedYPlayer1);
                    tempObject.setVelX(0);  keyDown[0] = true;}
                }
                else if(key == 83){  // S
                    {tempObject.setVelY(defaultSpeedYPlayer1);
                    tempObject.setVelX(0); keyDown[1] = true;}
                }
                if(key == 65){  // A
                    {tempObject.setVelX(-defaultSpeedXPlayer1);
                    tempObject.setVelY(0); keyDown[2] = true;}
                }
                
                if(key == 68){  // D
                    if (speed > 5){
                        speed = 5;
                    }
                    {tempObject.setVelX(defaultSpeedXPlayer1);
                    tempObject.setVelY(0); keyDown[3] = true;}
                }
                }
               /* else if(key == 27 && config.stopKey == true){  // esc
                    game.gameState = Game.STATE.Menu;
                }*/
            }
        }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        int defaultSpeedXPlayer1 = config.player1XSpeed;
        int defaultSpeedYPlayer1 = config.player1YSpeed;

        
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){

                
                // key events for Player1
                    if(key == 87){   // W         if(key == KeyEvent.VK_W)
                        //tempObject.setVelY(0);
                        keyDown[0] = false;
                    }
                    //tempObject.setVelX(0);
        
                
                    else if(key == 83){  // S
                        //tempObject.setVelY(0);
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
            if(!keyDown[2] && !keyDown[3]){
                tempObject.setVelX(0);
            }
        
        }
    }
    }
}