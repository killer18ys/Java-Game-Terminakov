package entities.creature;

import java.awt.*;

/**
 * Created by Valentin on 11/6/2015.
 */
public class Enemy extends creature {
    private final int DEFAULT_DAMAGE=10;

    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);

        this.setCreatureDamage(DEFAULT_DAMAGE);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
