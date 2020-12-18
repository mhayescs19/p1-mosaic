package SimulatorObjects;

import Movement.Collesioncheck;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Wall extends Collesioncheck {
    ImageIcon image;
    public  boolean visible;
    public boolean  vertical;

    public  Wall(int x, int y , boolean vertical , String imagepath )
    {
        this.x = 0; // sets where the wall will be placed
        this.y = 0;//set where the wall will be placed
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

    public boolean isVisible() { // getter
        return visible;
    }
    public  void setVisible(boolean visible) //setter
    {
        this.visible = visible;
    }

}