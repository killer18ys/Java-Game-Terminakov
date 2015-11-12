package states;

import Game.GameEngine;
import entities.creature.Enemy;
import entities.creature.Player;
import gfx.Assets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Created by Valentin on 11/6/2015.
 */
public class GameState extends State {


    public static Random rand = new Random();
    public static boolean hit= false;
    public Player player;
    public Player enemyPlayer;
    public static List<String> punches = Arrays.asList("q","a","e","d");

    public static int playerDamage = 3;
    public static int enemyDamage =2;
    public static int level =0;

    public static boolean nakovPunchQ;
    public static boolean nakovPunchA;
    public static boolean nakovPunchE;
    public static boolean nakovPunchD;

    public static int nakovHealth = 100;
    public static int playerHealth = 100;
    public static boolean changeGameState =false;

    Action restartAction = new AbstractAction("Restart"){
        public void actionPerformed(ActionEvent ae){
            try{
                new File("restart").createNewFile();
                System.exit(0);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    };






    public GameState(GameEngine gameEngine) {
        super(gameEngine);

        this.player = new Player(350,600,100,100);
        this.enemyPlayer = new Player(350,600,100,100);
    }

    @Override
    public void tick() {
    this.player.tick();
    this.enemyPlayer.tick();

        if (MenuState.changeGameState==true)
        {
            MenuState.changeGameState=false;
        }

        if (GameEngine.inputHandler.checkTest==false){ //remove the nakov health if hit

            if (player.temp==Assets.nakovpunch){

                playerHealth=playerHealth-enemyDamage;

            }

            else{

                nakovHealth=nakovHealth-playerDamage;

            }


        }

    }




    @Override
    public void render(Graphics g) {




        if (GameEngine.inputHandler.check==false){


            hit = false;
            g.drawImage(Assets.fightStance,90,168,null);


        }
        else{
            hit = true;


                g.drawImage(player.temp, 90, 168, null);



        }


        if (nakovHealth<=0){

            this.player.render(g);
            g.setFont(new Font("Arial", Font.BOLD,18));
            g.setColor(Color.RED);
            g.drawString("Terminakov is defeated, stop beating him ", 40, 20);
            g.drawString("Level: ", 60, 20);

            nakovHealth=100;
            playerHealth=100;
            enemyDamage=enemyDamage+level;
            level++;

        } else {

            this.player.render(g);
            g.setFont(new Font("Arial", Font.BOLD, 18));
            g.setColor(Color.BLACK);
            g.drawString("Terminakov Health: " + nakovHealth, 230, 20);
        }
        if (playerHealth<=0){

            g.drawImage(Assets.clear, 0, 0, null);

            this.enemyPlayer.render(g);
            g.setFont(new Font("Arial", Font.BOLD,50));
            g.setColor(Color.RED);
            g.drawString("You are defeated" , 20,80);

            g.setFont(new Font("Arial", Font.BOLD,20));
            g.drawString("Congrats! You reached level: "+level,80,180);

            changeGameState=true;
        }
            else {
            this.enemyPlayer.render(g);
            g.setFont(new Font("Arial", Font.BOLD,18));
            g.setColor(Color.BLACK);
            g.drawString("Nakov Health: " + playerHealth, 10,20);
            g.drawString("Level: "+level, 350, 50);

        }








    }
}
