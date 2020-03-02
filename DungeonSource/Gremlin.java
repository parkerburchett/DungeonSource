
public class Gremlin extends Monster
{

    public Gremlin()
	{
		super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);

    }

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(this.getName() + " jabs his kris at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}


}
/* 
Changes Made

changed name to getName() methods

Removed comments that did not communicate anything


*/