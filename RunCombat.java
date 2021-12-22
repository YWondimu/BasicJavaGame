import java.util.concurrent.TimeUnit;

public class RunCombat {
	public static void main (String[] args) {
		//Player1 player1 = new Player1();
		//Enemy enemy = new Enemy();

		//Combat combat = new Combat(Player1, Enemy);

		//combat.run();

		Player1 player1 = new Player1(5, 5);
		Enemy enemy = new Enemy(5,5);

		String gameMode = "";

		if (args.length > 0) {
			gameMode = args[0];
		}

		Combat testCombat = new Combat(player1, enemy, gameMode);
		testCombat.runCombat();
	}


}
