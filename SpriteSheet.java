import java.awt.image.*;


class SpriteSheet {
    
    private BufferedImage imgage;

    public SpriteSheet(BufferedImage image){
        this.imgage = image;
    }

    public BufferedImage grabImage(int col, int row, int width, int height){
        BufferedImage img = imgage.getSubimage((col * width) - width,(row * height) - height , width, height);

        return img;
    }
}