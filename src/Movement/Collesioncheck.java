/*

    Created 12/14/2020
    Andrew Pegg

 */
package Movement;

import java.awt.*;

public class Collesioncheck {
    protected int x, y; //position
    protected int width, height; // object height and width
    public Collesioncheck(int x , int y, int width, int height) // good for walls maybe
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Collesioncheck()
    {

    }

    public boolean Collesion(Collesioncheck collesioncheck2)
    {
        Rectangle rect1 = new Rectangle(x,y,width,height);
        Rectangle rect2 = new Rectangle(collesioncheck2.x,collesioncheck2.y,collesioncheck2.width,collesioncheck2.height);
        return rect1.intersects(rect2);
    }


}
