package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Valentin on 11/5/2015.
 */
public  class Assets {

    public static SpriteSheet player;
    public static BufferedImage fightStance;
    public static BufferedImage leftlowerpunch;
    public static BufferedImage leftupperpunch;
    public static BufferedImage nakovpunch;
    public static BufferedImage rightlowerpunch;
    public static BufferedImage rightupperpunch;

    public static BufferedImage blk;
    public static BufferedImage rd;
    public static BufferedImage blu;
    public static BufferedImage grn;

    public static void init(){
        player = new SpriteSheet("/images/NakovSpriteTest.png");

        fightStance = ImageLoader.loadImage("/images/fightstance.png");
        leftlowerpunch = ImageLoader.loadImage("/images/leftlowerpunch.png");
        leftupperpunch = ImageLoader.loadImage("/images/leftupperpunch.png");
        nakovpunch = ImageLoader.loadImage("/images/nakovpunch.png");
        rightlowerpunch = ImageLoader.loadImage("/images/rightlowerpunch.png");
        rightupperpunch = ImageLoader.loadImage("/images/rightupperpunch.png");


        blk= ImageLoader.loadImage("/images/blk.png");
        rd = ImageLoader.loadImage("/images/rd.png");
        blu = ImageLoader.loadImage("/images/blu.png");
        grn = ImageLoader.loadImage("/images/grn.png");





                //ImageLoader.loadImage("/images/dickbutt.jpg"),100,100,null);

    }

}
