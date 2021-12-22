import java.util.Scanner;
import java.util.Random;

public class Combat {

	//TODO: Can I put these somehwere else? Maybe in another file? Then I import them?
	final String ANSI_RESET = "\u001B[0m";
	final String ANSI_BLACK = "\u001B[30m";
	final String ANSI_RED = "\u001B[31m";
	final String ANSI_GREEN = "\u001B[32m";
	final String ANSI_YELLOW = "\u001B[33m";
	final String ANSI_BLUE = "\u001B[34m";
	final String ANSI_PURPLE = "\u001B[35m";
	final String ANSI_CYAN = "\u001B[36m";
	final String ANSI_WHITE = "\u001B[37m";

	Player1 player1;
	Enemy enemy;
	String gameMode;

	Scanner scan = new Scanner(System.in);

	String p1Avatar = "\uD83E\uDDD9\u200D\u2642";
	String enemyAvatar = "\uD83E\uDDDE\u200D\u2642";
	String healthIcon = "\uD83E\uDE78";
	String manaIcon = "\uD83D\uDCA7";

	public Combat (Player1 player1, Enemy enemy, String gameMode) {
		this.player1 = player1;
		this.enemy = enemy;
		this.gameMode = gameMode;
	}

	//interactive attack, defend, evade
		//each turn, choose attack, or block, or charge mana
		//enemy does same
		//at end of turn, see who won
		//restart
	//enemy's attack and defence and evasions are random
		//3 types of enemies
			//aggressive attacks most, blocks least
			//balanced does all in proportion
			//defensive blocks most
		//other possible types
			//random is random?
			//responsive is responsive?

	public void runCombat() {


		//TODO: Delete functions that I'm not using anymore.
		//TODO: Add output that tells user when there is a tie.
		//TODO: Bug #001 - "Defenceless" - Defend does not block attack. Still get damaged. This is for player1, but might also be a problem for enemy.
		//TEST
		//System.out.println (p1Avatar + " " + enemyAvatar + " " + healthIcon + " " + manaIcon);
		String usersOption = "n/a";
		String enemysOption = "n/a";
		String firstLine = "\n";
		int numOfLines = 0;

		//TODO: Check if this variable is no longer needed and delete if it is not
		boolean firstLoop = true;

		//print info
		printScreen(numOfLines, usersOption, enemysOption);

		while (player1.getHealth() * enemy.getHealth() > 0) { //keep going as long as both have health > 0


			//TODO: Fix Bug #002 - "Exploding Gun" - When the enemy attacks, they hurt themselves. That should not be.
			//TEST
			//System.out.println("usersOption: " + usersOption);

			//get info
 			usersOption = getUsersOption();
			if (gameMode.equals("twoplayer")) {
				enemysOption = getEnemysOption_TwoPlayer();
			} else {
				enemysOption = getEnemysOption();
			}

			//modify objects
			modifyObjects(usersOption, enemysOption);

			//process and print output
			//TODO: Modularize - split processing input and printing output
			numOfLines = 10;
			printScreen(numOfLines, usersOption, enemysOption);


		}


		//determine winner
		if (player1.getHealth() > enemy.getHealth()) {
			usersOption = "won";
			enemysOption = "lost";
		} else if (player1.getHealth() < enemy.getHealth()) {
			usersOption = "lost";
			enemysOption = "won";
		} else {
			usersOption = "tied";
			enemysOption = "tied";
		}

		//print output explaining who won
		determineActionAndPrint(usersOption, "player1");
		determineActionAndPrint(enemysOption, "enemy");
		System.out.println();
	}

	public String getUsersOption() {
		Scanner scan = new Scanner(System.in);
		String usersOption = "";

		boolean inputIsValid = false;
		while (!inputIsValid) {
			usersOption = scan.nextLine();
			if (usersOption.equals("a") || usersOption.equals("s") || usersOption.equals("d")) {
				inputIsValid = true;
			} else {
				System.out.print("\033[F          \r");
			}
		}

		return usersOption;
	}
	public String getEnemysOption_TwoPlayer() {
		System.out.print("\033[F          \r");
		Scanner scan = new Scanner(System.in);
		String enemysOption = "";

		boolean inputIsValid = false;
		while (!inputIsValid) {
			enemysOption = scan.nextLine();
			if (enemysOption.equals("a") || enemysOption.equals("s") || enemysOption.equals("d")) {
				inputIsValid = true;
			} else {
				System.out.print("\033[F          \r");
			}
		}

		return enemysOption;
	}
	public String getEnemysOption() {
		Random rand = new Random();
		int enemysOptionInt = rand.nextInt(3) + 1;
		String enemysOption;

		if (enemysOptionInt == 1) {
			enemysOption = "a";
		} else if (enemysOptionInt == 2) {
			enemysOption = "s";
		} else {
			enemysOption = "d";
		}

		return enemysOption;
		
	}
	public void printScreen(int numOfLines, String usersOption, String enemysOption) {


		//TEST
		//System.out.println("Users Option: " + usersOption);

		//get reset cursor string if necessary
		String firstLine = "";
		if (numOfLines > 0) {
			firstLine = getResetCursorString(numOfLines);
		}

		//print first line
		System.out.println(firstLine); 		

		//print stage, with icons
		printStage(usersOption, enemysOption);				
		System.out.println();			

		//determine and print action status for user and enemy
		resetBlocks();
		determineActionAndPrint(usersOption, "player1");
		determineActionAndPrint(enemysOption, "enemy");
		System.out.println();	

		//print menu
		printMenu();	
		System.out.println();

		//erase users previous input
		System.out.print(" \r");
	}

	public void modifyObjects(String usersOption, String enemysOption) {

		//reset blocks
		resetBlocks();

		//phase 1 - block if possible
		if (usersOption.equals("d")) {
			player1.block();
		}
		if (enemysOption.equals("d")) {
			enemy.block();
		}


		//phase 2 - attack or recharge mana
		if (!usersOption.equals("d")) {
			carryOutAction(usersOption, player1, enemy);
		}
		if (!enemysOption.equals("d")) {
			carryOutAction(enemysOption, enemy, player1);
		}

	}

	public String getUsersInputAndModifyObject() {
			
			//get chosen option for player 1
			String usersOption = "";

			//modify p1 object based on input
			carryOutAction(usersOption);

			return usersOption;
	}
	public int getEnemysInputAndModifyObject() {
			
			//get chosen option for enemy, which is a random number from 1 to 3
			Random rand = new Random();
			int enemysOption = 0;

			//modify enemy object based on input
			carryOutAction(enemysOption);

			return enemysOption;
	}

	public String getResetCursorString(int numOfLines) {


		String goToStartOfPrev = "";
		for (int i = 1; i < numOfLines; i++) {
			goToStartOfPrev += "\033[F";
		}

		return goToStartOfPrev;
	}

	public void resetBlocks() {
		player1.unBlock();
		enemy.unBlock();
	}
	public void carryOutAction(String chosenOption, Character subject, Character opponent) {
		
			//attack
			if (chosenOption.equals("a")) {
				subject.attack(opponent, 1, "regular");
			}
			//recharge mana
			if (chosenOption.equals("s")) {
				subject.rechargeManaBy(1);
			}
	}
	public void carryOutAction (String usersOption) {
			//no input yet - no action
			if (usersOption.equals("n/a")) {
				//TODO: Delete if this if statement is useless
			}
			//set blocks
			if (usersOption.equals("d")) {
				player1.block();
			}
			//attack
			if (usersOption.equals("a")) {
				player1.attack(enemy, 1, "regular");
			}
			//recharge mana
			if (usersOption.equals("s")) {
				player1.rechargeManaBy(1);
			}
			//user has won - no action
			if (usersOption.equals("won")) {
				//TODO: Delete if this if statement is useless
			}
			//user has lost - no action
			if (usersOption.equals("lost")) {
				//TODO: Delete if this if statement is useless
			}
	}
	public void carryOutAction (int enemysOption) {
			//no input yet - no action
			if (enemysOption == 0) {
				//TODO: Delete if this if statement is useless
			}
			//set blocks
			if (enemysOption == 1) {
				enemy.block();
			}
			//attack
			if (enemysOption == 2) {
				enemy.attack(player1, 1, "regular");
			}
			//recharge mana
			if (enemysOption == 3) {
				enemy.rechargeManaBy(1);
			}
			//user has won - no action
			if (enemysOption == 4) {
				//TODO: Delete if this if statement is useless
			}
			//user has lost - no action
			if (enemysOption == 5) {
				//TODO: Delete if this if statement is useless
			}
	}

	public void processPhase1Actions(String usersOption, int enemysOption) { //only blocks are phase 1 actions, these need to be processed first
		
	}
	public void processPhase2Actions(String usersOption, int enemysOption) { //all actions except blocks are phase 2 actions
		
	}
	public void determineActionAndPrint (String chosenOption, String subject) {
		
			//no actions yet
			//no input yet - no mdaction
			if (chosenOption.equals("n/a")) {
				printActionStatus(subject, "n/a");
			}
			//set blocks
			if (chosenOption.equals("d")) {
				printActionStatus(subject, "block");
			}
			//attack
			if (chosenOption.equals("a")) {
				printActionStatus(subject, "attack");
			}
			//recharge mana
			if (chosenOption.equals("s")) {
				printActionStatus(subject, "recharge");
			}
			//user has won - no action
			if (chosenOption.equals("won")) {
				printActionStatus(subject, "won");
			}
			//user has lost - no action
			if (chosenOption.equals("lost")) {
				printActionStatus(subject, "lost");
			}
			//user has lost - no action
			if (chosenOption.equals("tied")) {
				printActionStatus(subject, "tied");
			}
	}
	public void determineAndPrint (String usersOption) {
			//no input yet - no action
			if (usersOption.equals("n/a")) {
				printActionStatus("player1", "n/a");
			}
			//set blocks
			if (usersOption.equals("d")) {
				printActionStatus("player1", "block");
			}
			//attack
			if (usersOption.equals("a")) {
				printActionStatus("player1", "attack");
			}
			//recharge mana
			if (usersOption.equals("s")) {
				printActionStatus("player1", "recharge");
			}
			//user has won - no action
			if (usersOption.equals("won")) {
				printActionStatus("player1", "won");
			}
			//user has lost - no action
			if (usersOption.equals("lost")) {
				printActionStatus("player1", "lost");
			}
	}
	public void determineAndPrint (int enemysOption) {
			//no input yet - no action
			if (enemysOption == 0) {
				printActionStatus("enemy", "n/a");
			}
			//set blocks
			if (enemysOption == 1) {
				printActionStatus("enemy", "block");
			}
			//attack
			if (enemysOption == 2) {
				printActionStatus("enemy", "attack");
			}
			//recharge mana
			if (enemysOption == 3) {
				printActionStatus("enemy", "recharge");
			}
			//user has won - no action
			if (enemysOption == 4) {
				printActionStatus("enemy", "won");
			}
			//user has lost - no action
			if (enemysOption == 5) {
				printActionStatus("enemy", "lost");
			}
	}

	public void printStage(String usersOption, String enemysOption) {
		
		String p1HealthDigit = colorizeHealthDigit("" + player1.getHealth(), usersOption, enemysOption);
		//System.out.println("p1HealthDigit: " + p1HealthDigit);
		String p1ManaDigit = colorizeManaDigit("" + player1.getMana(), usersOption, enemysOption);
		//System.out.println("p1HealthDigit: " + p1HealthDigit);
		String enemyHealthDigit = colorizeHealthDigit("" + enemy.getHealth(), enemysOption, usersOption);
		//System.out.println("p1HealthDigit: " + p1HealthDigit);
		String enemyManaDigit = colorizeManaDigit("" + enemy.getMana(), enemysOption, usersOption);
		//System.out.println("p1HealthDigit: " + p1HealthDigit);

		String playerHealth = healthIcon + p1HealthDigit;
		String playerMana = manaIcon + p1ManaDigit;
		String playerStage = playerHealth + playerMana + " " + p1Avatar;

		String enemyHealth = enemyHealthDigit + healthIcon;
		String enemyMana =  enemyManaDigit + manaIcon ;
		String enemyStage = enemyAvatar + " " + enemyMana + enemyHealth + " ";
		
		String stage = playerStage + "     " + enemyStage;
		
		System.out.println(stage);
	}

	public String colorizeHealthDigit(String digit, String subjectsOption, String opponentsOption) {

		if (opponentsOption.equals("a")  && !subjectsOption.equals("d")){
			digit = makeRed(digit);
		} else if (subjectsOption.equals("d") && opponentsOption.equals("a")){
			digit = makeYellow(digit);
		}

		//System.out.println(digit);
		return digit;
	}
	public String colorizeManaDigit(String digit, String subjectsOption, String opponentsOption) {

		if (subjectsOption.equals("s")) {
			digit = makeCyan(digit);
		}

		//System.out.println(digit);
		return digit;
	}

	public void printMenu() {
		String menu = "a: attack | s: charge mana | d: defend";
		System.out.println(menu);
	}

	public void printActionStatus (String who, String what) {
		String output = "";
		String firstHalf = "";

		if (who == "player1") {
			firstHalf = p1Avatar + ": You ";
		} else if (who == "enemy") {
			firstHalf = enemyAvatar + ": Enemy ";
		}

		if (what == "attack") {
			output = firstHalf + makeRed("attacked") + "!"; 
		} else if (what == "block") {
			output = firstHalf + makeYellow("blocked") + "!"; 
		} else if (what == "recharge") {
			output = firstHalf + makeCyan("recharged mana") + "!"; 
		} else if (what == "won") {
			output = firstHalf + "WON!";
		} else if (what == "lost") {
			output = firstHalf + "lost.";
		} else if (what == "tied") {
			output = firstHalf + "tied!";
		} else if (what == "n/a") {
			output = firstHalf + "... waiting for action.";
		}

		//add 10 spaces to end of output
		output += "                    ";
		System.out.println(output);
	}

	public String makeRed(String text) {
		return ANSI_RED + text + ANSI_RESET;
	}
	public String makeGreen(String text) {
		return ANSI_GREEN + text + ANSI_RESET;
	}
	public String makePurple(String text) {
		return ANSI_PURPLE + text + ANSI_RESET;
	}
	public String makeCyan(String text) {
		return ANSI_CYAN + text + ANSI_RESET;
	}
	public String makeYellow(String text) {
		return ANSI_YELLOW + text + ANSI_RESET;
	}
	//add broken heart for damage
	//add fire and shield for attack and block, and add water thing for mana regen


	//IDEAS
		//animation
		//shoot more than one fireball at a time
		//big fireball that uses 2 mana and goes through shield
		//reflect to adversary, uses mana -- this is a fun idea haha
		//enemy strategies
			//reasonable, agressive when your life is low, defensive when their life is low
			//defensive
			//aggressive
			//berserk
				//aggressive when their life is low
			//enemy strategy picked at random? or chosen by player?
			//chaotic - random choice of attack, charge, or defend
		//action status should have color and/or emojis so that it is more clear what happened
		//Instant Replay: Recording of game for review

	//TODO: fix bugs that delays or changes health/mana
		//there are some bugs that delay change or appearance of change to health and mana
		//find and fix
	//TODO: fix error handling
		//need to make sure that only correct input is accepted
}
