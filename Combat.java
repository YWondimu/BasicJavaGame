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
		//System.out.println("Fairy: \uD83E\uDDDA\u200D\u2642\u2B05\uFE0F");
		//System.out.println("Fairy: \uD83E\uDDDA\u200D\u2642\u27A1\uFE0F");
		//System.out.println("Genie: \uD83E\uDDDE\u200D\u2642");
		//System.out.println("Zombie: \uD83E\uDDDA\u200D\u2642");
		//System.out.println("Wizard: \uD83E\uDDD9\u200D\u2642");
		//System.out.println("Skeleton: \uD83E\uDDDA\u200D\u2642");
		//System.out.println("Face Left: \u1F3F3\u200D\u2B05\uFE0F");
		//System.out.println("Face Right: \u1F3F3\u200D\u27A1\uFE0F");
		//System.out.println("Fairy: \uD83E\uDDDA\u200D\u2642");
		//System.out.println("Fairy: \uD83E\uDDDA\u200D\u2642");
		//System.out.println("Fencing Left: \uD83E\uDD3A\u2B05\uFE0F");
		//System.out.println("Fencing Right: \uD83E\uDD3A\u27A1\uFE0F");
		//System.out.println("Ninja: \uD83E\uDD77\uD83C\uDFFC");
		//System.out.println("Vampire: \uD83E\uDDDB\u200D\u2640");



		//TEST
		//System.out.println (p1Avatar + " " + enemyAvatar + " " + healthIcon + " " + manaIcon);
		String usersOption;
		int enemysOption;
		Random rand = new Random();
		while (player1.getHealth() * enemy.getHealth() > 0) { //keep going as long as both have health > 0

			System.out.println();
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

			//set blocks
			if (enemysOption == 1) {
				enemy.block();
			}
			if (usersOption.equals("d")) {
				player1.block();
			}
			//attack
			if (enemysOption == 2) {
				enemy.attack(player1, 1, "regular");
			}
			if (usersOption.equals("a")) {
				player1.attack(enemy, 1, "regular");
			}
			//recharge mana
			if (enemysOption == 3) {
				enemy.rechargeManaBy(1);
			}
			if (usersOption.equals("s")) {
				player1.rechargeManaBy(1);
			}
			//unblock
			enemy.unBlock();
			player1.unBlock();

		}


		System.out.println();
		printStage();
		System.out.println();

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

	//add broken heart for damage
	//add fire and shield for attack and block, and add water thing for mana regen
	
}
