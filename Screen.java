import java.util.ArrayList;

public class Screen {
	//list

		ArrayList<String> screenLines = new ArrayList<String>();
	//constructor should take character objects
	
	//getters and setters

	//variables
		//list containing lines
		//icons
		private String p1Avatar = "\uD83E\uDDD9\u200D\u2642";
		private String enemyAvatar = "\uD83E\uDDDE\u200D\u2642";

		private String healthIcon = "";
		private String manaIcon = "";

		public boolean setIcon(String type, String icon) {
			switch (type) {
				case "p1":
					this.p1Avatar = icon;
					success = true;
					break;
				case "p2":
					this.p2Avatar = icon;
					success = true;
					break;
				case "health":
					this.health = icon;
					success = true;
					break;
				case "mana":
					this.mana = icon;
					success = true;
					break;
				default:
					success = false;
					break;
					//QUESTION: Why do we need a break statement under default since there are no cases that follow after default?
			}
			return success;
		}
		public String getIcon(String icon) {

			String result;
			switch (icon) {
				case "p1":
					result = p1Avatar;
					break;
				case "p2":
					result = p2Avatar;
					break;
				case "health":
					result = health;
					break;
				case "mana":
					result = mana;
					break;
				default:
					break;
			}
		}

		private Character player1;
		private Character player2;

		private String p1ActionStatus = p1Avatar + ": <no action yet>";
		private String p2ActionStatus = p2Avatar + ": <no action yet>";

		private String p1ActionWord = "";
		private String p2ActionWord = "";

		private String menu = "";

		private String p1WinStatus = "";
		private String p2WinStaus = "";
		//numbers

		screenLines.set(0) = "";
		screenLines.set(1) = actionStage;
		screenLines.set(2) = "";
		screenLines.set(3) = p1ActionStatus;
		screenLines.set(4) = p2ActionStatus;
		screenLines.set(5) = "";
		screenLines.set(6) = menu;
		screenLines.set(7) = "";

	
		
	//functions
		//display	
		//change color of numbers
		//change icons

	//listOfItems
	//comparisonsLeft
	//botomhalf
	//topHalf
	//combinedArray
	//leftArray
	//rightArray

	//.size(), .add(element to add to end), .add(index, element), .get(), .remove(), .set(index, element), .addAll(arraylist), 


}
