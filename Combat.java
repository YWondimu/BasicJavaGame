import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
	
	//TODO:-> Make function that counts the number of occurrences of a substring
	//TODO:-> Use this function to count how many instances of \n are in the
	//screen substring
	//TODO:-> Use this count to un-hardcode numOfLines
	//TODO:-> There was another change I made. I should find it and
	//make a note in the commit message

	public int countSubstr(String outerString, String substring) {
		int count = 0;
		int fromIndex = 0;
		int newIndex = -1;
		for (int i = 0; i < outerString.length(); i++) {
			newIndex = outerString.indexOf(substring, fromIndex);
			if (newIndex >= 0) { //if newIndex >= 0 then the substring has been found
				count++;
				fromIndex = newIndex + substring.length();
			}
		}

		return count;
	}

	public void runCombat() {


		//TODO: Should I use machine learning??
		//TODO: Make log - create file, output to file
			//File name should be "Log-<DATEANDTIME>", that way I don't have to check to see if the file exists
			//Make it possible to give the log a name using command line arguments
		//TODO: Delete functions that I'm not using anymore.
		//TEST
		//System.out.println (p1Avatar + " " + enemyAvatar + " " + healthIcon + " " + manaIcon);
		String usersOption = "n/a";
		String enemysOption = "n/a";
		String firstLine = "\n";
		int numOfLines = 0;
		String screenToPrint = "";

		//TODO: Show color for mana going down.
		//TODO: Check if this variable is no longer needed and delete if it is not
		//TODO: Keep a history of moves so that the "ai" can know how to respond based on past moves.
		boolean firstLoop = true;

		//print info
		screenToPrint = getScreen(numOfLines, usersOption, enemysOption);
		numOfLines = countSubstr(screenToPrint, "\n") + 2;
		System.out.print(screenToPrint);

		while (player1.getHealth() * enemy.getHealth() > 0) { //keep going as long as both have health > 0

			//TODO: The print methods should return strings instead of printing them
			//TODO: I should use "\n" in the strings and use print not println, that way I can count 
			//how many new lines I have using string methods. And I can modify specific lines.
			//TEST
			//System.out.println("usersOption: " + usersOption);

			//get info
 			usersOption = getUsersOption();
			enemysOption = getEnemysOption();

			//modify objects
			modifyObjects(usersOption, enemysOption);

			//process and print output
			//TODO: Modularize - split processing input and printing output
			//TODO: Minor priority - make the bottom 3 lines into 1 function?
			screenToPrint = getScreen(numOfLines, usersOption, enemysOption);
			numOfLines = countSubstr(screenToPrint, "\n") + 2;
			System.out.print(screenToPrint);


			//Add animation after printing to the screen
			//animate(numOfLines, screenToPrint);


		} 


		//TODO: Make the below lines relating to win/lost status into one function
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

		//TODO: Change this to win status, and make the whole thing into one function
		String p1ActionStatus = getActionStatus("player1", usersOption);
		String p2ActionStatus = getActionStatus("enemy", enemysOption);
		
		System.out.print(
			"\n" + 
			"\n" + 
			p1ActionStatus + "\n" +
			p2ActionStatus + "\n" +
			"\n"
			);
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
	public String getEnemysOption() {
		
		String enemysOption;

		if (gameMode.equals("twoplayer")) {
			enemysOption = getEnemysOption_TwoPlayer();
		} else {
			enemysOption = getEnemysOption_OnePlayer();
		}

		return enemysOption;
	}
	public String getEnemysOption_OnePlayer() {
		
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
	public String  getScreen(int numOfLines, String usersOption, String enemysOption) {

		String screenString = "";
		String emptyLine = "\n";
		String stage = "";
		String p1ActionStatus = "";
		String p2ActionStatus = "";
		String menu = "";
		String p1WonStatus = "";
		String p2WonStatus = "";
		String resetCursorToFirstColAndLine = "";
		String eraseLineAndResetCursorToStartOfLine = "";
		
		resetCursorToFirstColAndLine = getResetCursorString(numOfLines);
		stage = getStage(usersOption, enemysOption);
		p1ActionStatus = getActionStatus("player1", usersOption);
		p2ActionStatus = getActionStatus("enemy", enemysOption);
		//TODO: I don't think this line below does anything. Delete it?
		menu = getMenu();
		

		screenString = 
			resetCursorToFirstColAndLine +
			"\n" + 
			stage + "\n" +
			"\n" +
			p1ActionStatus + "\n" +
			p2ActionStatus + "\n" + 
			"\n" +
			menu + "\n" +
			"\n" +
			eraseLineAndResetCursorToStartOfLine;

		return screenString;

			
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

	public String getStage(String usersOption, String enemysOption) {
		
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

		String areaBetweenIcons = "                    ";
		
		String stage = playerStage + areaBetweenIcons + enemyStage;
		
		return stage;
	}

	public void animate(int numOfLines, String stage) {
		//get space between avatars, using search and subtracting indexes
		//use replace function to insert icon, use sleep to move icon

		//take stage and find scene

		//get first index of scene
		int sceneStartIndex = stage.indexOf(p1Avatar);
		int sceneEndIndex = stage.indexOf(enemyAvatar) + 10;

		//get scene
		String scene = stage.substring(sceneStartIndex, sceneEndIndex);

		String fireBall = "o";
		String explosion = "X";

		//i want functions for fireball movement, and explosion, and blocking (maybe a block could consist of hte shield exploding
		//instead of the avatar), and mana recharge.

		//move curstor to sceneStartIndex's column and row
		//TODO: Maybe the scene should be an object, and each line should have a name and row number?

		moveCursor("up", 7);
		moveCursor("right", 7); //NOTE: For some reason, the blood and water drops take up two spaces? And moving right by 0 moves the cursor by one? I think.
		String frame = scene;

		System.out.println();
		System.out.print(frame);
		System.out.println();
		//for (int i = 1; i < scene.length()-2; i++) {
		//	frame = scene.substring(0,i) + "o" + scene.substring(i+1, scene.length());
		//	System.out.print(frame);
		//	moveCursor("left", scene.length()-1);
		//	try {
		//		TimeUnit.MILLISECONDS.sleep(50);
		//	} catch (InterruptedException e) {
		//	}
		//}
		
	}


	public void moveCursor(String dir, int num) {
		//dir = direction
		//num = number of spaces

		String cursorMovementString = "\033[";

		cursorMovementString += num;

		switch(dir) {
			case "up":
				cursorMovementString += "A";
				break;
			case "down":
				cursorMovementString += "B";
				break;
			case "right":
				cursorMovementString += "C";
				break;
			case "left":
				cursorMovementString += "D";
				break;
			default:
				break;
		}
		
		System.out.print(cursorMovementString);
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

	public String getMenu() {
		String menu = "a: " + makeRed("attack") + " | s: " + makeCyan("charge mana") + " | d: " + makeYellow("defend");

		return menu;
	}

	public String getActionStatus (String who, String what) {
		String output = "";
		String firstHalf = "";

		//Change contents of "what" variable for readability
		if (what.equals("a")) {
			what = "attack";
		} else if (what.equals("s")) {
			what = "recharge";
		} else if (what.equals("d")) {
			what = "block";
		}

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
		
		return output;
	}

	public String getSpaces(int num) {

		String spaces = "";
		for (int i = 1; i<=num; i++) {
			spaces += " ";
		}

		return spaces;
	}

	//TODO: Make the below into one function
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
		//need to make sure that only correct input is accepte
	//TODO: Fix Bug - #003 - UnnecessaryColor - When attacked without mana, enemys status health turns red or yellow.
	//This should only happen if player1 attacks with mana, not without mana. (Same thing happens the other way: 
	//when enemy attacks player1.)
}
