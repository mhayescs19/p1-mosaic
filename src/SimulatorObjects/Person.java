/*

    Created 12/15/2020
    Michael Hayes

 */

package SimulatorObjects;

import Movement.Movement;
import Main.SimControl;

public class Person extends Movement {

    public enum gender {male, female}
    /**
     * Passed Variables
     */
    SimControl simControl;
    /**
     * Attributes
     */
    private int ID;
    private int age;
    private double myGender;
    private double myBirthRate;
    private double myDeathRate;

    /**
     * Items from control panel
     */
    double chanceDeathInitial;
    double chanceBirth;
    double percentageGender;

    Person(SimControl simControl){
        this.simControl = simControl;
        this.chanceBirth = simControl.chanceBirth;
        this.chanceDeathInitial = simControl.chanceDeathInitial;
        this.percentageGender = simControl.percentageGender;

        this.init();
    }

    private void init() {

    }

    /**
     * Collision detected from control
     * Methods calculates birth and inherits simple death rate from parents
     * @param otherPerson
     */
    public void collisionDetected(Person otherPerson) {

    }

    public void ageManager() {

    }
}
