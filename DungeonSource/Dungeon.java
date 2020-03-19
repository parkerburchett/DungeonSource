import java.util.Scanner;

public class Dungeon
{
    public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		Hero theHero;
		do
		{
		   theHero = chooseHero(kb);  
			Maze theMaze = new Maze(theHero);
         theHero.setCurrentRoom(theMaze);
			playGame(theMaze , kb , theHero);
		} while (playAgain(kb));

    }//end main method


      public static void playGame(Maze maze, Scanner kb, Hero theHero)
      {
    	do{
    		System.out.println("What direction would you like to go?");
			directionPrompt();
    		move(theHero , kb);
    		if(theHero.currentRoom.getMonster() != null){
    			battle(theHero , maze.currrentLocation.getMonster() , kb);
			}
		} while(true);// Needs condition
		//then the exit becomes available
		//System.out.println("The game is done here I guess");
	}

	public static void directionPrompt(){
		System.out.println("\nW = North  S = South\nA = West  D = East");
	}
	public static String inputDirection(Scanner kb){
    	String input = kb.nextLine().toLowerCase();
    	if(input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")){
    		return input;
		}
    	return inputDirection(kb);
	}

	public static void move( Hero hero , Scanner kb){
    	String direction = inputDirection(kb);
    	if(direction.equals("w")){	hero.moveNorth();}
    	else if(direction.equals("a")){hero.moveWest();}
    	else if(direction.equals("s")){hero.moveSouth();}
    	else{	hero.moveEast();}
	}

	public static Hero chooseHero(Scanner kb)
	{
		printMenu();
		return  getHeroChoice(kb);
	}

	private static void printMenu(){
		System.out.println(
				"1. Warrior\n" +
				"2. Sorceress\n" +
				"3. Thief\n" +
            "4. Archer\n" +
            "5. Paladin\n" );
		System.out.print("Choose a hero:");
	}

	private static Hero getHeroChoice(Scanner kb){
		int choice = getChoice(kb , 1 , 5);
		HeroFactory HFact = new HeroFactory();
      
		if(choice == 1) {return HFact.createWarrior();}
		else if(choice == 2) {return HFact.createSorceress();}
		else if (choice == 3){ return HFact.createThief();}
      else if (choice == 4){ return HFact.createArcher();}
      else {return HFact.createPaladin();}
	}
	private static Monster generateMonster()
	{
		int choice = (int)(Math.random() * 5) + 1;
		MonsterFactory MFact = new MonsterFactory();
		if(choice  == 1) {return MFact.createOgre();}
		else if (choice == 2) {return MFact.createGremlin();}
		else if (choice == 3) {return MFact.createSkeleton();}
      else if (choice == 4) {return MFact.createDragon();}
      else {return MFact.createGhoul();}
	}

	private static int getChoice(Scanner kb , int lowerbounds , int upperbounds){
		String input = kb.nextLine();
		int inputInt = 0;
			try{
				inputInt = Integer.parseInt(input);
			}catch (Exception e){
				System.out.println("only numbers");
			}
			if(inputInt < lowerbounds || inputInt > upperbounds){
				System.out.println("invalid, try again");
				return getChoice(kb,lowerbounds,upperbounds);
			}
		return inputInt;
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
