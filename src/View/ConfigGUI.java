/*

    Created 12/14/2020
    Nakul Nandhakumar

 */

package View;
import javax.swing.*; // imports swing and awt libraries
import java.awt.*;

public class ConfigGUI extends JFrame {
    public enum EndConditions {Population, Year} // Enum with options to chose type of condition for ending sim

    int defaultPop = 200;
    int defaultEndValue = 2050;
    double defaultBirthChance = 0.5*100;
    double defaultDeathChance = 0.15*100;
    double defaultPercentageMales = 0.5*100;
    double defaultPercentageFemales = 0.5*100;
    String[] arrayEndConditions = {"Population", "Year"};
    EndConditions defaultEndConditionView = EndConditions.Population;

    int initialPop;
    int EndValue;
    double initialBirthChance;
    double initialDeathChance;
    Object EndCondition;
    int initialYear;
    double initialPercentageMales;
    double initialPercentageFemales;
    EndConditions endCondition;

    public ConfigGUI() {
        getContentPane().setBackground(new Color(41, 255, 255));  // Initializing content pane and setting color
        setBounds(100, 100, 800, 600);  // Initializing size of content pane
        getContentPane().setLayout(null); // Content pane currently has nothing on it, it is blank

        JLabel labelTitle = new JLabel("Population Simulation");  // Initializing Title Label
        labelTitle.setBounds(200, 10, 400, 60); // Initializing size of Title Label
        labelTitle.setFont(new Font("Apple Chancery", Font.BOLD+Font.ITALIC, 37)); // Initializing various attributes of Title Label text
        getContentPane().add(labelTitle); // Adding the Title Label the content pane so that is appears when code is run

        JLabel labelSubTitle = new JLabel("Initial Configurations");
        labelSubTitle.setBounds(250, 60, 300, 50);
        labelSubTitle.setFont(new Font("Apple Chancery", Font.BOLD+Font.ITALIC, 29));
        getContentPane().add(labelSubTitle);

        JLabel labelInitialPop = new JLabel("Initial Population Size");
        labelInitialPop.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        labelInitialPop.setBounds(150, 125, 200, 30);
        getContentPane().add(labelInitialPop);

        JLabel labelInitialPopView = new JLabel(defaultPop+" people");
        labelInitialPopView.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        labelInitialPopView.setForeground(Color.BLUE);
        labelInitialPopView.setBounds(690, 110, 80, 40);
        getContentPane().add(labelInitialPopView);

        JSlider sliderInitialPop = new JSlider(100, 1000, 200);
        sliderInitialPop.setBounds(300, 120, 400, 60);
        sliderInitialPop.setMajorTickSpacing(100); // This is like the big ticks on a ruler, puts the, after every 100 on the slider
        sliderInitialPop.setMinorTickSpacing(50);  // This would be just like the sub ticks on a ruler and it puts them after every 50
        sliderInitialPop.setPaintTicks(true); // If true, then the ticks (including minor ticks) are painted on the slider
        sliderInitialPop.setPaintLabels(true); // If true, then paints the number labels beneath each major tick
        sliderInitialPop.addChangeListener(event -> {
            labelInitialPopView.setText(sliderInitialPop.getValue() + " people");  // Event listener that carries out code
            // when the slider is dragged
        });
        getContentPane().add(sliderInitialPop); // Adds slider to the content pane

        JComboBox dropdownEndConditions = new JComboBox(arrayEndConditions);  // A ComboBox is basically a dropdown menu and the items it will have is inside the array
        dropdownEndConditions.setBounds(200, 180, 125, 25);
        getContentPane().add(dropdownEndConditions);

        JLabel labelEndConditions = new JLabel("End Condition");
        labelEndConditions.setBounds(110, 170, 100, 40);
        labelEndConditions.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        getContentPane().add(labelEndConditions);

        JTextField textfieldEndValue = new JTextField(String.valueOf(defaultEndValue));
        textfieldEndValue.setBounds(550, 180, 75, 25);
        textfieldEndValue.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        getContentPane().add(textfieldEndValue);

        JLabel labelStartYearClarification = new JLabel("*Please note that all simulations begin in year 2020");
        labelStartYearClarification.setBounds(430, 195, 300, 25);
        labelStartYearClarification.setFont(new Font("Lucia Grande", Font.BOLD, 10));
        getContentPane().add(labelStartYearClarification);

        JLabel labelEndValue = new JLabel("End Year/Population");
        labelEndValue.setBounds(420, 175, 150, 30);
        labelEndValue.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        getContentPane().add(labelEndValue);

        JLabel labelInitialChanceOfDeath = new JLabel("Initial Percent Chance of Death");
        labelInitialChanceOfDeath.setBounds(100, 225, 200, 30);
        labelInitialChanceOfDeath.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        getContentPane().add(labelInitialChanceOfDeath);

        JLabel labelInitialChanceOfDeathCondition = new JLabel("*Applied when person reaches 60 yrs old");
        labelInitialChanceOfDeathCondition.setBounds(70, 240, 250, 25);
        labelInitialChanceOfDeathCondition.setFont(new Font("Lucia Grande", Font.BOLD, 10));
        getContentPane().add(labelInitialChanceOfDeathCondition);

        JLabel labelInitialChanceOfDeathView = new JLabel((int) (defaultDeathChance)+"%");
        labelInitialChanceOfDeathView.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        labelInitialChanceOfDeathView.setForeground(Color.BLUE);
        labelInitialChanceOfDeathView.setBounds(690, 210, 70, 40);
        getContentPane().add(labelInitialChanceOfDeathView);

        JSlider sliderInitialChanceOfDeath = new JSlider(0, 100, 15);
        sliderInitialChanceOfDeath.setMajorTickSpacing(10);
        sliderInitialChanceOfDeath.setMinorTickSpacing(5);
        sliderInitialChanceOfDeath.setPaintTicks(true);
        sliderInitialChanceOfDeath.setPaintLabels(true);
        sliderInitialChanceOfDeath.setSnapToTicks(true); // If true, then slider snaps to nearest tick whether major or minor
        sliderInitialChanceOfDeath.setBounds(300, 220, 400, 60);
        sliderInitialChanceOfDeath.addChangeListener(event -> {
            labelInitialChanceOfDeathView.setText(sliderInitialChanceOfDeath.getValue() + "%");
        });
        getContentPane().add(sliderInitialChanceOfDeath);

        JLabel labelInitialChanceOfBirth = new JLabel("Percent Chance of Birth");
        labelInitialChanceOfBirth.setBounds(150, 295, 150, 30);
        labelInitialChanceOfBirth.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        getContentPane().add(labelInitialChanceOfBirth);

        JLabel labelInitialChanceOfBirthCondition = new JLabel("*A constant applied when people 'interact' (collide)");
        labelInitialChanceOfBirthCondition.setBounds(30, 310, 280, 25);
        labelInitialChanceOfBirthCondition.setFont(new Font("Lucia Grande", Font.BOLD, 10));
        getContentPane().add(labelInitialChanceOfBirthCondition);

        JLabel labelInitialChanceOfBirthView = new JLabel((int) (defaultBirthChance)+"%");
        labelInitialChanceOfBirthView.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        labelInitialChanceOfBirthView.setForeground(Color.BLUE);
        labelInitialChanceOfBirthView.setBounds(690, 280, 70, 40);
        getContentPane().add(labelInitialChanceOfBirthView);

        JSlider sliderInitialChanceOfBirth = new JSlider(0, 100, 50);
        sliderInitialChanceOfBirth.setMajorTickSpacing(10);
        sliderInitialChanceOfBirth.setMinorTickSpacing(5);
        sliderInitialChanceOfBirth.setPaintTicks(true);
        sliderInitialChanceOfBirth.setPaintLabels(true);
        sliderInitialChanceOfBirth.setSnapToTicks(true); // If true, then slider snaps to nearest tick whether major or minor
        sliderInitialChanceOfBirth.setBounds(300, 290, 400, 60);
        sliderInitialChanceOfBirth.addChangeListener(event -> {
            labelInitialChanceOfBirthView.setText(sliderInitialChanceOfBirth.getValue() + "%");
        });
        getContentPane().add(sliderInitialChanceOfBirth);

        JLabel labelInitialPercentageOfMales = new JLabel("Percent Males");
        labelInitialPercentageOfMales.setBounds(200, 365, 150, 30);
        labelInitialPercentageOfMales.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        getContentPane().add(labelInitialPercentageOfMales);

        JLabel labelInitialPercentageOfMalesView = new JLabel((int)(defaultPercentageMales)+"%");
        labelInitialPercentageOfMalesView.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        labelInitialPercentageOfMalesView.setForeground(Color.BLUE);
        labelInitialPercentageOfMalesView.setBounds(690, 350, 70, 40);
        getContentPane().add(labelInitialPercentageOfMalesView);

        JSlider sliderInitialPercentageOfMales = new JSlider(0, 100, 50);
        sliderInitialPercentageOfMales.setMajorTickSpacing(10);
        sliderInitialPercentageOfMales.setMinorTickSpacing(5);
        sliderInitialPercentageOfMales.setPaintTicks(true);
        sliderInitialPercentageOfMales.setPaintLabels(true);
        sliderInitialPercentageOfMales.setSnapToTicks(true); // If true, then slider snaps to nearest tick whether major or minor
        sliderInitialPercentageOfMales.setBounds(300, 360, 400, 60);
        sliderInitialPercentageOfMales.addChangeListener(event -> {
            labelInitialPercentageOfMalesView.setText(sliderInitialPercentageOfMales.getValue() + "%");
        });
        getContentPane().add(sliderInitialPercentageOfMales);

        JButton buttonResetToDefaults = new JButton("RESET TO DEFAULTS");
        buttonResetToDefaults.setForeground(Color.BLACK);
        buttonResetToDefaults.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        buttonResetToDefaults.setBackground(Color.RED);
        buttonResetToDefaults.setBounds(10, 550, 170, 30);
        buttonResetToDefaults.addActionListener(event -> {
            sliderInitialPop.setValue(defaultPop);
            sliderInitialChanceOfDeath.setValue((int) defaultDeathChance);
            sliderInitialChanceOfBirth.setValue((int) defaultBirthChance);
            dropdownEndConditions.setSelectedItem(String.valueOf(defaultEndConditionView));
            textfieldEndValue.setText(String.valueOf(defaultEndValue));
            sliderInitialPercentageOfMales.setValue((int) (defaultPercentageMales));
        });
        getContentPane().add(buttonResetToDefaults);

        JButton buttonStartSimulation = new JButton("START");
        buttonStartSimulation.setForeground(Color.BLACK);
        buttonStartSimulation.setFont(new Font("Lucia Grande", Font.BOLD, 24));
        buttonStartSimulation.setBackground(Color.RED);
        buttonStartSimulation.setBounds(310, 520, 180, 60);
        buttonStartSimulation.addActionListener(event -> {
            initialPop = sliderInitialPop.getValue();
            initialDeathChance = sliderInitialChanceOfDeath.getValue()/100.0;
            initialBirthChance = sliderInitialChanceOfBirth.getValue()/100.0;
            EndValue = Integer.parseInt(textfieldEndValue.getText());
            EndCondition = EndConditions.valueOf(String.valueOf(dropdownEndConditions.getSelectedItem()));
            System.out.println(EndCondition);
            initialYear = 2020;
            initialPercentageMales = sliderInitialPercentageOfMales.getValue()/100.0;
            initialPercentageFemales = 1.0 - initialPercentageMales;
        });
        getContentPane().add(buttonStartSimulation);
    }

    public static void main (String[] args){
        ConfigGUI view = new ConfigGUI();
        view.setVisible(true);
    }
    // Above code block is to show visual for testing and error correction purposes
    // Please remove whenever necessary
    // It most likely won't be included in the final project



}