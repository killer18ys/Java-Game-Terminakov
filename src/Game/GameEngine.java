package Game;

import contracts.Updatable;
import gfx.Assets;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import input.inputHandler;
import states.GameState;
import states.MenuState;
import states.StateManager;

import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Valentin on 11/5/2015.
 */
public class GameEngine implements Runnable , Updatable{
    private Thread thread;
    private Boolean isRunning;

    private GameWindow display;
    private String title;
    private int width,height;

    private Graphics g;
    private BufferStrategy bs;
    public static inputHandler inputHandler;



    private SpriteSheet spriteSheet;
    private GameState currentState ; ///!!!


    public GameEngine (String title,int width,int height){


        this.title = title;
        this.width=width;
        this.height = height;


    }


    private void init(){

        this.display=new GameWindow(this.title,this.width,this.height);
        this.display.getCanvas().createBufferStrategy(2);
        this.bs = this.display.getCanvas().getBufferStrategy();
        this.g = this.bs.getDrawGraphics();
        Assets.init(); // initialasing all the pictures
        this.currentState = new GameState(this); ////!!!!!!
        StateManager.setCurrentState(this.currentState);


            StateManager.setCurrentState(new MenuState(this));



        this.inputHandler=new inputHandler(this.display.getFrame());


       // this.spriteSheet= new SpriteSheet("/images/player.png");
    }

    @Override
    public void tick() {
        if(StateManager.getCurrentState()!=null){

            StateManager.getCurrentState().tick();
        }

        if (MenuState.changeGameState == true){
            StateManager.setCurrentState(new GameState(this));
        }





    }

    @Override
    public void render(Graphics g) {

        g=this.bs.getDrawGraphics();

        g.clearRect(0,0,this.width,this.height); //cleaning the canvas
        //start drawing
        if(StateManager.getCurrentState()!=null){
            StateManager.getCurrentState().render(g);
        }



        //END drawing


        this.bs.show();
        this.g.dispose();

    }

    @Override
    public void run() {
        init();
        while (isRunning){
            try {
                thread.sleep(0);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tick();
            render(this.g);

        }

        stop();


    }

   public synchronized void start(){
        if (this.thread != null){
            return;
        }
        this.isRunning=true;
        this.thread = new Thread(this);
        this.thread.start();

    }

    public synchronized void stop (){

        if (this.thread==null){
            return;
        }
        this.isRunning=false;
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
