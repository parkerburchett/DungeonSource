import java.util.*;


public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private int numTurns;
   private Room currentRoom;
   public int numHealthPotions;
   public int numVisionPotions;
   public ArrayList<RoomThing> principles;

  public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax, String ATTACK_DESCRIPTION,
					 double chanceToBlock)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, ATTACK_DESCRIPTION);
	this.chanceToBlock = chanceToBlock;
	this.setName(readName());
  }
  
  public double getChanceTobBlock()
  {
   return this.chanceToBlock;
  }
  
  public int getNumTurns()
  {
   return this.numTurns;
  }
  
  public void setNumTurns(int n)
  {
   this.numTurns = n;
  }

  public String readName()
  {
		System.out.print("Enter character name: ");
		Scanner kb = new Scanner(System.in);
      return kb.nextLine();
  }

  public boolean defend()
  {
		return Math.random() <= chanceToBlock;
  }

public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(this.getName() + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}
	}


	public void battleChoices(DungeonCharacter opponent) // HE WANTS US TO REWORK THIS FOR ANOTHER METHOD
	{
	    numTurns = this.getAttackSpeed()/opponent.getAttackSpeed(); // I do not understand what this does. 

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices
   
   public void encountersPit()
   {  
      super.subtractHitPoints(0);
   }
   
   public void useVisionPotion()
   {
      if (numVisionPotions <= 0)
         System.out.println("You cannot use a vison potion when you have none");  
      else
      {
        //logic here to print out all the ajacent rooms
        //Seems complicated
        //I think the easiest way is to in Dungeon.java there is a Room[]
        // do some basic math to get the cordinates and if the cordinates do not exist the do not print it
      }
   }
}//end Hero class