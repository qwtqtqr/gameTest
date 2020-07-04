import java.awt.image.*;

public class Texture {
    
    SpriteSheet bs, ps, backS;

    private BufferedImage block_sheet = null;
    private BufferedImage player_sheet = null;
    private BufferedImage background = null;

    public BufferedImage[] block = new BufferedImage[2];
    public BufferedImage[] backgroundImg = new BufferedImage[1];
    public BufferedImage[] Player = new BufferedImage[10];



    public Texture(){


        BufferedImageLoader loader = new BufferedImageLoader();

        try {
            block_sheet = loader.loadImage("/res/block_sheet.png");
            player_sheet = loader.loadImage("/res/player_sheet.png");
           // background = loader.loadImage("/background1080.png");
        } catch (Exception e) {
            e.printStackTrace();
        }

        bs = new SpriteSheet(block_sheet);
        ps = new SpriteSheet(player_sheet);
        backS = new SpriteSheet(background);

        getTextures();
    }

    private void getTextures(){
        block[0] = bs.grabImage(1, 1, 32, 32); // dirt block
        block[1] = bs.grabImage(2, 1, 32, 32); // grass block

      //  backgroundImg[0] = backS.grabImage(1, 1, 1920 , 1080); // background

        Player[0] = ps.grabImage(1, 1, 32, 64);

        

        
        
    }
}