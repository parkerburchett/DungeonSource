import java.util.*;

/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 *  from DungeonCharacter.  A Hero has battle choices: regular attack and a
 *  special skill which is defined by the classes derived from Hero.
 *
 *  class variables (all are directly accessible from derived classes):
 *    chanceToBlock -- a hero has a chance to block an opponents attack
 *    numTurns -- if a hero is faster than opponent, their is a possibility
 *                for more than one attack per round of battle
 *
 *  class methods (all are public):
 *    public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	  public void readName()
	  public boolean defend()
	  public void subtractHitPoints(int hitPoints)
	  public void battleChoices(DungeonCharacter opponent)

 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private int numTurns;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
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

/*-------------------------------------------------------
readName obtains a name for the hero from the user

Receives: nothing
Returns: nothing

This method calls: nothing
This method is called by: hero constructor
---------------------------------------------------------*/
  public String readName()
  {
		System.out.print("Enter character name: ");
		Scanner kb = new Scanner(System.in);
      return kb.nextLine();
  }//end readName method

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

/*-------------------------------------------------------
battleChoices will be overridden in derived classes.  It computes the
number of turns a hero will get per round based on the opponent that is
being fought.  The number of turns is reported to the user.  This stuff might
go better in another method that is invoked from this one...

Receives: opponent
Returns: nothing

This method calls: getAttackSpeed()
This method is called by: external sources
---------------------------------------------------------*/
	public void battleChoices(DungeonCharacter opponent) // HE WANTS US TO REWORK THIS FOR ANOTHER METHOD
	{
	    numTurns = this.getAttackSpeed()/opponent.getAttackSpeed(); // I do not understand what this does. 

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices

}//end Hero class

/*
Changes Made

1. Made variables private and created get() methods

2. Rewrote readName() to return a string and then get passed into this.setName(). 

3. battleChoices() was edited to use get() methods

4. TODO remove BattleChoices and replace it with a method called calculateTurns() 
   5. Make the child classes not call super Battle Choices but instead calculate Turns.


*/