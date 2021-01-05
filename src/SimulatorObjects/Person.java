/*

    Created 12/15/2020
    Michael Hayes

 */

package SimulatorObjects;

import Movement.Movement;
import Main.SimControl;

public class Person extends Movement {

    public enum Gender {male, female}
    /**
     * Passed Variables
     */
    SimControl simControl;
    /**
     * Attributes
     */
    private int ID;
    private int age;
    private Gender myGender;
    private double myBirthRate;
    private double myDeathRate;

    /**
     * Items from control panel
     */
    double chanceDeathInitial;
    double chanceBirth;
    double percentageGender;

    /**
     * Default constructor
     * @param simControl
     */
    public Person(SimControl simControl){
        this.simControl = simControl;
        this.chanceBirth = simControl.chanceBirth;
        this.chanceDeathInitial = simControl.chanceDeathInitial;
        this.percentageGender = simControl.percentageGender;

        this.init();
    }

    /**
     * Constructor for a new birth during simulation with inherited genetics
     */
    // Note: Will update genetics for clarity in the future... separate Genetics class?
    public Person(SimControl simControl, double[] genetics) {
        this.simControl = simControl;
        this.chanceBirth = genetics[1];
        this.chanceDeathInitial = genetics[2];
        this.percentageGender = simControl.percentageGender;

        this.age = 0;

        this.init();
    }

    /**
     * Setup of Person attributes upon start of sim
     */
    private void init() {
        // sets Person gender
        if (Math.random() < percentageGender) {
            this.myGender = Gender.male;
        } else {
            this.myGender = Gender.female;
        }
        // sets Person birth rate
        this.myBirthRate = chanceBirth;
        // sets Person death probability at age 60
        this.myDeathRate = chanceDeathInitial;
    }

    /**
     * Collision detected from control
     * Methods calculates birth and passes inherited genetics (birthRate, deathRate) from parents
     * @param otherPerson
     */
    public double[] collisionDetected(Person otherPerson) {

        // default values for variables used in scope of if, but need to be saved
        double inheritedDeathRate = -1.0;
        double childBirthRate = -1.0;
        int birth = 0;

        if (this.verifyAge() && otherPerson.verifyAge()) { // verifies both individuals are of age
            double finalChanceBirth = (this.myBirthRate + otherPerson.myBirthRate) / 2; // averages birth rate of parents for "realism"
            double birthChance = Math.random(); // first attempt of randomization

            while (birthChance == 0.0) { // verifies birth rate is a percent chance and not zero
                birthChance = Math.random(); // randomization extracted in order to access chance
            }

            if (birthChance < finalChanceBirth) { // chance executed based on combined parent's birth rates
                birth = 1;
            }
            childBirthRate = birthChance;

            inheritedDeathRate = (this.myBirthRate + otherPerson.myBirthRate) / 2;
        }
        double[] genetics = new double[]{birth, childBirthRate, inheritedDeathRate}; // returns inherited genetics, which is used in secondary constructor in Person

        return genetics;
    }

    public void ageManager() {

    }

    /**
     * Verifies birth possibility based on age range
     * @return
     */
    public boolean verifyAge(){
        boolean ofAge; // boolean for clarity of check

        if(this.getAge() >= 18 && this.getAge() <= 38) { // checks to make sure person is of age (18 < age < 38)
            ofAge = true;
        } else {
            ofAge = false;
        }
        return ofAge;
    }

    // Getters for class variables
    public int getAge(){ return this.age; }

    // Setters for class variables
    public void setID(int id){ this.ID = id;}
    //getter for x
    public int getX()
    {
        return x;
    }
    // getter for y
    public int getY()
    {
        return y;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }



}
