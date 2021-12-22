public class ColoredText {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static void main (String[] args) {
		System.out.println(
			ANSI_BLACK + "black" + ANSI_RESET + "\n" + 
			ANSI_RED + "red" + ANSI_RESET + "\n" + 
			ANSI_GREEN + "green" + ANSI_RESET + "\n" + 
			ANSI_YELLOW + "yellow" + ANSI_RESET + "\n" + 
			ANSI_BLUE + "blue" + ANSI_RESET + "\n" + 
			ANSI_PURPLE + "purple" + ANSI_RESET + "\n" + 
			ANSI_CYAN + "cyan" + ANSI_RESET + "\n" + 
			ANSI_WHITE + "white" + ANSI_RESET + "\n"
			);

		System.out.println("Make " + makeRed("red") + makeGreen("green") + makePurple("purple"));
	}

	public static String makeRed(String text) {
		return ANSI_RED + text + ANSI_RESET;
	}
	public static String makeGreen(String text) {
		return ANSI_GREEN + text + ANSI_RESET;
	}
	public static String makePurple(String text) {
		return ANSI_PURPLE + text + ANSI_RESET;
	}
	public static String makeCyan(String text) {
		return ANSI_CYAN + text + ANSI_RESET;
	}
	public static String makeYellow(String text) {
		return ANSI_YELLOW + text + ANSI_RESET;
	}
}
