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
      System.out.print("you've fallen into a pit");
	   int ran=(int)(Math.random()*20);
	   int damage=0-ran;
      super.subtractHitPoints(damage);
   }
   
   public void useVisionPotion()
   {
      if (numVisionPotions <= 0)
         System.out.println("You cannot use a vison potion when you have none");  
      else
      {
        // this should call a method in the Dungeon class where to pass in the current params and then it prints everything
        this.numVisionPotions--;
      }    
   }
   
   public void useHealthPotion()
   {
   int ran=(int)(Math.random()*15);
	if(ran<5)
		ran=5;
	addHitPoints(ran);
   System.out.println("You have used a health potion.");
   System.out.println("Your health is now: "+ Integer.toString(getHitPoints()));
   }
   
   public String getHeroStatus() // untested
   {
      String str = this.getName() + " is in room: (" + Integer.toString(currentRoom.xCord()) + ", " + Integer.toString(currentRoom.yCord())+ ") \n";
      str = str + "Has " + Integer.toString(numHealthPotions) + " health potions.\n";
      str = str + "Has " + Integer.toString(numVisionPotions) + " vision potions.\n";
      str = str + "And has the following Object Orianted Principles: /n";
      for (RoomThing s : principles)
      {
         str = str + s.toString() + "\n";
      }
      return str;
   }
   
   public void isDead()
   {
      if (getHitPoints() <= 0)
      {
         System.out.println("You are dead. Program should now off you to go again. Unsure Where that should live");
      }
   }
}//end Hero class