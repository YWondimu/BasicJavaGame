import java.util.concurrent.TimeUnit;

public class AnimationExample {
	public static void main (String[] args) {
		String spaceToLeft = "";
		String spaceToRight = "          ";
		String dot = ".";
		for (int i = 0; i < 10; i++) {
			System.out.print( "\r" + spaceToLeft + dot + spaceToRight);
			
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
			}
			spaceToLeft += " ";
		}
	}
}
