
public class MonsterFactory
{

  public MonsterFactory factory;

   public MonsterFactory()
   {
   }

   public Monster createGremlin()
   {
      return new Gremlin();
   }

   public Monster createOgre()
   {
      return new Ogre();
   }
   
   public Monster createSkeleton()
   {
      return new Skeleton();
   }
}


/* 
Changes Made

This is a whole new Factory

*/