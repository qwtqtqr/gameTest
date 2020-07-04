import java.util.Random;


public class Spawner {
    
    private Handler handler;
    private int scoreKeep = 0;
    Random r = new Random();
    public static int tickNum = 0;
    public static int xCount = 0;

    public static int refreshTick = 0;

    public Spawner(Handler handler){
        this.handler = handler;
       
    }

    public void tick(){
     
    if(tickNum == 0){

        handler.createLevel1Pos();

        if(Game.gameState == Game.STATE.Game){
            handler.addObject(new Player(config.player1XPos, config.player1YPos, ID.Player, handler));
        }
    }
        tickNum++;
        refreshTick++;

    }
}