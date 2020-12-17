/*

    Created 12/15/2020
    Michael Hayes

 */

package SimulatorObjects;

import Movement.Movement;
import Main.Control;

public class Person extends Movement {

    public enum gender {male, female}
    /**
     * Passed Variables
     */
    Control control;
    /**
     * Attributes
     */
    private int ID;
    private int age;

    /**
     * Items from control panel
     */
    double chanceDeath;
    double chanceBirth;
    Person(Control control){
        this.control = control;
    }

    private void init() {

    }

    public void collisionDetected(Person otherPerson) {

    }

    public void ageManager() {

    }
}
