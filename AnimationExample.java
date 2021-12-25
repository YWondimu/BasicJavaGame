import java.util.concurrent.TimeUnit;

public class AnimationExample {
	public static void main (String[] args) {
		String spaceToLeft = "";
		String spaceToRight = "          ";
		String dot = ".";
		int time = Integer.parseInt(args[0]);
		for (int i = 0; i < 10; i++) {
			System.out.print( "\r" + spaceToLeft + dot + spaceToRight);
			
			try {
				TimeUnit.MILLISECONDS.sleep(time);
			} catch (InterruptedException e) {
				//TODO: Why doesn't the below work?
				//System.out.println(e.message());
			}
			spaceToLeft += " ";
			//TODO: Figure out why jsut catching the exception is fine.
		}
	}
}
