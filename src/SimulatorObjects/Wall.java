/*
 * Copyright (c) 2020.
 * Created by Andrew Pegg
 */

package SimulatorObjects;

import Movement.CollisionCheck;

import javax.swing.*;

public class Wall extends CollisionCheck {
    ImageIcon image;
    public  boolean visible;
    public boolean  vertical;

    public  Wall(int x, int y , boolean vertical , String imagepath )
    {
        this.x = x; // sets where the wall will be placed
        this.y = y;//set where the wall will be placed
        ImageLoader(imagepath); // grabs the image from the image path given by string
        ObjectSize();
        this.vertical = vertical;


    }
    private void ImageLoader(String imagepath)  { //loader
        
            this.image = new ImageIcon(getClass().getClassLoader().getResource(imagepath));
       
    }
    private  void ObjectSize() // width height setter
    {
        this.width = image.getIconWidth();
        this.height = image.getIconHeight();

    }
    public ImageIcon getImageIcon() // getter from imageicon
    {
        return image;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }

    public boolean isVisible() { // getter
        return visible;
    }
    public  void setVisible(boolean visible) //setter
    {
        this.visible = visible;
    }

}
