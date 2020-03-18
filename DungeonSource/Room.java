import java.util.ArrayList;

// A room will never have more than more than 2 things
public class Room
{
   private RoomThingDesc door; // hold exit or entrence;
   private Monster monster;
   public int xCord;
   public int yCord;
    
   public Room(Monster monster, RoomThingDesc door, int xCord, int yCord )
   {
      this.monster = monster;
      this.door = door;
      this.xCord = xCord;
      this.yCord = yCord;
   }
   
   public Monster getMonster(){return this.monster;}
   public int xCord() {return this.xCord;}
   public int yCord() {return this.yCord;}
   
   public String toString()
   {
      return "";
   }
   
    
   public void enter(Hero hero)
   {
      String roomString = this.toString();
      if (roomString.contains("vision")){hero.numVisionPotions++;}
      if (roomString.contains("health")){hero.numHealthPotions++;}
      if (roomString.contains("pit")){hero.encountersPit();}
   }
   
   public void printRoomToScreen()
   {
      boolean moreThanOneThing = false;

      String center ="need to make work";     
      String visualizedRoom = RoomEdges.chooseRoom(xCord,yCord, center);
   }

   
}