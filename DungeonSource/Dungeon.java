import java.util.Scanner;

/// YOU ARE NOW COMITING THE FIRST CHANGE


/**
 * Title: Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * I.M. Knurdy
 *
 * History:
 *  11/4/2001: Wrote program
 *    --created DungeonCharacter class
 *    --created Hero class
 *    --created Monster class
 *    --had Hero battle Monster
 *    --fixed attack quirks (dead monster can no longer attack)
 *    --made Hero and Monster abstract
 *    --created Warrior
 *    --created Ogre
 *    --made Warrior and Ogre battle
 *    --added battleChoices to Hero
 *    --added special skill to Warrior
 *    --made Warrior and Ogre battle
 *    --created Sorceress
 *    --created Thief
 *    --created Skeleton
 *    --created Gremlin
 *    --added game play features to Dungeon.java (this file)
 *  11/27/2001: Finished documenting program
 * version 1.0
 */





// This class is the game execution
public class Dungeon
{

    public static void main(String[] args)
	{
        
		Hero theHero;
		Monster theMonster;

		do
		{
		    theHero = chooseHero();
		    theMonster = generateMonster();
			battle(theHero, theMonster);

		} while (playAgain());

    }//end main method

// lets you choose a desired hero
	public static Hero chooseHero()
	{
		int choice;
		Hero theHero;
        Scanner kb= new Scanner(System.in);
		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief");
		choice = kb.nextInt();

		switch(choice)
		{
			case 1: return new Warrior();

			case 2: return new Sorceress();

			case 3: return new Thief();

			default: System.out.println("invalid choice, returning Thief");
				     return new Thief();
		}
	}

	// randomly generate a monster
	public static Monster generateMonster()
	{
		int choice;

		choice = (int)(Math.random() * 3) + 1;

		switch(choice)
		{
			case 1: return new Ogre();

			case 2: return new Gremlin();

			case 3: return new Skeleton();

			default: System.out.println("invalid choice, returning Skeleton");
				     return new Skeleton();
		}
	}

    // continue game method
	public static boolean playAgain()
	{
		char again;
        Scanner kb=new Scanner(system.in);
		System.out.println("Play again (y/n)?");
		again = kb.next();

		return (again == 'Y' || again == 'y');
	}


    // the method that executes battle
	public static void battle(Hero theHero, Monster theMonster)
	{
		char pause = 'p';
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
		{
			Scanner kb= new Scanner(System.in);
		    //hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn 
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			//let the player quit
			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = kb.next();

		}//end battle loop

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}//end battle method


}//end Dungeon class