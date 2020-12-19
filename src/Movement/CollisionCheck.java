/*

    Created 12/14/2020
    Andrew Pegg

 */
package Movement;

import java.awt.*;

public class CollisionCheck {
    protected int x, y; //position
    protected int width, height; // object height and width
    public CollisionCheck(int x , int y, int width, int height) // good for walls maybe
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public CollisionCheck()
    {

    }

    public boolean collision(CollisionCheck collisionCheck2)
    {
        Rectangle rect1 = new Rectangle(x,y,width,height);
        Rectangle rect2 = new Rectangle(collisionCheck2.x, collisionCheck2.y, collisionCheck2.width, collisionCheck2.height);
        return rect1.intersects(rect2);
    }


}
