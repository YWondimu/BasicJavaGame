//import java.util.ArrayList;
//
//public class Screen {
//	//list
//
//		ArrayList<String> screenLines = new ArrayList<String>();
//	//constructor should take character objects
//	
//	//getters and setters
//
//	//variables
//		//list containing lines
//		//icons
//		private String p1Avatar = "\uD83E\uDDD9\u200D\u2642";
//		private String p2Avatar = "\uD83E\uDDDE\u200D\u2642";
//
//		private String healthIcon = "";
//		private String manaIcon = "";
//
//		public boolean setIcon(String type, String icon) {
//			boolean success = false;
//			switch (type) {
//				case "p1":
//					this.p1Avatar = icon;
//					success = true;
//					break;
//				case "p2":
//					this.p2Avatar = icon;
//					success = true;
//					break;
//				case "health":
//					this.healthIcon = icon;
//					success = true;
//					break;
//				case "mana":
//					this.manaIcon = icon;
//					success = true;
//					break;
//				default:
//					success = false;
//					break;
//					//QUESTION: Why do we need a break statement under default since there are no cases that follow after default?
//			}
//			return success;
//		}
//		public String getIcon(String icon) {
//
//			String result;
//			switch (icon) {
//				case "p1":
//					result = this.p1Avatar;
//					break;
//				case "p2":
//					result = this.p2Avatar;
//					break;
//				case "health":
//					result = this.healthIcon;
//					break;
//				case "mana":
//					result = this.manaIcon;
//					break;
//				default:
//					break;
//			}
//
//			return result;
//		}
//
//		private Character player1;
//		private Character player2;
//
//		public boolean setCharacter(String type, Character characterObject) {
//
//			boolean success;
//			switch (type) {
//				case "p1":
//					this.player1 = characterObject;
//					success = true;
//					break;
//				case "p2":
//					this.player2 = characterObject;
//					//QUESTION: Is using the "this" keyword good practice? I assume so.
//					success = true;
//					break;
//				default:
//					success = false;
//					break;
//			}
//			
//			return success;
//		}
//		public Character getCharacter(String type) {
//			
//			Character result = new Player1(0, 0, "temp"); //need to initialize result in order to compile
//			switch (type) {
//				case "p1":
//					result = this.player1;
//					break;
//				case "p2":
//					result = this.player2;
//					break;
//
//				default:
//					break;
//			}
//
//			return result;
//		}
//
//
//		private String actionStage = "";
//
//		private String p1ActionStatus = p1Avatar + ": <no action yet>";
//		private String p2ActionStatus = p2Avatar + ": <no action yet>";
//
//		private String p1ActionWord = "";
//		private String p2ActionWord = "";
//
//		private String menu = "";
//
//		private String p1WinStatus = "";
//		private String p2WinStaus = "";
//		//numbers
//
//		
//		public void prepareScreenLines() {
//			screenLines.add(0, "");
//			screenLines.add(1, actionStage);
//			screenLines.add(2, "");
//			screenLines.add(3, p1ActionStatus);
//			screenLines.add(4, p2ActionStatus);
//			screenLines.add(5, "");
//			screenLines.add(6, menu);
//			screenLines.add(7, "");
//		}
//
//	
//		
//	//functions
//		//display	
//		//change color of numbers
//		//change icons
//
//	//listOfItems
//	//comparisonsLeft
//	//botomhalf
//	//topHalf
//	//combinedArray
//	//leftArray
//	//rightArray
//
//	//.size(), .add(element to add to end), .add(index, element), .get(), .remove(), .set(index, element), .addAll(arraylist), 
//
//
//}
