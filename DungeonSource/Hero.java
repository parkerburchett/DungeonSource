import java.util.*;


public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private int numTurns;
   private Room currentRoom;
   private int numHealthPotions;
   private int numVisionPotions;
   private ArrayList<RoomThing> principles;

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

}//end Hero class
