/*

    Created 12/16/2020
    Michael Hayes

 */

package Main;

import java.awt.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import SimulatorObjects.Person;
import SimulatorObjects.Wall;
import Panel.Painter;
import View.ConfigGUI;
import View.MainGUI;


public class SimControl {

    public int startTime;
    public double simulationSpeed;
    private Painter painter;
    ArrayList<Person> population;

    ArrayList<Person> newChildren = new ArrayList<>();
    ArrayList<Person> deadPeople = new ArrayList<>();
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
    private int Time = 0;

    // MVC
    public MainGUI view = new MainGUI();

    public SimControl(ConfigControl control) {
        this.chanceDeathInitial = control.initialDeathChance;
        this.chanceBirth = control.initialBirthChance;
        this.percentageGender = control.initialPercentageMales;
        this.initialPopulation = control.initialPop;
        this.currentPopulation = 25;//control.initialPop;
        this.EndCondition = control.EndCondition;
        this.EndValue = control.EndValue;
        this.initialYear = control.initialYear;
        this.currentYear = control.initialYear;
        this.simSpeed = 0;

       this.view = new MainGUI();
        view.setVisible(true);
        this.beginSimulation();
    }

    /**
     * Creates population of Person objects in an ArrayList w/custom ID
     * xImplementation of view later
     */
    public void beginSimulation() {

        population = new ArrayList<>(); // master list of population
        painter = new Painter(this); // this refers to this class
        for (int i = 0; i < 25; i++) { // initial creation of population
            Person newPerson = new Person(this);
            newPerson.setID(i);
            population.add(newPerson);
            System.out.println("SimControl.java - Population: Person " + i + " age: " + newPerson.getAge() + " added to ArrayList");
        }
        System.out.println("SimControl.java - Population size: " + population.size());
        painter.Start(); // starts the painter

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

            for (Person otherPerson : population) {// cycles through entire population (Java style loop)
                if (firstPerson == otherPerson){
                    continue;
                }

                if (firstPerson.collision(otherPerson)) { // compares firstPerson against every other object in population for a collision
                    //System.out.println("SimControl.java - Person: Collision detected!");
                    double[] genetics = firstPerson.collisionDetected(otherPerson);
                    firstPerson.CollisionHorizontal();
                    firstPerson.CollisionVertical();

                    if (genetics[0] == 1.0) { // current value to represent a birth
                        Person newBaby = new Person(this, genetics); // sim birth specific constructor used of Person

                        newChildren.add(newBaby); // new birth of person added to temporary ArrayList to avoid mutating array during iteration
                        System.out.println("SimControl.java - Person: baby born!");
                        currentPopulation++;
                    }
                }
            }

            if (i == 0) {
                this.updateYear();
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


            /*for(Wall wall: painter.getWalls()) // for each
            {
                   // check for collision with walls in here
               if ( person.collision(wall))
               {
                   System.out.println("SimControl.java - Person " + person.getID() + " hit a wall");
                        if (wall.vertical)
                        {
                            person.CollisionVertical();
                        }
                        else
                        {
                            person.CollisionHorizontal();
                        }
               }
            }*/
            person.ageManager();

            /**
             * If dead, no velocity, otherwise velocity remains
             */
            if (person.isDead()) { // death condition
                person.Velocity0();
                currentPopulation--;
                System.out.println("SimControl.java - The current population is now " + currentPopulation);
                deadPeople.add(person); // new death of person added to temporary ArrayList to avoid mutating array during iteration
                continue;
            }  else {
                person.Velocity(); //updates velocity
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

        if (newChildren.size() >= 0) {
            recountPopulation();
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
        System.out.println("endSimulation works.");  // Test code to see if method runs properly
    }

    public void updateYear() {
        Time++;
        if (Time % 15 == 0){
            currentYear++;
            System.out.println("SimControl.java - 1 year has passed. Current year: " + currentYear);

        }
        //System.out.println("updateYear works."); // Test code to see if method runs properly
    }

    /**
     * a getter that returns the width and height
     * @return a tuple pair Inteager that give the width and height of the panel
     */
    public AbstractMap.SimpleEntry<Integer, Integer> getBoundsForView()
    {
        return new AbstractMap.SimpleEntry<>(painter.getWidth(), painter.getHeight());
    }

    /**
     * Recounts population accounting for new births and dead people to avoid iteration errors
     */
    public void recountPopulation(){
        for (Person deadIndividual : deadPeople) { // cycles through temporary arrayList to mutate master population
            population.remove(deadIndividual);
        }
        deadPeople.clear(); // clears deadPeople from iteration (one call of painter)

        for (Person newbaby: newChildren) { // pulls individuals from separate temporary array that is transfered into to master population
            population.add(newbaby);
        }
        newChildren.clear(); // clears temporary newChildren from iteration (one call of painter)
    }


    /**
     * Method tester for SimControl. Will NOT be used for any other purpose than testing code.
     * @param args
     */
    public static void main(String[] args) {
        ConfigControl con = new ConfigControl();
        SimControl simcont = new SimControl(con);
        simcont.endSimulation();
        simcont.updateYear();

    }
}
