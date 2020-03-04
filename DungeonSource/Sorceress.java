import java.util.*;

public class Sorceress extends Hero
{
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

//-----------------------------------------------------------------
    public Sorceress()
	{
		super("Sorceress", 75, 5, .7, 25, 50, .3);
    }//end constructor

//-----------------------------------------------------------------
	public void increaseHitPoints()
    {
	    int hitPoints;

		hitPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hitPoints);
		System.out.println(getName() + " added [" + hitPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ hitPoints);
		 System.out.println();

    }//end increaseHitPoints method

//-----------------------------------------------------------------
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(this.getName() + " casts a spell of fireball at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

//-----------------------------------------------------------------
    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Increase Hit Points");
		    System.out.print("Choose an option: ");
		    Scanner kb =  new Scanner(System.in);
          choice = kb.nextInt();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: increaseHitPoints();
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			setNumTurns(getNumTurns() -1);
		    if (getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());

		} while(getNumTurns() > 0 && getHitPoints() > 0 && opponent.getHitPoints() > getNumTurns() );

    }//end overridden method

}//end class

/*

1. reWrote add Hitpoints to use getName() methods
 

2. re wrote battleChoices to use get() and Scanner instead of Keyboard

3. TODO rewrite Battle choices where you pass in the speical ability and the String of the attack. 
   This is to remove duplicate Code

*/