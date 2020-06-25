public class Spawner {
    
    private int tickCount = 0;
    Handler handler;

    public void tick(){
        
        if(tickCount == 0){
            handler.addObject(new Player(0, 0, ID.Player, handler));
        }

        tickCount++;
    }
}