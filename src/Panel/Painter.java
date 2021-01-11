/*
 * Copyright (c) 2020.
 * Created by Andrew Pegg
 */

package Panel;

import Main.SimControl;
import SimulatorObjects.Wall;
import View.ViewForPaint;


import javax.swing.*;
import java.awt.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Painter extends Panel{
    private ArrayList<Wall> walls;
    private ViewForPaint view = new ViewForPaint();
    public boolean quit = false;
    static final String name_of_panel = "Population sim";
    JFrame jFrame;
    SimControl simControl; // to get sim values
    Timer timer; //like objective c timer loops and does stuff every set interval
    double Time = 0; // will be used to track how long the program has been running
    public Painter(SimControl sim)
    {
        this.simControl = sim; // pass the simControl in a parameter
        jFrame = new JFrame(name_of_panel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.add(this); // add this class to the Jframe
        walls = new ArrayList<>();
        WallConstructor();
    }

    /**
     * tester constructor not to be used for implementation
     */
    public Painter()
    {
        System.out.println("testing constructor entered ");
        walls = new ArrayList<>();
        WallConstructor();
    }

    //starts the painting process


  private   interface Wallinterface
    {
        void Driver(int num , String filepath);
        AbstractMap.SimpleEntry<Integer , Integer>  wallpostion(int num);
    }
    @FunctionalInterface
    interface WallcontrtorInterface
    {
       boolean checkEven(int num);
    }
    /**
     * wall adder for panel
     */
    private void WallConstructor()
    {
        Wallinterface wallinterface = new Wallinterface() {
            @Override
            public void Driver(int number , String path) {
                WallcontrtorInterface wallcontrtorInterface = (int num) -> num%2==0; //defines boolean function
                AbstractMap.SimpleEntry<Integer, Integer> temp = wallpostion(number);
                walls.add(new Wall(temp.getKey(), temp.getValue(),wallcontrtorInterface.checkEven(number),path));
            }

            @Override
            public AbstractMap.SimpleEntry<Integer , Integer>  wallpostion(int num) {
                return switch (num) {
                    case 0 -> new AbstractMap.SimpleEntry<>(0, 0); // x then y
                    case 1 -> new AbstractMap.SimpleEntry<>(75, 150); // x then y
                    case 2 -> new AbstractMap.SimpleEntry<>(125, 250);
                    case 3 -> new AbstractMap.SimpleEntry<>(175, 350);
                    default -> null;
                };
            }

        } ;
       final String imagefilepath = "thin-black-line.png";
      //  List<Wall> collection =  IntStream.range(0,4).mapToObj(operand -> new Wall(operand*5,operand*5,wallcontrtorInterface.checkEven(operand),imagefilepath)).collect(Collectors.toList());
       // walls = (ArrayList<Wall>) IntStream.range(0,4).mapToObj(operand -> new Wall(operand*5,operand*5,wallcontrtorInterface.checkEven(operand),imagefilepath)).collect(Collectors.toList());
        // List data type inherits all types of list in java so arraylist and linked list, so we can use a explict conversion to convert the stream into an arraylist, https://docs.oracle.com/javase/8/docs/api/?java/util/List.html
        IntStream.range(0,4).forEach(num -> wallinterface.Driver(num,imagefilepath));
    }

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
    public void drawWalls(Graphics g)
    {
        g.setColor(Color.BLACK);
        for (Wall wall : walls)
        {
            wall.getImageIcon().paintIcon(this,g,getX(),getY());
        }
    }


    @Override //master paint class
    public void paint(Graphics g) {
            // add paint stuff
            Time += 16; // constant will change this
        view.PaintMainView(g); // sara code but with set up to be painted every pass by the timer
        drawWalls(g);

        //end condition
        if (quit)
        {
            timer.stop(); //stops invoking panel class
        }
    }
    public ArrayList<Wall> getWalls()
    {
        return this.walls;
    }

    /**
     * testing static
     * @param args
     */
    public static void main(String[] args)
    {
        Painter painter = new Painter();

    }

}
//todo add a constructor for walls so they can be painted onto the panel