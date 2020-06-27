import java.util.Random;

public class Spawner {
    
    private Handler handler;
    private int scoreKeep = 0;
    Random r = new Random();
    public static int tickNum = 0;

    public static int refreshTick = 0;

    public Spawner(Handler handler){
        this.handler = handler;
       
    }

    public void tick(){
     
    if(tickNum == 0){
        

       // handler.addObject(new Player(0, 0, ID.Player, handler));

        

        // Pakour Objects
       handler.createLevel();
       handler.createLevel1();
    }  

        //handler.createLevel1Pos();    

        if(refreshTick == 60){
       // handler.refreshLevelPos();
        refreshTick = 0;
        }
       // handler.createLevel1();

        tickNum++;
        refreshTick++;

    }
}