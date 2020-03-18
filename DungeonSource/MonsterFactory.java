public class MonsterFactory
{
   public MonsterFactory(){}
   
   public Monster createGremlin() {return new Gremlin();}
   public Monster createOgre() {return new Ogre();}   
   public Monster createSkeleton() {return new Skeleton();}  
   public Monster createDragon() {return new Dragon();}
   public Monster createGhoul() {return new Ghoul();}
}
