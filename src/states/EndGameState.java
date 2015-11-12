package states;

import Game.GameEngine;

import java.awt.*;

/**
 * Created by Valentin on 11/6/2015.
 */
public class EndGameState extends State {

    public EndGameState(GameEngine gameEngine){
        super(gameEngine);
    }
    public static boolean changeGameState =false;
    @Override
    public void tick() {
        if (GameState.changeGameState==true)
        {
            GameState.changeGameState=false;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD,18));
        g.setColor(Color.RED);
        g.drawString("You are defeated" , 10,20);
    }
}
