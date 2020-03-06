import java.util.Scanner;

public class Dungeon
{
    public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		Hero theHero;
		Monster theMonster;

		do
		{
		    theHero = chooseHero(kb);
		    theMonster = generateMonster();
			battle(theHero, theMonster , kb);

		} while (playAgain(kb));

    }//end main method

	public static Hero chooseHero(Scanner kb)
	{
		printMenu();
		return  getHeroChoice(kb);
	}

	private static void printMenu(){
		System.out.println("Choose a hero:\n" +
				"1. Warrior\n" +
				"2. Sorceress\n" +
				"3. Thief");
	}

	private static Hero getHeroChoice(Scanner kb){
		int choice = getChoice(kb , 1 , 3);
		HeroFactory HFact = new HeroFactory();
		if(choice == 1){
			return HFact.createWarrior();
		}
		else if(choice == 2){
			return HFact.createSorceress();
		}
		else{
			return HFact.createThief();
		}
	}//Hero is made
	
	private static Monster generateMonster()
	{
		int choice = (int)(Math.random() * 3) + 1;
		MonsterFactory MFact = new MonsterFactory();

		if(choice  == 1){
			return MFact.createOgre();
		}
		else if(choice == 2){
			return MFact.createGremlin();
		}
		else{
			return MFact.createSkeleton();
		}
	}//Monster is made

	private static int getChoice(Scanner kb , int lowerbounds , int upperbounds){
		int input = 1;
		while(input < lowerbounds && input > upperbounds){

			try{
				input = kb.nextInt();
			}catch (Exception e){
				System.out.println("invalid number");
			}
		}
		return input;
	}

	private static boolean playAgain(Scanner kb)
	{
		char playAgain = 'r';
		while(playAgain != 'y' && playAgain != 'n'){
			System.out.println("Play again (y/n)?");
			playAgain = kb.next().toLowerCase().charAt(0);
		}
		if(playAgain == 'n')
			System.out.println("GoodBye, Thanks for playing");
		return (playAgain == 'y');
	}//end playAgain method


	//Battle method, hero goes first and ends when user quits or something dies
	private static void battle(Hero theHero, Monster theMonster , Scanner kb)
 	{
		char pause = 'p';
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
		{
		    //hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn
			if (theMonster.isAlive())
			    theMonster.attack(theHero);


			if(theHero.isAlive() && theMonster.isAlive()){
				System.out.print("\n-->q to quit, anything else to continue: ");
				pause = kb.next().toLowerCase().charAt(0);
			}



		}//end battle loop

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");
	}
}
