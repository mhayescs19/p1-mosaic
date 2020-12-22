package Panel;

import Main.SimControl;
import View.ViewForPaint;


import javax.swing.*;
import java.awt.*;

public class Painter extends Panel{
    private ViewForPaint view = new ViewForPaint();
    public boolean quit = false;
    static final String name_of_panel = "Population sim";
    JFrame jFrame;
    SimControl simControl;
    Timer timer; //like objective c timer loops and does stuff every set interval
    double Time = 0; // will be used to track how long the program has been running
    public Painter(SimControl sim) // need panel
    {
        this.simControl = sim; // pass the simControl in a parameter
        jFrame = new JFrame(name_of_panel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.add(this); // add this class to the Jframe
    }
    //starts the painting process

    /**
     * this will set up the timer
     * @see Panel
     */
    public void Start()
    {
        int temp = 16; // will be replace by a dynamic var from sim control, represents delay for timer
        timer = new Timer(temp,this); // temp is delay is milliseconds, this is the class that implements the action listen
        timer.start(); // starts the timer
        jFrame.setVisible(true); // not sure if this is necessary  but want to make sure that the jpanel is updated with the timer and paint
    }


    @Override //master paint class
    public void paint(Graphics g) {
            // add paint stuff
            Time += 16; // constant will change this
        view.PaintMainView(g); // sara code but with set up to be painted every pass by the timer

        //end condition
        if (quit)
        {
            timer.stop(); //stops invoking panel class
        }
    }
}
