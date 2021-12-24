public class TestStuff {
	public static void main (String[] args) {
		TestStuff tester = new TestStuff();
		tester.initializeStringOutsideLoopVsDont(); //If variable is used within a scope, it must be initialized in that scope, even if it is initialized in a loop prior to use of the variable in the outer scope. I think this is to avoid any accidental uses of the variable without initializing (e.g. if the loop is not entered for whatever reason).
		//String stringOutsideFunction;
		tester.modifyStringOutsideFunction(); //Cannot modify variable that is not passed into function
		tester.printTextInColor();

		tester.testAssigningStringOnMultipleLines();

		//Below does not work
		//tester.testStringBracketIndex();
		
		int count = tester.countSubstr("hello mellow jello elll elelelleell", "ell");
		System.out.println("Count of substring is: " + count);
	}

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

	public void testStringBracketIndex() {
		String testString = "hello world";
		//Below does not work
		//System.out.println(testString[0]);
	}

	public void testAssigningStringOnMultipleLines() {
		
		String testString = 
			"line1 \n" + 
			"line2 \n";

		System.out.print(testString);
	}

	public void initializeStringOutsideLoopVsDont() {
		
			//String greeting;
			String greeting = "";
			boolean conditionIsTrue = true;
			while (conditionIsTrue) {
				greeting = "hello world";
				conditionIsTrue = false;
			}
			System.out.println(greeting);
	}

	public void modifyStringOutsideFunction() {
		String stringOutsideFunction;

		stringOutsideFunction = "hello outside string";
		System.out.println(stringOutsideFunction);
	}

	public void printTextInColor() {
		String ANSI_RESET = "\u001B[0m";
		String ANSI_RED = "\u001B[31m";
		System.out.println(ANSI_RED + "This is red ... hopefully haha." + ANSI_RESET);
	}
}
