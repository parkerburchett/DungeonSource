public  class things implements RoomThing
{
 
 public int Pit()
 {
	System.out.print("you've fallen into a pit");
	int ran=(int)(Math.random()*20);
	int damage=0-ran;
	return damage;
	
 }
 public void Empty()
 {
	 System.out.print("the room is empty");
 }
public int HealingPotion()
{
	int ran=(int)(Math.random()*15);
	if(ran<5)
		ran=5;
	int hp;
	hp=ran;
	return hp;
	
}
public void VisionPotion()
{
	System.out.print("you've found a vision potion");
}
public void Monster()
{
	System.out.print("You have found a monster");
}
public int Pillar1()
{
	System.out.print("you've found the pillar of Abstraction");
	int res= 1;
	return res;
}
public int Pillar2()
{
	System.out.print("You've found the pillar of Encapsulation");
	int res= 1;
	return res;
}
public int Pillar3()
{
	System.out.print("You've found the pillar of Inheritance");
	int res= 1;
	return res;
}
public int Pillar4()
{
	System.out.print("You've found the pillar of Polymorphism");
	int res= 1;
	return res;
}
}