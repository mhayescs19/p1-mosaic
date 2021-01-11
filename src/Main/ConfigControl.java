package Main;

import View.ConfigGUI;

public class ConfigControl {

    public ConfigGUI view;

    public int initialPop;
    public int EndValue;
    public double initialBirthChance;
    public double initialDeathChance;
    public Object EndCondition;
    public int initialYear;
    public double initialPercentageMales;
    public double initialPercentageFemales;
    public ConfigGUI.EndConditions endCondition;

    public ConfigControl() {

        this.view = new ConfigGUI(this);
        view.setVisible(true);
    }

    public ConfigControl getConfigControl() { return this; }

    public void activateSimControl() {
        SimControl simControl = new SimControl(this);

    }
}
