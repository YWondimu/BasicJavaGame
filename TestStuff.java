public class TestStuff {
	public static void main (String[] args) {
		TestStuff tester = new TestStuff();
		tester.initializeStringOutsideLoopVsDont(); //If variable is used within a scope, it must be initialized in that scope, even if it is initialized in a loop prior to use of the variable in the outer scope. I think this is to avoid any accidental uses of the variable without initializing (e.g. if the loop is not entered for whatever reason).
		//String stringOutsideFunction;
		tester.modifyStringOutsideFunction(); //Cannot modify variable that is not passed into function
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

}
