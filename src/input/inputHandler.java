package input;

import entities.creature.Player;
import states.GameState;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.Collections;

/**
 * Created by Valentin on 11/6/2015.
 */
public class inputHandler implements KeyListener {

    public static boolean qKey,aKey,eKey,dKey ;
    public static boolean check;
    public static boolean checkTest =true;


    private Thread thread;

    public inputHandler (JFrame frame){

        frame.addKeyListener(this);
    }



    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_Q){

            qKey = true;
            check=true;
        }
        if (keyCode == KeyEvent.VK_A){
            aKey = true;
            check=true;
        }
        if (keyCode == KeyEvent.VK_E){
            eKey = true;
            check=true;
        }
        if (keyCode == KeyEvent.VK_D){
            dKey = true;
            check=true;
        }

    }


    @Override
    public void keyReleased(KeyEvent e) {


        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_Q){
            qKey = false;
            checkTest=false;

            Collections.shuffle(GameState.punches);

            System.out.println(GameState.punches.get(0));

            if (GameState.nakovPunchQ==true ||
                    GameState.nakovPunchA ==true||
                    GameState.nakovPunchE ==true||
                    GameState.nakovPunchD ==true){
                GameState.nakovPunchQ=false;
                GameState.nakovPunchA=false;
                GameState.nakovPunchE=false;
                GameState.nakovPunchD=false;
            }
            switch (GameState.punches.get(0)) { //bad punches
                case "q":

                    GameState.nakovPunchQ =true;

                    break;
                case "a":
                    GameState.nakovPunchA =true;

                    break;
                case "e":
                    GameState.nakovPunchE =true;

                    break;
                case "d":
                    GameState.nakovPunchD =true;

                    break;
            }

            try {
                thread.sleep(5);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            checkTest=true;
            check=false;

        }
        if (keyCode == KeyEvent.VK_A){
            aKey = false;
            checkTest=false;
            Collections.shuffle(GameState.punches);

            System.out.println(GameState.punches.get(0));

            if (GameState.nakovPunchQ==true ||
                    GameState.nakovPunchA ==true||
                    GameState.nakovPunchE ==true||
                    GameState.nakovPunchD ==true){
                GameState.nakovPunchQ=false;
                GameState.nakovPunchA=false;
                GameState.nakovPunchE=false;
                GameState.nakovPunchD=false;
            }
            switch (GameState.punches.get(0)) { //bad punches
                case "q":

                    GameState.nakovPunchQ =true;

                    break;
                case "a":
                    GameState.nakovPunchA =true;

                    break;
                case "e":
                    GameState.nakovPunchE =true;

                    break;
                case "d":
                    GameState.nakovPunchD =true;

                    break;
            }


            try {
                thread.sleep(5);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            check=false;
            checkTest=true;
        }
        if (keyCode == KeyEvent.VK_E){
            eKey = false;
            checkTest=false;
            Collections.shuffle(GameState.punches);

            System.out.println(GameState.punches.get(0));

            if (GameState.nakovPunchQ==true ||
                    GameState.nakovPunchA ==true||
                    GameState.nakovPunchE ==true||
                    GameState.nakovPunchD ==true){
                GameState.nakovPunchQ=false;
                GameState.nakovPunchA=false;
                GameState.nakovPunchE=false;
                GameState.nakovPunchD=false;
            }
            switch (GameState.punches.get(0)) { //bad punches
                case "q":

                    GameState.nakovPunchQ =true;

                    break;
                case "a":
                    GameState.nakovPunchA =true;

                    break;
                case "e":
                    GameState.nakovPunchE =true;

                    break;
                case "d":
                    GameState.nakovPunchD =true;

                    break;
            }


            try {
                thread.sleep(5);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            checkTest=true;
            check=false;
        }
        if (keyCode == KeyEvent.VK_D){
            dKey = false;
            checkTest=false;
            Collections.shuffle(GameState.punches);

            System.out.println(GameState.punches.get(0));


            if (GameState.nakovPunchQ==true ||
                    GameState.nakovPunchA ==true||
                    GameState.nakovPunchE ==true||
                    GameState.nakovPunchD ==true){
                GameState.nakovPunchQ=false;
                GameState.nakovPunchA=false;
                GameState.nakovPunchE=false;
                GameState.nakovPunchD=false;
            }
            switch (GameState.punches.get(0)) { //bad punches
                case "q":

                    GameState.nakovPunchQ =true;

                    break;
                case "a":
                    GameState.nakovPunchA =true;

                    break;
                case "e":
                    GameState.nakovPunchE =true;

                    break;
                case "d":
                    GameState.nakovPunchD =true;

                    break;
            }

            try {
                thread.sleep(5);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            checkTest=true;
            check=false;
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
