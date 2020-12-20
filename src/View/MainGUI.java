// Created by Sara
// Completed 12/20/2020

package View;
import javax.swing.*; // imports swing and awt libraries
import java.awt.*;

public class MainGUI extends JFrame {
    public MainGUI() {
        getContentPane().setBackground(new Color(41, 255, 255)); // Initializing light blue background color
        setBounds(100, 100, 800, 600);
        getContentPane().setLayout(null);

        JLabel labelTitle = new JLabel("Simulation Island");  // Initializing "Simulation Island" title
        labelTitle.setBounds(250, 10, 400, 60); // Initializing size of Title Label
        labelTitle.setFont(new Font("Lucia Grande", Font.BOLD, 37)); // Initializing various attributes of Title Label text
        getContentPane().add(labelTitle);

        JLabel labelYear = new JLabel("Year: ");
        labelYear.setBounds(20, 30, 100, 30);
        labelYear.setFont(new Font("Lucia Grande", Font.BOLD, 30));
        getContentPane().add(labelYear);

        JLabel labelYearNumber = new JLabel("2020");
        labelYearNumber.setBounds(110, 30, 100, 30);
        labelYearNumber.setFont(new Font("Lucia Grande", Font.BOLD, 29));
        getContentPane().add(labelYearNumber);

        JButton buttonPauseSimulation = new JButton("Pause");
        buttonPauseSimulation.setForeground(Color.BLACK);
        buttonPauseSimulation.setFont(new Font("Lucia Grande", Font.BOLD, 24));
        buttonPauseSimulation.setBackground(Color.RED);
        buttonPauseSimulation.setBounds(15, 500, 180, 60);
        buttonPauseSimulation.setOpaque(true);
        buttonPauseSimulation.setBorderPainted(false);
        getContentPane().add(buttonPauseSimulation);

        JButton buttonEndSimulation = new JButton("END");
        buttonEndSimulation.setForeground(Color.BLACK);
        buttonEndSimulation.setFont(new Font("Lucia Grande", Font.BOLD, 24));
        buttonEndSimulation.setBackground(Color.RED);
        buttonEndSimulation.setBounds(200, 500, 180, 60);
        buttonEndSimulation.setOpaque(true);
        buttonEndSimulation.setBorderPainted(false);
        getContentPane().add(buttonEndSimulation);

        JButton buttonfirstObstacle = new JButton("");
        buttonfirstObstacle.setForeground(Color.YELLOW);
        buttonfirstObstacle.setFont(new Font("Lucia Grande", Font.BOLD, 24));
        buttonfirstObstacle.setBackground(Color.YELLOW);
        buttonfirstObstacle.setBounds(600, 150, 15, 150);
        buttonfirstObstacle.setOpaque(true);
        buttonfirstObstacle.setBorderPainted(false);
        getContentPane().add(buttonfirstObstacle);
        buttonfirstObstacle.setEnabled(false);

        JButton buttonsecondObstacle = new JButton("");
        buttonsecondObstacle.setForeground(Color.YELLOW);
        buttonsecondObstacle.setFont(new Font("Lucia Grande", Font.BOLD, 24));
        buttonsecondObstacle.setBackground(Color.YELLOW);
        buttonsecondObstacle.setBounds(300, 325, 100, 15);
        buttonsecondObstacle.setOpaque(true);
        buttonsecondObstacle.setBorderPainted(false);
        getContentPane().add(buttonsecondObstacle);
        buttonsecondObstacle.setEnabled(false);

        JButton buttonthirdObstacle = new JButton("");
        buttonthirdObstacle.setForeground(Color.YELLOW);
        buttonthirdObstacle.setFont(new Font("Lucia Grande", Font.BOLD, 24));
        buttonthirdObstacle.setBackground(Color.YELLOW);
        buttonthirdObstacle.setBounds(115, 150, 170, 15);
        buttonthirdObstacle.setOpaque(true);
        buttonthirdObstacle.setBorderPainted(false);
        getContentPane().add(buttonthirdObstacle);
        buttonthirdObstacle.setEnabled(false);

        MyPanel myPanel = new MyPanel();
        myPanel.setBackground(new Color(41, 255, 255));
        myPanel.setBounds(20, 60, 780, 425);
        getContentPane().add(myPanel);


    }

    public static void main(String[] args) {
        MainGUI view = new MainGUI();
        view.setVisible(true);
    }
}
class MyPanel extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(new Color(0, 100, 0));
        g.fillOval(300, 200, 400, 200);
        g.fillOval(250, 170, 400, 200);
        g.fillOval(150, 170, 400, 200);
        g.fillOval(350, 100, 400, 200);
        g.fillOval(325, 35, 400, 200);
        g.fillOval(150, 50, 400, 200);
        g.fillOval(100, 30, 400, 200);
        g.fillOval(50, 40, 400, 200);
        g.fillOval(30, 100, 400, 200);
        g.fillOval(30, 120, 400, 200);
        g.fillOval(200, 215, 400, 200);
    }
}