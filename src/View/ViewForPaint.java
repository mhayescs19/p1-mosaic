package View;

import java.awt.*;

public class ViewForPaint {
    public void PaintMainView(Graphics g)
    {

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
