import java.util.Scanner;

public class ChipGame {

	public enum GameStatus {
		STARTWITHNAME, SETUP, PLAYING, AGAIN
	}

	public static int checkChips(int remain) {
		int remainRange = 0;
		if (remain == 1) {
			return 1;
		} else if (remain % 2 == 0) {
			remainRange = remain / 2;
		} else {
			remainRange = (remain - 1) / 2;

		}
		return remainRange;
	}

	public static boolean gameEnd(int remain) {
		if (remain == 0)
			return true;
		else
			return false;
	}

	public static String checkWiner(int firstChip, int secondChip,
			String firstName, String secondName) {
		if (firstChip > secondChip)
			return firstName;
		else
			return secondName;
	}

	public static void main(String[] args) {

		String firstName = null, secondName = null;
		int totalChip, remainChip = 0, removeChip, firstChip = 0, secondChip = 0, halfOfRemain;
		int turns = 0;
		boolean gameLaunch = true;
		boolean gameEndCheck = false;
		Scanner s = new Scanner(System.in);
		GameStatus gameStatus = GameStatus.STARTWITHNAME;

		while (gameLaunch) {
			switch (gameStatus) {
			case STARTWITHNAME:
				System.out.println("What is the name of the first player");
				firstName = s.next();
				System.out.println("What is the name of the second player");
				secondName = s.next();
				while (firstName.equalsIgnoreCase(secondName)) {
					System.out.println("Both players cannot be named "
							+ secondName + ".Enter a different name");
					secondName = s.next();
				}
				gameStatus = GameStatus.SETUP;
				break;
			case SETUP:
				System.out
						.println("How many chips does the initial pile contain? ");
				totalChip = s.nextInt();
				boolean totalConditions = false;
				while (!totalConditions) {
					if (totalChip < 3) {
						System.out
								.println("You have to start with at least 3 chips. Choose another number:");
						totalChip = s.nextInt();
					} else if (totalChip % 2 == 0) {
						System.out
								.println("You have to start with an odd number of chips.Choose another number:");
						totalChip = s.nextInt();
					} else {
						remainChip = totalChip;
						totalConditions = true;
					}
				}
				gameStatus = GameStatus.PLAYING;
				break;
			case PLAYING:
				while (!gameEndCheck) {
					System.out.println(firstName + " has " + firstChip
							+ " chips.");
					System.out.println(secondName + " has " + secondChip
							+ " chips.");
					if (turns % 2 == 0) {
						System.out
								.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * ");
						System.out.println("It is your turn, " + firstName);
						System.out.println("There are " + remainChip
								+ " chips remaining.");
						halfOfRemain = checkChips(remainChip);
						System.out
								.println("You may take any number of chips from 1 to "
										+ halfOfRemain + ".");
						boolean legality = false;
						while (!legality) {
							System.out.println("How many will you take, "
									+ firstName + "?");
							removeChip = s.nextInt();
							if (removeChip > halfOfRemain) {
								System.out
										.println("Illegal move: you may not take more than "
												+ halfOfRemain + " chips");
							} else if (removeChip < 1) {
								System.out
										.println("Illegal move: you must take at least one chip. ");
							} else {
								firstChip = removeChip + firstChip;
								remainChip = remainChip - removeChip;
								legality = true;
								gameEndCheck = gameEnd(remainChip);
								turns++;
							}
						}
					} else {
						System.out
								.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * ");
						System.out.println("It is your turn, " + secondName);
						System.out.println("There are " + remainChip
								+ " chips remaining.");
						halfOfRemain = checkChips(remainChip);
						System.out
								.println("You may take any number of chips from 1 to "
										+ halfOfRemain
										+ ".How many will you take, "
										+ secondName + "?");
						boolean legality = false;
						while (!legality) {
							removeChip = s.nextInt();
							if (removeChip > halfOfRemain) {
								System.out
										.println("Illegal move: you may not take more than "
												+ halfOfRemain + " chips");
							} else if (removeChip < 1) {
								System.out
										.println("Illegal move: you must take at least one chip. ");
							} else {
								secondChip = removeChip + secondChip;
								remainChip = remainChip - removeChip;
								legality = true;
								gameEndCheck = gameEnd(remainChip);
								turns++;
							}
						}
					}
				}

				System.out.println(firstName + " has " + firstChip + " chips.");
				System.out.println(secondName + " has " + secondChip
						+ " chips.");
				String winner = checkWiner(firstChip, secondChip, firstName,
						secondName);
				System.out.println(winner + " wins!");
				gameStatus = GameStatus.AGAIN;
				break;
			case AGAIN:
				System.out.println("Play another game? (y/n) ");
				String again = s.next();
				if (again.equalsIgnoreCase("y")) {
					gameStatus = GameStatus.STARTWITHNAME;
					remainChip = 0;
					firstChip = 0;
					secondChip = 0;
					gameEndCheck = false;
					break;
				} else {
					gameLaunch = false;
					break;
				}
			default:
				break;
			}
		}
		s.close();
	}
}
