import java.util.*;
public class Maze {
        private ArrayList<ArrayList<Room>> maze;
        private MonsterFactory mf = new MonsterFactory();
        private RoomThingFactory rf = new RoomThingFactory();
        private Hero theHero;

        public Maze(Hero theHero){
            maze = buildDungeon2();
            this.theHero = theHero;
        }

        public ArrayList<ArrayList<Room>> buildDungeon2(){
            /*
            maze map
            1           2            3         4
            entrance    empty       pil1       vision
            skeleton    empty       heal       grimlin
            heal pot    empty       pil2       pil4/ogre
            pit         pit         empty      exit
             */


            //Column 1
            Room col0row0 = new Room(null , rf.CreateEntrance(), null , 0,0);
            Room col0row1 = new Room(mf.createSkeleton() , null , null , 0 ,1);
            Room col0row2 = new Room(null , null , null , 0 , 2);
            Room col0row3 = new Room(null , null , null , 0 , 3);
            ArrayList<Room> c0 = new ArrayList<Room>();
            c0.add(col0row0); c0.add(col0row1); c0.add(col0row2); c0.add(col0row3);

            //Column 2
            Room col1row0 = new Room(null , null , null , 1 , 0);
            Room col1row1 = new Room(null , null , null , 1 , 1);
            Room col1row2 = new Room(null , null , null , 1 , 2);
            Room col1row3 = new Room(null , null , null , 1 , 3);
            ArrayList<Room> c1 = new ArrayList<Room>();
            c1.add(col1row0); c1.add(col1row1); c1.add(col1row2); c1.add(col1row3);

            //Column 3
            Room col2row0 = new Room(mf.createGremlin() , null , null , 2 , 0);
            Room col2row1 = new Room(null , null , null , 2 , 1);
            Room col2row2 = new Room(null , null , null , 2 , 2);
            Room col2row3 = new Room(null , null , null , 2 , 3);
            ArrayList<Room> c2 = new ArrayList<Room>();
            c2.add(col2row0); c2.add(col2row1); c2.add(col2row2); c2.add(col2row3);

            //Column 4
            Room col3row0 = new Room(null , null , null , 3 , 0);
            Room col3row1 = new Room(mf.createGremlin() , null , null , 3 , 1);
            Room col3row2 = new Room(mf.createOgre() , null , null , 3 , 2);
            Room col3row3 = new Room(null , rf.CreateExit() , null , 3 , 3);
            ArrayList<Room> c3 = new ArrayList<Room>();
            c3.add(col3row0); c3.add(col3row1); c3.add(col3row2); c1.add(col3row3);

            maze.add(c0);
            maze.add(c1);
            maze.add(c2);
            maze.add(c3);

            return maze;
        }

        public void moveNorth(){

        }
        public void moveSouth(){

        }
        public void moveEast(){

        }
        public void moveWest(){

        }
}
