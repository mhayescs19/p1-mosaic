/*

    Created 12/16/2020
    Michael Hayes

 */

package Main;

public class SimControl {

    public int startTime;
    public double simulationSpeed;

    public int intialPopulation;


    public void beginSimulation() {
        this.startTime = (int) System.currentTimeMillis();
        System.out.println(startTime);
    }

    public static void main(String[] args) {
        SimControl simControl = new SimControl();

        simControl.beginSimulation();
    }
}
