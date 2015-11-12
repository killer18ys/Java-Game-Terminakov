package states;

/**
 * Created by Valentin on 11/6/2015.
 */
public class StateManager {
    private static State currentState = null;


    public static State getCurrentState(){


        return currentState;

    }

    public static void setCurrentState(State state){

        currentState =state;
    }

}
