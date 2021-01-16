/*

    Created 12/15/2020
    Michael Hayes

 */

package SimulatorObjects;

import Movement.Movement;
import Main.SimControl;

public class Person extends Movement {

    public enum Gender {male, female}

    public enum Health {alive, dead}

    public enum Age {baby, youth, teen, youngAdult, middleAge, senior, seniorPlus} // baby 0-5, youth 5-12, teen 13-18, youngAdult 18-35, middleAge 35-60, senior 60-75, seniorPlus 75-100+

    /**
     * Passed Variables
     */
    SimControl simControl;
    /**
     * Attributes
     */
    private int ID;
    private int age;
    private Age myAgeCategory;
    private Gender myGender;
    private Health myHealth;
    private double myBirthRate;
    private double myDeathRate;

    /**
     * Other Values
     */
    private int timeScale;

    /**
     * Items from control panel
     */
    double chanceDeathInitial;
    double chanceBirth;
    double percentageGender;
    double simSpeed = 1;

    /**
     * Default constructor
     * @param simControl
     */
    public Person(SimControl simControl){
        super(simControl.getBoundsForView().getKey(), simControl.getBoundsForView().getValue());
        this.simControl = simControl;
        this.chanceBirth = simControl.chanceBirth;
        this.chanceDeathInitial = simControl.chanceDeathInitial;
        this.percentageGender = simControl.percentageGender;

        this.myHealth = Health.alive;
        this.age = randomAge();

        //temp to avoid null
        this.myAgeCategory = Age.baby;

        this.init();
    }

    /**
     * Constructor for a new birth during simulation with inherited genetics
     */
    // Note: Will update genetics for clarity in the future... separate Genetics class?
    public Person(SimControl simControl, double[] genetics) {
        super(simControl.getBoundsForView().getKey(), simControl.getBoundsForView().getValue());
        this.simControl = simControl;
        this.chanceBirth = genetics[1];
        this.chanceDeathInitial = genetics[2];
        this.percentageGender = simControl.percentageGender;
        this.simSpeed = simControl.simSpeed;

        this.myHealth = Health.alive;
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
        // sets initial age category
        this.setAgeCategory();
    }

    /**
     * Collision detected from control
     * Methods calculates birth and passes inherited genetics (birthRate, deathRate) from parents
     * @param otherPerson
     */
    public double[] collisionDetected(Person otherPerson) {

        // default values for variables used in scope of if, but need to be saved
        double inheritedDeathRate = -1;
        double childBirthRate = -1;
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

    /**
     * Manages age based on time scale and implements and increased death rate after age 60
     */
    public void ageManager() {
        this.timeScale += 1; // counts time in year by collecting a value each time the frame is repainted

        if (timeScale == 15 * simSpeed && this.getMyHealth() == Health.alive) { // every five ticks, one year passes (default time if simSpeed = 1.0) and person is still alive
            timeScale = 0; // resets time scale
            this.age += 1; // one year is added

            if (this.age >= 60) { // once person reaches age 60, the death rate starts to take effect
                if (Math.random() < this.myDeathRate) { // "first trial" - can the person survive the initial application of death rate
                    this.myHealth = Health.dead;
                    System.out.println("Person.java - Person " + this.getID() + " has died. Person " + this.getID() + " was " + this.getAge());
                } else {
                    this.myDeathRate = Math.log(this.age - 58) - 1 / Math.log(2); // once a person is over the age of 60, their death rate will increase along an  exponential eqs
                    System.out.println("Person " + this.getID() + " new death rate: " + this.myDeathRate);
                }
            }
            setAgeCategory(); // supplemental categorization of new age
        }
    }
    /**
     * Simple randomization of age for starting population
     */
    public int randomAge() {
        int randomAge =  (int) (Math.random() * 60); // random 0 < age < 60 inclusive

        return randomAge;
    }

    /**
     * Updates age category to be used as reference for deciding dot color
     * Quick reference guide to age categories
     * baby 0-5, youth 5-12, teen 13-18, youngAdult 18-35, middleAge 35-60,
     * senior 60-75, seniorPlus 75-100+
     */
    public void setAgeCategory() {
        if (this.age <= 5) {
            this.myAgeCategory = Age.baby;
        } else if (this.age < 13 && this.age > 5) {
            this.myAgeCategory = Age.youth;
        } else if (this.age <= 18 && this.age > 13) {
            this.myAgeCategory = Age.teen;
        } else if (this.age <= 35 && this.age > 18) {
            this.myAgeCategory = Age.youngAdult;
        } else if (this.age <= 60 && this.age > 35) {
            this.myAgeCategory = Age.middleAge;
        } else if (this.age <= 75 && this.age > 60) {
            this.myAgeCategory = Age.senior;
        } else if (this.age > 75) {
            this.myAgeCategory = Age.seniorPlus;
        }
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

    public int getTimeScale() { return this.timeScale; }

    public Age getMyAgeCategory() { return this.myAgeCategory; }

    public Health getMyHealth() { return this.myHealth; }

    public boolean isDead() { return this.myHealth == Health.dead; }

    public int getID() { return this.ID; }

    // Setters for class variables
    public void setID(int id){ this.ID = id;}

    public void setAgeCategory(Age myAgeCategory) { this.myAgeCategory = myAgeCategory; }
    /**
     * Movement
     * @return
     */
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


