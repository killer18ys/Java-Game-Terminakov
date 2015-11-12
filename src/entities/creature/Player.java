package entities.creature;

import Game.GameEngine;
import gfx.Assets;
import states.GameState;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Valentin on 11/6/2015.
 */
public class Player extends creature {


    public static BufferedImage temp;

    public static boolean hit= false;

    private final int DEFAULT_DAMAGE=10;
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);

        this.setCreatureDamage(DEFAULT_DAMAGE);
    }

    @Override
    public void tick() {


    if (GameEngine.inputHandler.qKey){


        if (GameState.nakovPunchQ){
            temp=Assets.nakovpunch;

        }

        else {
            temp = Assets.leftupperpunch;
        }


    }

        if (GameEngine.inputHandler.aKey){

            if (GameState.nakovPunchA){
                temp=Assets.nakovpunch;

            }

            else {
                temp = Assets.leftlowerpunch;
            }


        }
        if (GameEngine.inputHandler.eKey){

            if (GameState.nakovPunchE){
                temp=Assets.nakovpunch;

            }

            else {
                temp = Assets.rightupperpunch;
            }
        }
        if (GameEngine.inputHandler.dKey){

            if (GameState.nakovPunchD){
                temp=Assets.nakovpunch;


            }


            else {
                temp = Assets.rightlowerpunch;
            }


        }


    }

    @Override
    public void render(Graphics g) {



      // if (GameEngine.inputHandler.check==false){

         //  hit = false;
          // g.drawImage(Assets.fightStance,90,100,null);
      // }
       //     else{
//
       //    hit = true;
      //     g.drawImage(temp, 90, 100, null);
       }




    }

