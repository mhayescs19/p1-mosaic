/*

    Created 12/14/2020
    Andrew Pegg

 */
package Movement;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * An abstract class that tracks the position of objects that extend it
 * @see CollisionCheck
 * @see SimulatorObjects.Person
 *
 */
//abstract classes can not be instantiated are used by many classes as almost like a parent
public abstract class Movement extends CollisionCheck {

    public int xEnd, yEnd;
    public int vx , vy;

    /**
     * default constructor for Movement
     */
      public Movement()
      {

          // xEnd , yEnd set to boarders of the screen
          // set vx and vy to speeds
          // x and y velocity will random depending on object
          this.width =50;
         this.height =50;
          Genvelo();
          GenXY();

      }
    public Movement(int width , int height)
    {

        // xEnd , yEnd set to boarders of the screen
        // set vx and vy to speeds
        // x and y velocity will random depending on object
        xEnd = width;
        yEnd = height;
        this.width =50;
        this.height =50;
        Genvelo();
        GenXY();

    }

        public void Velocity()
        {
            this.x +=vx;
            this.y+=vy;
            if (this.x<0||this.x>xEnd)
            {
                vx*=-1;
            }
            if (this.y<0||this.y>yEnd)
            {
                vy *=-1;
            }
        }
        public void Velocity0() //stop condtion maybe good for death
        {
            vx =0;
            vy=0;
        }

    /**
     * generates the velocity for the object
     */
    private void Genvelo()
        {
            Random random = new Random();
            IntStream intStream = random.ints(2,0,10); // get two random ints range 0 to 10 or 9 idr
            int[] array = intStream.toArray(); // cast to array
            vx = array[0];
            vy = array[1];
        }

    /**
     * Generates x and y cords for the location of the object on the panel
     * @see #Movement()
     *
     */
    private void GenXY()
        {
            Random random = new Random();
            x = random.nextInt(xEnd); // set to zero needs to be set to boundary of the screen
            y = random.nextInt(yEnd);
        }
        public void CollisionHorizontal()
        {
            vx*=-1;
        }
        public void CollisionVertical()
        {
            vy*=-1;
        }






}
