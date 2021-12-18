public class Combat {

	Player1 player1;
	Enemy enemy;

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

		String p1Avatar = "\uD83E\uDDD9\u200D\u2642";
		String enemyAvatar = "\uD83E\uDDDE\u200D\u2642";

		//while (player1.getHealth() * enemy.getHealth() > 0) { //keep going as long as both have health > 0
			
		//}
	}
	
}
