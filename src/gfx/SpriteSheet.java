package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Valentin on 11/5/2015.
 */
public class SpriteSheet {

    private BufferedImage sourceImg;

    public SpriteSheet(String path){
        this.sourceImg = ImageLoader.loadImage(path);


    }

    public BufferedImage crop(int x, int y, int width, int height){

        return this.sourceImg.getSubimage(x,y,width,height);
    }

}
