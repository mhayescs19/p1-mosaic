/*

    Created 12/16/2020
    Michael Hayes

 */

package Main;

import java.awt.*;
import java.util.ArrayList;
import SimulatorObjects.Person;
import Movement.CollisionCheck;
import SimulatorObjects.Wall;

public class SimControl {

    public int startTime;
    public double simulationSpeed;

    ArrayList<Person> population;
    // Values from ConfigGUI
    public int initialPopulation;
    // Specific value that are to be shared with other classes
    public double chanceDeathInitial;
    public double chanceBirth;
    public double percentageGender;

    /**
     * Creates population of Person objects in an ArrayList w/custom ID
     * xImplementation of view later
     */
    public void beginSimulation() {
        population = new ArrayList<Person>(); // master list of population

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
                    }
                }
            }
        }


    }

    /**
     *  class desgin to be called on every invok by the timer in Painter
     *
     * @param g graphics need to paint onto the panel
     */
    public void PaintPopulation(Graphics g) // graphics is the panel
    {
        for (Person person : population)
        {
            g.fillOval(person.getX(), person.getY(), person.getWidth(), person.getHeight());
            for (Person person2 : population)
            {
                if (person.collision(person2))  // code that will check for collision
                {
                    person.collisionDetected(person2); // executes code from Micheal's class
                    System.out.println("collision detected"); // debug stuff
                }
            }
            /*
            for(Wall wall:walls )
            {
                   // check for collision with walls in here
            }
             */
        }
    }



    public static void main(String[] args) {
        SimControl simControl = new SimControl();

        simControl.beginSimulation();
    }
}
