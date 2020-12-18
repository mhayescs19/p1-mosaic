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
    private int myDeathRate;

    /**
     * Items from control panel
     */
    double chanceDeathInitial;
    double chanceBirth;
    double percentageGender;

    // default constructor
    Person(SimControl simControl){
        this.simControl = simControl;
        this.chanceBirth = simControl.chanceBirth;
        this.chanceDeathInitial = simControl.chanceDeathInitial;
        this.percentageGender = simControl.percentageGender;

        this.init();
    }
    // constructor for a new birth during sim
    Person(double chanceDeath) {
        this.simControl = simControl;
        this.chanceBirth = simControl.chanceBirth;
        this.chanceDeathInitial = chanceDeath;
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
        if (Math.random() < chanceDeathInitial) {
            this.myDeathRate = 1;
        } else {
            this.myDeathRate = 0;
        }
    }

    /**
     * Collision detected from control
     * Methods calculates birth and inherits simple death rate from parents
     * @param otherPerson
     */
    public double[] collisionDetected(Person otherPerson) {

        if (this.verifyAge() && otherPerson.verifyAge()) { // verifies both individuals are of age
            double finalChanceBirth = (this.myBirthRate + otherPerson.myBirthRate) / 2; // averages birth rate of parents for "realism"
            double chance = Math.random(); // randomization extracted in order to access chance

            if (chance < finalChanceBirth) { // chance executed based on combined parent's birth rates
                double childBirthRate = chance;
            }
        }
        double[] genetics = new double[]{0.0, 0.5};
        return genetics;
    }

    public void ageManager() {

    }

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

}
