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
    public static int enemyDamage = 5;

    public static boolean nakovPunchQ;
    public static boolean nakovPunchA;
    public static boolean nakovPunchE;
    public static boolean nakovPunchD;







    public GameState(GameEngine gameEngine) {
        super(gameEngine);

        this.player = new Player(350,600,100,100);
        this.enemyPlayer = new Player(350,600,100,100);
    }

    @Override
    public void tick() {
    this.player.tick();
    this.enemyPlayer.tick();


        if (GameEngine.inputHandler.checkTest==false){ //remove the nakov health if hit

            if (player.temp==Assets.nakovpunch){
                int currentHealth = this.enemyPlayer.getHealth()-enemyDamage;
                this.enemyPlayer.setHealth(currentHealth);
            }

            else{

                int currentHealth = this.player.getHealth()-playerDamage;
                this.player.setHealth(currentHealth);
                System.out.println(this.player.getHealth());

            }


        }

    }




    @Override
    public void render(Graphics g) {




        if (GameEngine.inputHandler.check==false){


            hit = false;
            g.drawImage(Assets.fightStance,90,100,null);


        }
        else{
            hit = true;


                g.drawImage(player.temp, 90, 100, null);



        }


        if (this.player.getHealth()<=0){

            this.player.render(g);
            g.setFont(new Font("Arial", Font.BOLD,18));
            g.setColor(Color.RED);
            g.drawString("Terminakov is defeated, stop beating him ", 40, 20);
        } else {

            this.player.render(g);
            g.setFont(new Font("Arial", Font.BOLD, 18));
            g.setColor(Color.BLACK);
            g.drawString("Terminakov Health: " + this.player.getHealth(), 230, 20);
        }
        if (this.enemyPlayer.getHealth()<=0){
            this.enemyPlayer.render(g);
            g.setFont(new Font("Arial", Font.BOLD,18));
            g.setColor(Color.RED);
            g.drawString("You are defeated" , 10,20);
        }
            else {
            this.enemyPlayer.render(g);
            g.setFont(new Font("Arial", Font.BOLD,18));
            g.setColor(Color.BLACK);
            g.drawString("Nakov Health: " + this.enemyPlayer.getHealth(), 10,20);

        }








    }
}
