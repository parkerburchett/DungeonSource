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

   @Override
   public String toString()
   {
      return null;
   }
   
    
   public void enter(Hero hero)
   {
      // adjust the hero's stats here eg vision potion and where the monster batle happens
      // for checking conditions in the room run a this.toString().contains(keyword) on the room has a pit or a monster or a healthPotion.
      // this do the hero.interact() in the enters method
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

   public Monster getMonster(){return this.monster;}
}