import java.util.Scanner;
import java.util.Random;

public class Combat {

	Player1 player1;
	Enemy enemy;

	String p1Avatar = "\uD83E\uDDD9\u200D\u2642";
	String enemyAvatar = "\uD83E\uDDDE\u200D\u2642";
	String healthIcon = "\uD83E\uDE78";
	String manaIcon = "\uD83D\uDCA7";

	Scanner scan = new Scanner(System.in);

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



		//TEST
		//System.out.println (p1Avatar + " " + enemyAvatar + " " + healthIcon + " " + manaIcon);
		String usersOption;
		int enemysOption;
		Random rand = new Random();
		String goToStartOfPrev = "";
		int numOfLines;
		numOfLines = 8;
		for (int i = 1; i < numOfLines; i++) {
			goToStartOfPrev += "\033[F";
		}

		boolean firstLoop = true;
		while (player1.getHealth() * enemy.getHealth() > 0) { //keep going as long as both have health > 0

			if (firstLoop) {
				firstLoop = false;
				System.out.println();
			} else {
				System.out.print(goToStartOfPrev);
			}
			printStage();
			System.out.println();
			printMenu();
			System.out.println();

 			usersOption = scan.nextLine();
		//use carriage returns to clear command line when moving on to next round
			//get enemy's option
			enemysOption = rand.nextInt(3)+1; //get random number from 1 to 3

			//TEST
			//System.out.println("usersOption: " + usersOption);

			//TODO: The order in which action status prints switches
			//E.g. one time its enemy first, then player1, then enemy.
			//The order should be the same, always: player1, then enemy.

			handleChosenOption(usersOption, enemysOption);

		}


		System.out.println();
		printStage();
		System.out.println();

		if (player1.getHealth() > 0) { //player1 wins only if they still have health
			System.out.println("You WIN!");
		} else {
			System.out.println("You lose!");
		}

		System.out.println();

	}

	public void handleChosenOption (String usersOption, int enemysOption) {
			//set blocks
			if (enemysOption == 1) {
				enemy.block();
				printActionStatus("enemy", "block");
			}
			if (usersOption.equals("d")) {
				player1.block();
				printActionStatus("player1", "block");
			}
			
			//attack
			if (enemysOption == 2) {
				enemy.attack(player1, 1, "regular");
				printActionStatus("enemy", "attack");
			}
			if (usersOption.equals("a")) {
				player1.attack(enemy, 1, "regular");
				printActionStatus("player1", "attack");
			}
			//recharge mana
			if (enemysOption == 3) {
				enemy.rechargeManaBy(1);
				printActionStatus("enemy", "recharge");
			}
			if (usersOption.equals("s")) {
				player1.rechargeManaBy(1);
				printActionStatus("player1", "recharge");
			}
			//unblock
			enemy.unBlock();
			player1.unBlock();
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
		}

		//add 10 spaces to end of output
		output += "          ";
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
}
