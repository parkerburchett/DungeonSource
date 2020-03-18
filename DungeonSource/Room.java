import java.util.ArrayList;


// A room will never have more than more than 2 things
public class Room
{
    private RoomThingDesc door; // hold exit or entrence;
    private Monster monster;

    private int xCord;
    private int yCord;

    //private Room north , south , east , west;

   //Added desc to door
   public Room(Monster monster, RoomThingDesc door, int xCord, int yCord )
   {
      this.monster = monster;
      this.door = door;
      this.xCord = xCord;
      this.yCord = yCord;

      /*
      this.north = north;
      this.south = south;
      this.east = east;
      this.west = west;
       */
   }
   
   public int xCord()
   {
      return xCord;
   }
   public int yCord()
   {
      return yCord();
   }

   @Override
   public String toString()
   {
       String str;
       if (door != null)//??
         str = "You have entered a room at " ;


       else 
       {
         //str = "You have entered an " + door.toString() + " at ";
           str = door.toString();
       }

       str += Integer.toString(xCord) + ", " + Integer.toString(yCord)+ "\n";
       
       if (monster== null)
       {
         str += "There are no Monsters here";
       }
       else
       {
         str += "Oh goodness! There is a " + monster.toString() +" in this room! \n";
       }

       /*
       //condition was other.size == 0
       if (other == null)
       {
         str += "There are no items in this room";
       }

       else
       {
         for(RoomThingDesc s : other)
         {
            str += "There is a " + s.toString() +"\n";
         }
       }

        */
        return str;
    }
   
    
   public void enter(Hero hero)
   {
      // adjust the hero's stats here eg vision potion and where the monster batle happens
      // for checking conditions in the room run a this.toString().contains(keyword) on the room has a pit or a monster or a healthPotion.
      // this do the hero.interact() in the enters method
      String roomString = this.toString();
      
      if (roomString.contains("vision"))
      {
         hero.numVisionPotions++;
      }
      if (roomString.contains("health"))
      {
         hero.numHealthPotions++;
      }
      if (roomString.contains("pit"))
      {
         hero.encountersPit();
      }
   }

   public Monster getMonster(){return this.monster;}
}