
public class RoomThingFactory
{
	public RoomThingFactory factory;
	
	public RoomThingFactory()
	{
	}
	public RoomThingDesc createPit()
	{
	      return new Pit();
	}
	public RoomThingDesc createEmpty()
	{
		return new Empty();
	}
	public RoomThingDesc createHealingPotion()
	{
		return new HealingPotion();
	}
   public RoomThingDesc createVisionPotion()
   {
	   return new VisionPotion();
   }
   public RoomThingDesc createMonsterEncounter()
   {
	   return new MonsterEncounter();
   }
   public RoomThingDesc createPillar1()
   {
	   return new Pillar1();
   }
   public RoomThingDesc createPillar2()
   {
	  return new Pillar2();
   }
   public RoomThingDesc createPillar3()
   {
	   return new Pillar3();
   }
   public RoomThingDesc createPillar4()
   {
	   return new Pillar4();
   }

   public RoomThingDesc CreateEntrance()
   {
	   return new Entrance();
   }
   public RoomThingDesc CreateExit()
   {
	   return new Exit();
   }
}

