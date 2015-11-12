package states;

import Game.GameEngine;
import contracts.Updatable;

public abstract class State implements Updatable {

protected GameEngine game;

    public State(GameEngine game){
        this.game=game;
    }




}
