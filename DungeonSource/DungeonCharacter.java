
public abstract class DungeonCharacter implements Comparable
{

	private String name;
	private int hitPoints;
	private int attackSpeed;
	private double chanceToHit;
	private int damageMin, damageMax;
   private String ATTACK_DISCRIPTION;

	public  int compareTo(Object o) // I do not belive this method is ever called
   {
      return 1;
   }
	
	public DungeonCharacter(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax, String ATTACK_DISCRIPTION)
	{
		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
      this.ATTACK_DISCRIPTION = ATTACK_DISCRIPTION;
	}
   
   public void setName(String s)
   {
      this.name = s;
   }
   
	public String getName()
	{
		return name;
	}
   
	public int getHitPoints()
	{
		return hitPoints;
	}
   
	public int getAttackSpeed()
	{
		return attackSpeed;
	}
   
   public double getChanceToHit()
   {
      return chanceToHit;
   }
   
   public int getDamageMin()
   {
      return damageMin;
   }
   
   public int getDamageMax()
   {
      return damageMax;
   }

	public void addHitPoints(int hitPoints)
	{
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		else
		{
			this.hitPoints += hitPoints;
		}
	}
   
	public void subtractHitPoints(int SubhitPoints)
	{
		if (SubhitPoints <0)
			System.out.println("Hitpoint amount must be positive.");
		else if (SubhitPoints >0)
		{
			this.hitPoints -= SubhitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			System.out.println(this.getName() + " hit " +
								" for <" + SubhitPoints + "> points damage.");
			System.out.println(this.getName() + " now has " +
								this.getHitPoints() + " hit points remaining.");
			System.out.println();
		}

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");
	}

   public boolean isAlive()
	{
	  return (hitPoints > 0);
	}

	public void attack(DungeonCharacter opponent)
	{
		boolean canAttack;
		int damage;
      
      System.out.println(name + ATTACK_DISCRIPTION +
							opponent.getName() + ":");


		canAttack = Math.random() <= this.chanceToHit;

		if (canAttack)
		{
			damage = (int)(Math.random() * (this.damageMax - this.damageMin + 1))
						+ damageMin ;
			opponent.subtractHitPoints(damage);
			System.out.println();
		}
		else
		{

			System.out.println(this.getName() + "'s attack on " + opponent.getName() +
								" failed!");
			System.out.println();
		}
	}
}//end class Character

/*
CHANGES MADE

 1. Made all variables private and created get() methods.

2. renamed hitPoints to SubhitPoints in subtractHitPoints(int SubhitPoints) method 
    changed method calls to be this.getHitPoints() rather than getHitPoints(). 
      This is to make the code more readable
      
3. deleted comments that did not communicate anything and the lines between methods.
//-----------------------------------------------------------------

4. Renamed DungeonCharacter to CharcterStats

5. Removed white space from various methods.

6. Created setName(method) that replaces the KeyboardClass

*/


