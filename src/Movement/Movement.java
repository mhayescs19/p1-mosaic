/*

    Created 12/14/2020
    Andrew Pegg

 */
package Movement;
import java.util.Random;
import java.util.stream.IntStream;

/*
        abstract classes can not be instantiated are used by many classes as almost like a parent
 */
public abstract class Movement extends CollisionCheck {

    public int xEnd, yEnd;
    public int vx , vy;


      public Movement()
      {

          // xEnd , yEnd set to boarders of the screen
          // set vx and vy to speeds
          // x and y velocity will random depenging on objcet
          this.width =0;
         this.height =0;
          Genvelo();
          GenXY();

      }

        public void Velcoity()
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
        public void Velcoity0() //stop condtion maybe good for death
        {
            vx =0;
            vy=0;
        }
        private void Genvelo()
        {
            Random random = new Random(System.currentTimeMillis());
            IntStream intStream = random.ints(2,0,10); // get two random ints range 0 to 10 or 9 idr
            int[] array = intStream.toArray(); // cast to array
            vx = array[0];
            vy = array[1];
        }
        private void GenXY()
        {
            Random random = new Random(System.currentTimeMillis());
            x = random.nextInt(xEnd);
            y = random.nextInt(yEnd);
        }




}
