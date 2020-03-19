import java.util.*;


public abstract class Hero extends DungeonCharacter
{
	 private double chanceToBlock;
	 private int numTurns;
    public Room currentRoom;
    public int numHealthPotions;
    public int numVisionPotions;
    public ArrayList<String> principles;
    public Maze maze;

   public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax, String ATTACK_DESCRIPTION,
					 double chanceToBlock)
    {
	 super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, ATTACK_DESCRIPTION);
    this.chanceToBlock = chanceToBlock;
    this.setName(readName());
    }
  
   public double getChanceTobBlock(){return this.chanceToBlock;}
   public int getNumTurns(){return this.numTurns;}
   public void setNumTurns(int n){this.numTurns = n;}
   
   public void setCurrentRoom(Maze maze)
   {
      this.currentRoom = maze.maze[0][0];
   }

   public String readName()
   {
		System.out.print("Enter character name: ");
		Scanner kb = new Scanner(System.in);
      return kb.nextLine();
   }

   public boolean defend() {return Math.random() <= chanceToBlock;}

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

	public void battleChoices(DungeonCharacter opponent) 	{
	   numTurns = this.getAttackSpeed()/opponent.getAttackSpeed(); 
		if (numTurns == 0)
			numTurns++;
		System.out.println("Number of turns this round is: " + numTurns);
	}
   
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
        // Not done yet
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
      str = str + " and has the following OO Principles: /n";
      for (String s : principles){ str = str + s + "\n";}
      return str;
   }
   public void moveNorth()
   {
      if(currentRoom.yCord() == 0)
         System.out.println("You are on the top edge of the Dungeon. You cannot move North");
      else
         currentRoom = maze.maze[currentRoom.xCord()][currentRoom.yCord()+1];
   }
   
   public void moveSouth()
   {
      if(currentRoom.yCord() == 4)
         System.out.println("You are on the bottom edge of the Dungeon. You cannot move South");
      else
         currentRoom = maze.maze[currentRoom.xCord()][currentRoom.yCord()-1];
   }
   public void moveWest()
   {
      if(currentRoom.xCord() == 0)
         System.out.println("You are on the westmost edge of the Dungeon. You cannot move West");
      else
         currentRoom = maze.maze[currentRoom.xCord()-1][currentRoom.yCord()];
   }
   public void moveEast()
   {
      if(currentRoom.xCord() == 4)
         System.out.println("You are on the eastmost edge of the Dungeon. You cannot move east");
      else
         currentRoom = maze.maze[currentRoom.xCord()+1][currentRoom.yCord()];
   }
   
}//end Hero class