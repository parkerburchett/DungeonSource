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
            Room[][] theMaze = new Room[5][5];
            for(int i = 0 ; i < 5 ; i++){
                for(int j = 0 ; j < 5 ; j++){
                    theMaze[i][j] = new Room(addMonster() , entranceExit(i,j) , j ,i);
                }
            }
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

                return new Exit();
            }
            if(!entranceMade && exitMade && getRandomChance(10)){
                this.currrentLocation = maze[x][y];
                return new Entrance();
            }
            if(x == 4 && y == 4 && !entranceMade){
                this.currrentLocation = maze[x][y];
                return new Entrance();
            }
            if(x == 4 && y == 3 && !exitMade){

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
            Random random = new Random();
            int ranInt = random.nextInt() % 5;
            if(ranInt == 1)
                return new Skeleton();
            else if(ranInt == 2)
                return new Gremlin();
            else if(ranInt == 3)
                return new Ogre();
            else if(ranInt == 4)
                return new Gremlin();
            else
                return new Dragon();
        }

        private boolean getRandomChance(int percentChance){
            Random random = new Random();
            int ranInt = random.nextInt() % percentChance;
            if(percentChance > ranInt)
                return true;
            return false;
        }
}
