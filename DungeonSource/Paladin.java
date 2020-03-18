import java.util.Scanner;

public class Paladin extends Hero
{
    public Paladin()
	{
		super("Paladin", 160, 2, .65, 42, 61, " strikes with a noble sword ", .3);
    }

	public void blessedBlade(DungeonCharacter opponent)
	{
		if (Math.random() <= .2)
		{
			int blessedBlade = (int)(Math.random() * 50) + 80;
			System.out.println(getName() + " hits with a holy relic" + blessedBlade
								+ " damage!");
			opponent.subtractHitPoints(blessedBlade);
		}
		else
		{
			System.out.println(getName() + " missed with his blessed blade");
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
		    System.out.println("2. Smash with Holy Relic ");
		    System.out.print("Choose an option: ");
		    Scanner kb =  new Scanner(System.in);
		    choice = kb.nextInt();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: blessedBlade(opponent);
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
