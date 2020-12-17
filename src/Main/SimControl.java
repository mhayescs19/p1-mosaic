/*

    Created 12/16/2020
    Michael Hayes

 */

package Main;

public class SimControl {

    public int startTime;
    public double simulationSpeed;

    // Values from ConfigGUI
    public int intialPopulation;
    // Specific value that are to be shared with other classes
    public double chanceDeathInitial;
    public double chanceBirth;
    public double percentageGender;


    public void beginSimulation() {
        this.startTime = (int) System.currentTimeMillis();
        System.out.println(startTime);
    }

    public static void main(String[] args) {
        SimControl simControl = new SimControl();

        simControl.beginSimulation();
    }
}
