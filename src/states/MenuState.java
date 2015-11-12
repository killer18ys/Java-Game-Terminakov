package states;

import Game.GameEngine;
import gfx.Assets;
import states.GameState;

import java.awt.*;

/**
 * Created by Valentin on 11/6/2015.
 */
public class MenuState extends State {
    public static int horizontal = 220;
    public static int vertical = 37;
    public static String optionChoice;
    public static boolean changeGameState=false;

    //37 START
    //82 INSTRUCTIONS
    //122 EXIT


    public MenuState(GameEngine gameEngine){
        super(gameEngine);
    }

    @Override
    public void tick() {
        if (GameState.changeGameState==true)
        {
            GameState.changeGameState=false;
        }


        GameState.nakovHealth =100;
        GameState.playerHealth=100;
        GameState.level=0;
        GameState.enemyDamage =2;

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.menu,0,0,null);
        g.drawImage(Assets.button,horizontal,vertical,null);


        if (GameEngine.inputHandler.qKey){

            if (vertical>37) //if its below START
            {

                if(vertical ==82){ // if ITS INSTRUCTIONS
                    vertical =37;
                    horizontal = 220;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

                else if (vertical ==122){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    horizontal =180;
                    vertical = 82;
                }
            }

        }

        else if (GameEngine.inputHandler.aKey){


            if (vertical==37){
                vertical=82;
                horizontal =180;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            else if (vertical ==82){
                horizontal = 288;
                vertical =122;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        else if (GameEngine.inputHandler.eKey){

            switch ( vertical ) {
                case 37: //start


                        try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                   // g.drawImage(Assets.nakoveasystance, 90, 100, null);

                    changeGameState= true;
                  // StateManager.setCurrentState(new GameState(this));

                    break;
                case 82: //instruction

                        g.drawImage(Assets.instructions,0,0,null);


                    break;
                case 122: //exit
                    System.exit(1);
                    break;

            }

        }

    }
}
