import java.util.*;
public class Maze {
        private Room[][] maze = new Room[5][5];
        private MonsterFactory mf = new MonsterFactory();
        private RoomThingFactory rf = new RoomThingFactory();
        private Hero theHero;
        public Room currrentLocation , exit;
        private boolean entranceMade = false;
        public boolean exitMade = false;


        public Maze(Hero theHero){
            maze = buildDungeon();
            this.theHero = theHero;
        }

        public Room[][] buildDungeon(){

            Room c0r0 = new Room(addMonster() ,entranceExit(0,0) ,0,0);
            Room c0r1 = new Room(addMonster() ,entranceExit(0,1) ,1,0);
            Room c0r2 = new Room(addMonster() ,entranceExit(0,2) ,2,0);
            Room c0r3 = new Room(addMonster() ,entranceExit(0,3) ,3,0);
            Room c0r4 = new Room(addMonster() ,entranceExit(0,4) ,4,0);
            Room c1r0 = new Room(addMonster() ,entranceExit(1,0) ,0,1);
            Room c1r1 = new Room(addMonster() ,entranceExit(1,1) ,1,1);
            Room c1r2 = new Room(addMonster() ,entranceExit(1,2) ,2,1);
            Room c1r3 = new Room(addMonster() ,entranceExit(1,3) ,3,1);
            Room c1r4 = new Room(addMonster() ,entranceExit(1,4) ,4,1);
            Room c2r0 = new Room(addMonster() ,entranceExit(2,0) ,0,2);
            Room c2r1 = new Room(addMonster() ,entranceExit(2,1) ,1,2);
            Room c2r2 = new Room(addMonster() ,entranceExit(2,2) ,2,2);
            Room c2r3 = new Room(addMonster() ,entranceExit(2,3) ,3,2);
            Room c2r4 = new Room(addMonster() ,entranceExit(2,4) ,4,2);
            Room c3r0 = new Room(addMonster() ,entranceExit(3,0) ,0,3);
            Room c3r1 = new Room(addMonster() ,entranceExit(3,1) ,1,3);
            Room c3r2 = new Room(addMonster() ,entranceExit(3,2) ,2,3);
            Room c3r3 = new Room(addMonster() ,entranceExit(3,3) ,3,3);
            Room c3r4 = new Room(addMonster() ,entranceExit(3,4) ,4,3);
            Room c4r0 = new Room(addMonster() ,entranceExit(4,0) ,0,4);
            Room c4r1 = new Room(addMonster() ,entranceExit(4,1) ,1,4);
            Room c4r2 = new Room(addMonster() ,entranceExit(4,2) ,2,4);
            Room c4r3 = new Room(addMonster() ,entranceExit(4,3) ,3,4);
            Room c4r4 = new Room(addMonster() ,entranceExit(4,4) ,4,4);
            Room[][] theMaze = new Room[][]{{c0r0, c0r1, c0r2, c0r3, c0r4}, {c1r0, c1r1, c1r2, c1r3, c1r4},
                    {c2r0, c2r1, c2r2, c2r3, c2r4}, {c3r0, c3r1, c3r2, c3r3, c3r4},
                    {c4r0, c4r1, c4r2, c4r3, c4r4}};
            return theMaze;
        }

        public void moveNorth(){
            currrentLocation = maze[currrentLocation.xCord()][currrentLocation.yCord() - 1];
        }
        public void moveSouth(){
            currrentLocation = maze[currrentLocation.xCord()][currrentLocation.yCord() + 1];
        }
        public void moveEast(){
            currrentLocation = maze[currrentLocation.xCord() + 1][currrentLocation.yCord()];
        }
        public void moveWest(){
            currrentLocation = maze[currrentLocation.xCord() - 1][currrentLocation.yCord()];
        }

        public Monster getMonster(Room currentLocation){
            return this.currrentLocation.getMonster();
        }

        public RoomThingDesc entranceExit(int x, int y){
            if(entranceMade && exitMade)
                return null;
            if(entranceMade && !exitMade && getRandomChance(10)){
                maze[x][y].setMonsterNull();
                return new Exit();
            }
            if(!entranceMade && exitMade && getRandomChance(10)){
                maze[x][y].setMonsterNull();
                return new Entrance();
            }
            if(x == 4 && y == 4 && !entranceMade){
                maze[x][y].setMonsterNull();
                return new Entrance();
            }
            if(x == 4 && y == 3 && !exitMade){
                maze[x][y].setMonsterNull();
                return new Exit();
            }
            return null;
        }

        public Monster addMonster(){
            if(getRandomChance(25)){
                return randomMonster();
            }
            return null;
        }

        public Monster randomMonster(){
            int random = (int)Math.random() * 5;
            if(random == 1)
                return new Skeleton();
            else if(random == 2)
                return new Gremlin();
            else if(random == 3)
                return new Ogre();
            else if(random == 4)
                return new Gremlin();
            else
                return new Dragon();
        }

        private boolean getRandomChance(int percentChance){
            int random = (int)Math.random() * 100;
            if(percentChance > random)
                return true;
            return false;
        }
}
