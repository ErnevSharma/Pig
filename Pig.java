import java.util.Scanner;

public class Pig {
	public static void main(String[] args) {
		/*
		 * Need a player and a computer Player goes first Need a sum, a
		 * PairOfDie object sum goes to 0 if either PairOfDie = 1 total goes to
		 * 0 if two ever = 1 also need a flag, y/n
		 */

		PairOfDice a = new PairOfDice();
		boolean playerTurn = true, gameOver = false;
		;
		int sum = 0, playerTotal = 0, computerTotal = 0;
		String ans = " ";
		Scanner scan = new Scanner(System.in);

		while (!gameOver) {
			while (playerTurn) {
				a.roll();
				System.out.println("You got \n" + a + "\n");
				sum += a.sum();

				if (a.getFace1() == 1 && a.getFace2() == 1) {
					sum = 0;
					playerTotal = 0;
					playerTurn = false;
					System.out.println("1 rolled, turn lost.");
					scan.nextLine();
				} else if (a.getFace1() == 1 || a.getFace2() == 1) {
					sum = 0;
					playerTurn = false;
					System.out.println("Two 1's rolled, turn lost.");
					scan.nextLine();
				}
				System.out.println("Player Score: " + sum);

				if (playerTurn) {
					System.out.println("Would you like to play again?(y/n)");
					ans = scan.nextLine();

					if (ans.equalsIgnoreCase("n")) {
						playerTurn = false;
					}
				}
			}

			playerTotal += sum;

			if (playerTotal >= 100)
				gameOver = true;

			sum = 0;

			while (!playerTurn && !gameOver) {
				a.roll();
				System.out.println("Computer got \n" + a + "\n");
				sum += a.sum();

				if (a.getFace1() == 1 && a.getFace2() == 1) {
					sum = 0;
					computerTotal = 0;
					playerTurn = true;
				} else if (a.getFace1() == 1 || a.getFace2() == 1) {
					sum = 0;
					playerTurn = true;
				}
				System.out.println("Computer Score: " + sum);

				if (sum >= 20) {
					playerTurn = true;
				}
				if (computerTotal + sum >= 100) {
					gameOver = true;
				}
			}

			computerTotal += sum;
			if (playerTotal >= 100)
				gameOver = true;

			sum = 0;

		}

		if (computerTotal >= 100)
			System.out.println("Computer Wins!");
		else
			System.out.println("Player Wins!");

	}
}