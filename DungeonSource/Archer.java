import java.util.Scanner;

public class Archer extends Hero
{
    public Archer()
	{
		super("Archer", 150, 3, .7, 45, 63, " shoots an arrow at ", .21);
    }

	public void magicArrow(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int magicArrow = (int)(Math.random() * 50) + 80;
			System.out.println(getName() + " lands a MagicArrow for" + magicArrow
								+ " damage!");
			opponent.subtractHitPoints(magicArrow);
		}
		else
		{
			System.out.println(getName() + " failed to hit a magic Arrow ");
			System.out.println();
		}
	}

    public void battleChoices(DungeonCharacter opponent)
	{
		int choice;

		super.battleChoices(opponent);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Magic Arrow at Oppnent");
		    System.out.print("Choose an option: ");
		    Scanner kb =  new Scanner(System.in);
		    choice = kb.nextInt();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: magicArrow(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			setNumTurns(getNumTurns() -1);
			if (getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());

		} while(getNumTurns() > 0);

    }//end battleChoices method

}//end Hero class
