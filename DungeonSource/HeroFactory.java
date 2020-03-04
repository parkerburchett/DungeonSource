public class HeroFactory
{
   public HeroFactory() {}
   
   
   public Hero createThief()
   {
      return new Thief();
   }
   
   public Hero createSorceress()
   {
      return new Sorceress();
   }
   
   public Hero createWarrior()
   {
      return new Warrior();
   }
}