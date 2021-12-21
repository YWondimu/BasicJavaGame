import java.util.Scanner;
import java.util.Random;

public class Combat {

	Player1 player1;
	Enemy enemy;

	Scanner scan = new Scanner(System.in);

	String p1Avatar = "\uD83E\uDDD9\u200D\u2642";
	String enemyAvatar = "\uD83E\uDDDE\u200D\u2642";
	String healthIcon = "\uD83E\uDE78";
	String manaIcon = "\uD83D\uDCA7";

	public Combat (Player1 player1, Enemy enemy) {
		this.player1 = player1;
		this.enemy = enemy;
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


		//TODO: Bug #001 - "Defenceless" - Defend does not block attack. Still get damaged. This is for player1, but might also be a problem for enemy.
		//TEST
		//System.out.println (p1Avatar + " " + enemyAvatar + " " + healthIcon + " " + manaIcon);
		String usersOption = "n/a";
		int enemysOption = 0;
		String firstLine = "\n";
		int numOfLines = 0;

		//TODO: Check if this variable is no longer needed and delete if it is not
		boolean firstLoop = true;

		//print info
		printScreen(numOfLines, usersOption, enemysOption);

		while (player1.getHealth() * enemy.getHealth() > 0) { //keep going as long as both have health > 0


			//TEST
			//System.out.println("usersOption: " + usersOption);

			//get info
			usersOption = getUsersInputAndModifyObject();
			enemysOption = getEnemysInputAndModifyObject();
	
			//print output
			numOfLines = 10;
			printScreen(numOfLines, usersOption, enemysOption);


		}


		//determine winner
		if (player1.getHealth() > 0) { //player1 wins only if they still have health
			usersOption = "won";
			enemysOption = 5;
		} else {
			usersOption = "lost";
			enemysOption = 4;
		}

		//print output explaining who won
		determineAndPrint(usersOption);
		determineAndPrint(enemysOption);
		System.out.println();
	}

	public void printScreen(int numOfLines, String usersOption, int enemysOption) {


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
		printStage();				
		System.out.println();			

		//print action status for user and enemy
		determineAndPrint(usersOption);	
		determineAndPrint(enemysOption);
		System.out.println();	

		//print menu
		printMenu();	
		System.out.println();

		//erase users previous input
		System.out.print(" \r");
	}

	public String getUsersInputAndModifyObject() {
			
			//get chosen option for player 1
			String usersOption;
 			usersOption = scan.nextLine();

			//modify p1 object based on input
			carryOutAction(usersOption);

			return usersOption;
	}
	public int getEnemysInputAndModifyObject() {
			
			//get chosen option for enemy, which is a random number from 1 to 3
			Random rand = new Random();
			int enemysOption;
			enemysOption = rand.nextInt(3)+1;

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
			//unblock
			player1.unBlock();
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
			//unblock
			enemy.unBlock();
	}
	public void determineAndPrint (String usersOption) {
			//no actions yet
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
			//no actions yet
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

	public void printStage() {
		String playerHealth = healthIcon + player1.getHealth();
		String playerMana = manaIcon + player1.getMana();
		String playerStage = playerHealth + playerMana + " " + p1Avatar;

		String enemyHealth = enemy.getHealth() + healthIcon;
		String enemyMana = enemy.getMana() + manaIcon ;
		String enemyStage = enemyAvatar + " " + enemyMana + enemyHealth + " ";
		
		String stage = playerStage + "     " + enemyStage;
		
		System.out.println(stage);


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
			output = firstHalf + "attacked!"; 
		} else if (what == "block") {
			output = firstHalf + "blocked!"; 
		} else if (what == "recharge") {
			output = firstHalf + "recharged mana!"; 
		} else if (what == "won") {
			output = firstHalf + "WON!";
		} else if (what == "lost") {
			output = firstHalf + "lost.";
		} else if (what == "n/a") {
			output = firstHalf + "... waiting for action.";
		}

		//add 10 spaces to end of output
		output += "                    ";
		System.out.println(output);
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

	//TODO: fix bugs that delays or changes health/mana
		//there are some bugs that delay change or appearance of change to health and mana
		//find and fix
	//TODO: fix error handling
		//need to make sure that only correct input is accepted
}
