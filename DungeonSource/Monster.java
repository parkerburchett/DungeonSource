public abstract class Monster extends DungeonCharacter
{
	private double chanceToHeal;
	private int minHeal, maxHeal;

//-----------------------------------------------------------------
  public Monster(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, double chanceToHeal,
					 int damageMin, int damageMax, String ATTACK_DISCRIPTION,
					 int minHeal, int maxHeal)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, ATTACK_DISCRIPTION);
	this.chanceToHeal = chanceToHeal;
	this.maxHeal = maxHeal;
	this.minHeal = minHeal;

  }//end monster construcotr

  public void heal()
  {
	boolean canHeal;
	int healPoints;

	canHeal = (Math.random() <= chanceToHeal) && (this.getHitPoints() > 0);

	if (canHeal)
	{
		healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
		addHitPoints(healPoints);
		System.out.println(this.getName() + " healed itself for " + healPoints + " points.\n"
							+ "Total hit points remaining are: " + this.getHitPoints());
		System.out.println();
	}


  }

 public void subtractHitPoints(int hitPoints)
 {
		super.subtractHitPoints(hitPoints);
		this.heal();
 }

}
