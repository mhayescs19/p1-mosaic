/*

    Created 12/16/2020
    Michael Hayes

 */

package Main;

import java.awt.*;
import java.util.ArrayList;
import SimulatorObjects.Person;
import SimulatorObjects.Wall;
import Panel.Painter;
import View.ConfigGUI;


public class SimControl {

    public int startTime;
    public double simulationSpeed;
    private Painter painter;
    ArrayList<Person> population;
    // Values from ConfigGUI
    public int initialPopulation;
    public int currentPopulation;
    // Specific value that are to be shared with other classes
    public double chanceDeathInitial;
    public double chanceBirth;
    public double percentageGender;
    public Object EndCondition;
    public int EndValue;
    public int initialYear;
    public int currentYear;
    public double simSpeed;

    public SimControl(ConfigControl control) {
        this.chanceDeathInitial = control.initialDeathChance;
        this.chanceBirth = control.initialBirthChance;
        this.percentageGender = control.initialPercentageMales;
        this.initialPopulation = control.initialPop;
        this.currentPopulation = control.initialPop;
        this.EndCondition = control.EndCondition;
        this.EndValue = control.EndValue;
        this.initialYear = control.initialYear;
        this.currentYear = control.initialYear;
        this.simSpeed = 0;
    }

    /**
     * Creates population of Person objects in an ArrayList w/custom ID
     * xImplementation of view later
     */
    public void beginSimulation() {
        painter = new Painter(this); // this refers to this class
        population = new ArrayList<Person>(); // master list of population
        painter.Start(); // starts the painter
        for (int i = 0; i < initialPopulation; i++) { // initial creation of population
            Person newPerson = new Person(this);
            newPerson.setID(i);

            population.add(newPerson);
        }
    }

    /**
     * Method that is called after each time the timer is fired
     * 1. Loops through entire population and checks for any collisions
     *      a. If a collision is detected, a birth is possible
     *      b. If a child is "born", a new Person object is added to the master "population" ArrayList
     */
    public void updatePopulation(){

        for (int i = 0; i < population.size(); i++) { // master loop through entire population
            Person firstPerson = population.get(i);

            for (Person otherPerson : population) { // cycles through entire population (Java style loop)
                if (firstPerson.collision(otherPerson)) { // compares firstPerson against every other object in population for a collision
                    double[] genetics = firstPerson.collisionDetected(otherPerson);

                    if (genetics[0] == 1) { // current value to represent a birth
                        Person newBaby = new Person(this, genetics); // sim birth specific constructor used of Person

                        population.add(newBaby); // new birth of person added to master population list
                        currentPopulation++;
                    }
                }
            }
        }


    }

    /**
     *  class design to be called on every invoke by the timer in Painter
     * @see Painter
     * @param g graphics need to paint onto the panel
     */
    public void PaintPopulation(Graphics g) // graphics is the panel
    {
        updatePopulation(); // calls Micheal's code for collision check with other people and updates the arraylist
        for (Person person : population)
        {


            for(Wall wall: painter.getWalls()) // for each
            {
                   // check for collision with walls in here
               if ( person.collision(wall))
               {
                        if (wall.vertical)
                        {
                            person.CollisionVertical();
                        }
                        else
                        {
                            person.CollisionHorizontal();
                        }
               }
            }
            person.ageManager();

            /**
             * If dead, no velocity, otherwise velocity remains
             */
            if (person.isDead()) { // death condition
                person.Velcoity0();
            } else {
                person.Velcoity();//updates velocity
            }

            switch (person.getMyAgeCategory()) { // color shift of dot based on age of person; dynamic color shift later with RGB...?
                case youth -> g.setColor(Color.decode("#FFF700")); // yellow
                case baby -> g.setColor(Color.decode("#FFD100")); // yellow-orange
                case teen -> g.setColor(Color.decode("#FFB400")); // orange
                case youngAdult -> g.setColor(Color.decode("#FF8300")); // dark orange
                case middleAge -> g.setColor(Color.decode("#BF0202")); // red
                case senior -> g.setColor(Color.decode("#CB008F")); // purple
                case seniorPlus -> g.setColor(Color.decode("#69006D")); // dark purple
                default -> {
                    g.setColor(Color.BLACK);
                    System.out.println("Age category not found");
                }
            }

            g.fillOval(person.getX(), person.getY(), person.getWidth(), person.getHeight());
        }
    }

    public void endSimulation(){
        if (EndCondition == ConfigGUI.EndConditions.Population){
            if (currentPopulation >= EndValue) {
                painter.quit = true;
            }
        }
        if (EndCondition == ConfigGUI.EndConditions.Year){
            if (currentYear >= EndValue) {
                painter.quit = true;
            }
        }
    }



    /*public static void main(String[] args) {
        SimControl simControl = new SimControl();

        simControl.beginSimulation();
    }*/
}
