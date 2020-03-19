import java.util.*;

public class Room
{
   private boolean hasExit;
   private boolean hasEntrance;
   
   private Monster monster;
   private int xCord;
   private int yCord;
   
   public boolean hasPit;
   public boolean hasVisionPotion;
   public boolean hasHealthPotion;
   
   public String OOprinciple;
       
   public Room(boolean exit, boolean entrance, String principle, int xCord, int yCord )
   {
      this.hasExit = exit;
      this.hasEntrance = entrance;
      this.OOprinciple = principle;
      this.xCord = xCord;
      this.yCord = yCord;
      
      if(this.hasExit == false && this.hasEntrance == false)
      { 
         if(getRandomChance(25))
            this.monster = randomMonster();
         this.hasPit = getRandomChance(10);
         this.hasVisionPotion = getRandomChance(10);
         this.hasHealthPotion = getRandomChance(10);
      }
   }
   
   public Monster getMonster(){return this.monster;}
   public int xCord() {return this.xCord;}
   public int yCord() {return this.yCord;}
     
   public void printRoomToScreen()
   {
      String center;
      if (hasPit)
         center ="P";
      else if(hasHealthPotion)
         center = "H";
      else if(hasVisionPotion)
         center = "V";
      else if(monster != null)
         center = "M";
      else if (OOprinciple != null)
         center = "X";
      else if (hasExit)
         center = "O" ;
      else if(hasEntrance)
         center = "I";
      else
         center = "M";
             
      String visualizedRoom = RoomEdges.chooseRoom(xCord,yCord, center);
   }
   private boolean getRandomChance(int percentChance)
   {
      Random random = new Random();
      int ranInt = random.nextInt() % percentChance;
      if(percentChance > ranInt)
          return true;
      return false;
   }
   public Monster randomMonster()
   {
      Random random = new Random();
      int ranInt = random.nextInt() % 5;
      MonsterFactory f = new MonsterFactory();
      if(ranInt == 1)
          return f.createSkeleton();
      else if(ranInt == 2)
          return f.createGremlin();
      else if(ranInt == 3)
          return f.createDragon();
      else if(ranInt == 4)
          return f.createOgre();
      else
          return f.createGhoul();
   }


   
}