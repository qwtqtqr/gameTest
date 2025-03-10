import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.*;


public class Game extends Canvas implements Runnable{
    private static final long serialVersionUID = 2345455534344003453l;

    
    private Thread thread;
    private boolean running = false;
    Handler handler;
    GameObject object;
    Random r = new Random();
    Edit edit;
    Spawner spawner;
    static Texture tex;
    private Menu menu = new Menu(this, handler);

    

    public enum STATE{
        Menu,
        Game, 
        GameOver,
        Edit,

    }

    public static STATE gameState = STATE.Edit;

    public Game(){
       
        handler = new Handler();
        tex = new Texture();
        new Window(config.windowWidth, config.windowHeight, "GAME", this);
        edit = new Edit(this, handler);
        this.addKeyListener(new KeyInput(handler));
        if(gameState == STATE.Menu){
            this.addMouseListener(menu);
        }
        if(gameState == STATE.Edit){
        this.addMouseListener(edit);
        }
        spawner = new Spawner(handler);
        
    }

  

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop(){
       try {
           thread.join();
           running = false;
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running){
                render();
                frames++;
            }
            if(System.currentTimeMillis() - timer > 1000){
            timer += 1000;
            System.out.println("FPS: " + frames);
            frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        handler.tick();
        if(gameState == STATE.Game){
        spawner.tick();
        }
        if(gameState == STATE.Menu){
            menu.tick();
        }
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;        
        }
        Graphics g = bs.getDrawGraphics();

        if(gameState == STATE.Game){

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, config.windowWidth, config.windowHeight);
       // g.drawImage(tex.backgroundImg[0], 0, 0, null);
        }
        handler.render(g);
        

        if(gameState == STATE.Menu){
            menu.render(g);
        }


       if(gameState == STATE.Edit){
           edit.render(g);
       }
       
        
        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max){
        if(var >= max){
            return var = max;
        }
        else if(var <= min){
            return var = min;
        }
        else{
            return var;
        }
    }


    public static Texture getInstance(){
        return tex;
    }

    public static void main(String[] args) {
       new Game();
    }
}