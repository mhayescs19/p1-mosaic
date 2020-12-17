/*

    Created 12/14/2020
    Nakul Nandhakumar

 */

package View;
import javax.swing.*; // imports swing and awt libraries
import java.awt.*;

public class ConfigGUI extends JFrame {
 String arrayEndConditions[] = {"Population", "Year"};  // Array with options to chose type of condition for ending sim

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

        JSlider sliderInitialPop = new JSlider(100, 1000, 200);
        sliderInitialPop.setBounds(300, 120, 400, 60);
        sliderInitialPop.setMajorTickSpacing(100); // This is like the big ticks on a ruler, puts the, after every 100 on the slider
        sliderInitialPop.setMinorTickSpacing(50);  // This would be just like the sub ticks on a ruler and it puts them after every 50
        sliderInitialPop.setPaintTicks(true); // If true, then the ticks (including minor ticks) are painted on the slider
        sliderInitialPop.setPaintLabels(true); // If true, then paints the number labels beneath each major tick
        getContentPane().add(sliderInitialPop); // Adds slider to the content pane

        JLabel labelInitialPop = new JLabel("Initial Population Size");
        labelInitialPop.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        labelInitialPop.setBounds(150, 125, 200, 30);
        getContentPane().add(labelInitialPop);

        JComboBox dropdownEndConditions = new JComboBox(arrayEndConditions);  // A ComboBox is basically a dropdown menu and the items it will have is inside the array
        dropdownEndConditions.setBounds(200, 180, 125, 25);
        getContentPane().add(dropdownEndConditions);

        JLabel labelEndConditions = new JLabel("End Condition");
        labelEndConditions.setBounds(110, 170, 100, 40);
        labelEndConditions.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        getContentPane().add(labelEndConditions);

        JTextField textfieldEndValue = new JTextField("2050");
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

        JSlider sliderInitialChanceOfDeath = new JSlider(0, 100, 15);
        sliderInitialChanceOfDeath.setMajorTickSpacing(10);
        sliderInitialChanceOfDeath.setMinorTickSpacing(5);
        sliderInitialChanceOfDeath.setPaintTicks(true);
        sliderInitialChanceOfDeath.setPaintLabels(true);
        sliderInitialChanceOfDeath.setSnapToTicks(true); // If true, then slider snaps to nearest tick whether major or minor
        sliderInitialChanceOfDeath.setBounds(300, 220, 400, 60);
        getContentPane().add(sliderInitialChanceOfDeath);

        JLabel labelInitialChanceOfDeath = new JLabel("Initial Percent Chance of Death");
        labelInitialChanceOfDeath.setBounds(100, 225, 200, 30);
        labelInitialChanceOfDeath.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        getContentPane().add(labelInitialChanceOfDeath);

        JLabel labelInitialChanceOfDeathCondition = new JLabel("*Applied when person reaches 60 yrs old");
        labelInitialChanceOfDeathCondition.setBounds(70, 240, 250, 25);
        labelInitialChanceOfDeathCondition.setFont(new Font("Lucia Grande", Font.BOLD, 10));
        getContentPane().add(labelInitialChanceOfDeathCondition);

        JSlider sliderInitialChanceOfBirth = new JSlider(0, 100, 50);
        sliderInitialChanceOfBirth.setMajorTickSpacing(10);
        sliderInitialChanceOfBirth.setMinorTickSpacing(5);
        sliderInitialChanceOfBirth.setPaintTicks(true);
        sliderInitialChanceOfBirth.setPaintLabels(true);
        sliderInitialChanceOfBirth.setSnapToTicks(true); // If true, then slider snaps to nearest tick whether major or minor
        sliderInitialChanceOfBirth.setBounds(300, 290, 400, 60);
        getContentPane().add(sliderInitialChanceOfBirth);

        JLabel labelInitialChanceOfBirth = new JLabel("Percent Chance of Birth");
        labelInitialChanceOfBirth.setBounds(150, 295, 150, 30);
        labelInitialChanceOfBirth.setFont(new Font("Lucia Grande", Font.BOLD, 12));
        getContentPane().add(labelInitialChanceOfBirth);

        JLabel labelInitialChanceOfBirthCondition = new JLabel("*A constant applied when people 'interact' (collide)");
        labelInitialChanceOfBirthCondition.setBounds(30, 310, 280, 25);
        labelInitialChanceOfBirthCondition.setFont(new Font("Lucia Grande", Font.BOLD, 10));
        getContentPane().add(labelInitialChanceOfBirthCondition);

        JButton buttonStartSimulation = new JButton("START");
        buttonStartSimulation.setForeground(Color.BLACK);
        buttonStartSimulation.setFont(new Font("Lucia Grande", Font.BOLD, 24));
        buttonStartSimulation.setBackground(Color.RED);
        buttonStartSimulation.setBounds(310, 500, 180, 60);
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
