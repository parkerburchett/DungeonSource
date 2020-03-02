// this is a data class to keep all of the relevent character statistcs for monsters and heros.
// We need to create a simple Monsterfactory that creates the different types of monsters.
// this way it is easy to extend and add more monster types.


public class CharacterStat
{
    protected String name;
  	protected int hitPoints;
  	protected int attackSpeed;
  	protected double chanceToHit;
  	protected int damageMin, damageMax;

    public CharacterStat(String name, int hitPoints, int attackSpeed,
  				     double chanceToHit, int damageMin, int damageMax)
               {
                this.name = name;
             		this.hitPoints = hitPoints;
             		this.attackSpeed = attackSpeed;
             		this.chanceToHit = chanceToHit;
             		this.damageMin = damageMin;
             		this.damageMax = damageMax;
               }

      public characterStat Gremlin()
      {

      }



}
