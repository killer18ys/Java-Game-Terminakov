package Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Valentin on 11/5/2015.
 */
public class GameWindow extends JFrame{
    private JFrame frame; //putting objects on the windows
    private Canvas canvas; //drawing on the window

    private String title;
    private int width, height;

public GameWindow(String title, int width , int height){

    this.title = title;
    this.width=width;
    this.height=height;

    initFrame();
    initCanvas();
    this.getFrame().add(this.getCanvas());
    this.getFrame().pack();

}

    private void initCanvas() {
        setCanvas(new Canvas());
        this.getCanvas().setPreferredSize(new Dimension(this.width, this.height)); //setting exact size
        this.getCanvas().setMinimumSize(new Dimension(this.width, this.height));
        this.getCanvas().setMaximumSize(new Dimension(this.width, this.height));
        this.getCanvas().setFocusable(false);
    }

    private void initFrame(){
        this.setFrame(new JFrame(this.title));
        this.getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // on X closes the program
        this.getFrame().setSize(this.width, this.height);
        this.getFrame().setVisible(true);
        this.getFrame().setFocusable(true);
        this.getFrame().setResizable(false);
        this.getFrame().setLocationRelativeTo(null); // centers the game


    }


    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
