import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;


public class Menu extends MouseAdapter{

    private Game game;
    private Handler handler;
    public static boolean buttonColorBlue = false;

    public Menu(Game game, Handler handler){
        this.game = game;
        this.handler = handler;  
    }


    public void mousePressed(MouseEvent e){

       int mx = e.getX();
       int my = e.getY();
       //Play
       if(mouseOver(mx, my, config.windowWidth / 2 - 150, config.windowHeight / 4, 300, 50)){
           game.gameState = Game.STATE.Game;     
           handler.addObject(new Player(config.player1XPos, config.player1YPos, ID.Player, handler));
        }
        if(mouseOver(mx, my, config.windowWidth / 2 - 150, config.windowHeight * 2 / 4 , 300, 50 )){
            game.gameState = Game.STATE.Edit;
        }
        //Quit
        if(mouseOver(mx, my, config.windowWidth / 2 - 150, config.windowHeight * 3 / 4, 300, 50)){
            System.exit(1);
        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx >= x && mx <= x + width){
            if(my >= y && my <= y + height){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public void mouseReleased(MouseEvent e){}

    public void render(Graphics g){
        
        Font fnt = new Font("arial", 1, 25);

        g.setFont(fnt);
        

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, config.windowWidth, config.windowHeight);   // g.drawRect
        g.setColor(Color.WHITE);
        g.drawString("Menu", config.windowWidth / 2 - 30, 50);
        
        fnt = new Font("arial", 1, 30);
        g.setFont(fnt);
        g.drawString("PLAY", config.windowWidth / 2 - 42, config.windowHeight / 4 + 35);
        g.drawString("EDIT", config.windowWidth / 2 - 42, config.windowHeight * 2 / 4 + 35);
        g.drawString("QUIT", config.windowWidth / 2 - 42, config.windowHeight * 3 / 4 + 35);
        g.setColor(Color.WHITE);
        g.setColor(Color.BLUE);
        g.drawRect(config.windowWidth / 2 - 150, config.windowHeight / 4, 300, 50);
        g.drawRect(config.windowWidth / 2 - 150, config.windowHeight * 2 / 4 , 300, 50);
        g.drawRect(config.windowWidth / 2 - 150, config.windowHeight * 3 / 4, 300, 50);
    }

    public void tick(){
    }
}
