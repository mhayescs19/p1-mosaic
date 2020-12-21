package Panel;

import Main.SimControl;


import javax.swing.*;
import java.awt.*;

public class Painter extends Panel{
    public boolean quit = false;
    static final String name_of_panel = "Population sim";
    JFrame jFrame;
    SimControl simControl;
    Timer timer; //like objective c timer loops and does stuff every set interval
    double Time = 0; // will be used to track how long the program has been running
    public Painter(SimControl sim, JPanel panel) // need panel
    {
        this.simControl = sim; // ass the simControl in a parameter
        jFrame = new JFrame(name_of_panel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.add(this); // add this class to the jpanel
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
        jFrame.setVisible(true); // not sure if this is necessary  but want to make sure that the jpanel is updated
    }


    @Override //master paint class
    public void paint(Graphics g) {
            // add paint stuff
            Time += 16; // constant will change this
        g.setColor(new Color(0, 100, 0)); // code from sara ui, If she made panel public could call here paint code in here it should work
        g.fillOval(300, 200, 400, 200);
        g.fillOval(250, 170, 400, 200);
        g.fillOval(150, 170, 400, 200);
        g.fillOval(350, 100, 400, 200);
        g.fillOval(325, 35, 400, 200);
        g.fillOval(150, 50, 400, 200);
        g.fillOval(100, 30, 400, 200);
        g.fillOval(50, 40, 400, 200);
        g.fillOval(30, 100, 400, 200);
        g.fillOval(30, 120, 400, 200);
        g.fillOval(200, 215, 400, 200);

        //end condition
        if (quit)
        {
            timer.stop(); //stops invoking panel class
        }
    }
}
