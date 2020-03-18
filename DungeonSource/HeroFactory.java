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
   
   public Hero createArcher()
   {
      return new Archer();
   }
   public Hero createPaladin()
   {
      return new Paladin();
   }
}