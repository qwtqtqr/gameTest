import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.io.BufferedReader;
import java.io.File; 
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;   

public class Edit extends MouseAdapter{

    private Game game;
    private Handler handler;
    public static boolean buttonColorBlue = false;
    public static boolean mouseP = false;
    public static int count = 0;

    public Edit(Game game, Handler handler){
        this.game = game;
        this.handler = handler;  
    }

    public static void writeFile(String count){
        try{
        File fout = new File("objectCount.txt");
        FileOutputStream fos = new FileOutputStream(fout);
     
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            
            bw.write(count);
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void mousePressed(MouseEvent d){

      

       count++;
       mouseP = true;
       String countS = String.valueOf(count);
       
       int mx = d.getX();
       int my = d.getY();

      /* if(mouseOver(mx, my, 25, 20, 100, 50)){
           for(int i = 0; i < handler.object.size(); i++){
               GameObject tempObject = handler.object.get(i);

               if(tempObject.getId() == ID.EditBlock){
                   handler.removeObject(tempObject);
               }
           }
       }*/

       String mxS = String.valueOf(mx);
       String myS = String.valueOf(my);

       String coordinates = mxS + " " + myS;

       int objectX = mx - config.blockWidth / 2;
       int objectY = my - config.blockHeight / 2;
       writeFile(countS);

       try{
        File fout = new File("level1.txt");
        FileOutputStream fos = new FileOutputStream(fout, true);
     
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            
            bw.write(coordinates);
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    
       handler.addObject(new EditBlock(objectX, objectY, ID.Player, handler));

      /* if(mouseOver(mx, my, 25, 20, 100, 50)){
           for(int i = 0; i < handler.object.size(); i++){
               GameObject tempObject = handler.object.get(i);

               if(tempObject.getId() == ID.EditBlock){
                   handler.removeObject(tempObject);
               }
           }
       }*/

    
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
        g.setColor(Color.LIGHT_GRAY);
       /* g.drawRect(25, 20, 100, 50);
        g.drawString("next", 50, 50);*/
        
        fnt = new Font("arial", 1, 30);
        g.setColor(Color.WHITE);
        g.setFont(fnt);
        
    }

    public void tick(){
    }
}