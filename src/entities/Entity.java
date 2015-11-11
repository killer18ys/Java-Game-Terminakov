package entities;

import contracts.Updatable;

/**
 * Created by Valentin on 11/6/2015.
 */
public abstract class Entity implements Updatable{

    protected int x,y;
    protected int width, height;
    private int velocity;

    public Entity(int x, int y, int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocity = 3;

    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
}
