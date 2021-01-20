// Created by Sara
// In progress

package View;
import Main.ConfigControl;
import Main.SimControl;

import javax.swing.*; // imports swing and awt libraries
import java.awt.*;

public class DataGUI extends JFrame {
    public DataGUI() {

        // Need variables to display simulation data; currently in progress

        getContentPane().setBackground(new Color(41, 255, 255));
        setBounds(100, 100, 800, 600);
        getContentPane().setLayout(null);

        JLabel labelSimCompleted = new JLabel("Simulation Completed!");
        labelSimCompleted.setBounds(20, 30, 300, 30);
        labelSimCompleted.setFont(new Font("Lucia Grande", Font.BOLD, 20));
        getContentPane().add(labelSimCompleted);

        JLabel labelStartYear = new JLabel("Start Year: ");
        labelStartYear.setBounds(40, 200, 200, 30);
        labelStartYear.setFont(new Font("Lucia Grande", Font.BOLD, 30));
        getContentPane().add(labelStartYear);

        JLabel labelEndYear = new JLabel("End Year: ");
        labelEndYear.setBounds(425, 200, 200, 30);
        labelEndYear.setFont(new Font("Lucia Grande", Font.BOLD, 30));
        getContentPane().add(labelEndYear);

        JLabel labelInitialPop = new JLabel("Initial Population: ");
        labelInitialPop.setBounds(20, 280, 400, 30);
        labelInitialPop.setFont(new Font("Lucia Grande", Font.BOLD, 30));
        getContentPane().add(labelInitialPop);

        JLabel labelFinalPop = new JLabel("Final Population: ");
        labelFinalPop.setBounds(450, 280, 400, 30);
        labelFinalPop.setFont(new Font("Lucia Grande", Font.BOLD, 30));
        getContentPane().add(labelFinalPop);

        JLabel labelBirths = new JLabel("Births: ");
        labelBirths.setBounds(40, 360, 400, 60);
        labelBirths.setFont(new Font("Lucia Grande", Font.BOLD, 30));
        getContentPane().add(labelBirths);

        JLabel labelDeaths = new JLabel("Deaths: ");
        labelDeaths.setBounds(425, 360, 400, 60);
        labelDeaths.setFont(new Font("Lucia Grande", Font.BOLD, 30));
        getContentPane().add(labelDeaths);

        JLabel labelStatistics = new JLabel("Statistics");
        labelStatistics.setBounds(300, 100, 400, 60);
        labelStatistics.setFont(new Font("Lucia Grande", Font.BOLD, 40));
        getContentPane().add(labelStatistics);

        // Histogram still needs to be added, research phase

    }

    public static void main(String[] args) {
        DataGUI view = new DataGUI();
        view.setVisible(true);
    }
}