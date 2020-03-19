import java.util.*;
public class Maze {
        public  Room[][] maze = new Room[5][5];
        private Hero theHero;
        public Room currrentLocation, exit;

        public Maze(Hero theHero){
            this.maze = buildDungeon();
            this.theHero = theHero;
        }

        public Room[][] buildDungeon()
        {
            Random r = new Random();
            int entranceKey = 0;
            int exitKey;
            do
            {
            exitKey = r.nextInt(5) + r.nextInt(5) *10;
            }while(entranceKey == exitKey); // at this point entrenace and exit Key point to unique rooms
            
            int[] whereOOPrinciplesWillBe = new int[4];
            
            for(int i= 0; i<4; i++)
            {
               whereOOPrinciplesWillBe[i] = i + (r.nextInt(5) * 10); // pseudorandom The OOprinciples will never have the same xCords. this makes it much easier to be unique.
               do
               {
                  whereOOPrinciplesWillBe[i] = i + (r.nextInt(5) * 10);
               }while(whereOOPrinciplesWillBe[i] == entranceKey && whereOOPrinciplesWillBe[0] == exitKey);
            }
            
            // at this point all of the keys are unique.
            Room[][] maze = new Room[5][5];
            for (int x = 0; x < 5; x++)
               for(int y =0; y < 50; y= y+10)
               {
                  if (x+y == exitKey)
                     maze[x][y/10] = new Room(true, false, null, x, y/10);
                  else if (x+y == entranceKey)
                     maze[x][y/10] = new Room(false, true, null, x, y/10);
                  else if (x+y == whereOOPrinciplesWillBe[0])
                     maze[x][y/10] = new Room(false, false, "Abstraction", x, y/10);
                  else if (x+y == whereOOPrinciplesWillBe[1])
                     maze[x][y/10] = new Room(false, false, "Inheritance", x, y/10);
                  else if (x+y == whereOOPrinciplesWillBe[2])
                     maze[x][y/10] = new Room(false, false, "Polymorphism", x, y/10);
                  else if (x+y == whereOOPrinciplesWillBe[3])
                     maze[x][y/10] = new Room(false, false, "Encapsulation", x, y/10);
                  else
                     maze[x][y/10] = new Room(false, false, null, x, y/10);
               }          
            return maze;
        }
        
    public Room getRoom(int xCord, int yCord)
    {
      return maze[xCord][yCord];
    }
}