
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
   public RoomThingDesc CreateMonsterEncounter()
   {
	   return new MonsterEncounter();
   }
   public RoomThingDesc CreatePillar1()
   {
	   return new Pillar1();
   }
   public RoomThingDesc CreatePillar2()
   {
	  return new Pillar2();
   }
   public RoomThingDesc CreatePillar3()
   {
	   return new Pillar3();
   }
   public RoomThingDesc CreatePillar4()
   {
	   return new Pillar4();
   }
   public RoomThingDesc CreateNorthDoor()
   {
	   return new NorthDoor();
   }
   public RoomThingDesc CreateEastDoor()
   {
	   return new EastDoor();
   }
   public RoomThingDesc CreateSouthDoor()
   {
	 return new SouthDoor();
   }
   public RoomThingDesc CreateWestDoor()
   {
	  return new WestDoor();
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

