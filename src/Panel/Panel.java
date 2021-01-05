/*
 * Copyright (c) 2020.
 * Created by Andrew Pegg
 */

package Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Panel extends JPanel implements ActionListener {
    // constructor maybe used later?
    public Panel()
    {

    }
     @Override
     public void actionPerformed(ActionEvent event)
     {             //triggers the paint method which we will define in other class via overriding/polymorphism
                repaint();
     }


    @Override //used in other class
    public abstract void paint(Graphics g);


}
