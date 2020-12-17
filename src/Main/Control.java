/*

    Created 12/16/2020
    Michael Hayes

 */

package Main;

public class Control {

    public int startTime;
    public double simulationSpeed;

    public int intialPopulation;


    public void beginSimulation() {
        this.startTime = (int) System.currentTimeMillis();
        System.out.println(startTime);
    }

    public static void main(String[] args) {
        Control control = new Control();

        control.beginSimulation();
    }
}
