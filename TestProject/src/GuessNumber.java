import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		int i = rand.nextInt(100) + 1;
		int count = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("Guess an int (1-100)");

		while (count < 5) {
			System.out.println("What's your guess?");
			int guess = s.nextInt();
			count++;
			if (Math.abs(guess - i) <= 10) {
				System.out.println("The number is " + i + ".");
				break;
			} else {
				if (count == 5) {
					System.out.println("Sorry");
					break;
				} else {
					System.out.println("Please try again");

				}
			}

		}
		s.close();
	}
}
