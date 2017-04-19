package pbl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Morra {

	public static void main(String[] args) {

		System.out.println("Welcome to Morra.");

		Scanner reader = new Scanner(System.in);  // Reading from System.in

		String choice = "yes"; // This value will be used to decide when the game is over.

		int playerScore = 0; // Initialise player's score.
		int computerScore = 0; // Initialise computer's score.
		int saveScore[];
		int wonHuman=0;
		int lostHuman=0;
		int game = 0;
		Map<Integer, List<Integer>> wonLostHuman = new HashMap<>();

		do { // Begin the game

			//**It needs to check if any player is on 6 points or higher and skip
			//**the loop if they are because the game is over.

			System.out.println();
			System.out.println("Would you like to be odds or evens? 1 = odds 2 = evens");
			int oddOrEven = reader.nextInt(); // Read users choice from console. If you don't select 1 or 2, the player will always be evens.
			while (oddOrEven < 1 || oddOrEven > 2) {
				System.out.println("Please enter either 1 or 2");
				oddOrEven = reader.nextInt();
			}

			System.out.println("How many fingers would you like to show? Enter 1-10");
			int fingers = reader.nextInt(); // Read in fingers player is choosing.
			while (fingers < 1 || fingers > 10) {
				System.out.println("Please enter a number between 1 and 10 inclusive");
				fingers = reader.nextInt();
			}

			Random r = new Random(); // Initialise the Random r variable.
			int compFingers = r.nextInt(10) + 1; // Computer fingers is a random number between 1 and 10.

			System.out.println("Computer shows " + compFingers + " fingers."); // Show computer's choice.

			int sum = compFingers + fingers; // Calculate the sum.
			System.out.println();

			if(sum % 2 == 0){ // If sum is even (ie. if the sum divided by 2 gives no remainder)
				System.out.println("The sum is " + sum + " and is even.");

				if(oddOrEven == 1){ // Player chose odds
					System.out.println("Computer scored!");
					computerScore+=2;
					lostHuman++;
				}
				else{ // Player chose evens
					System.out.println("You scored!");
					playerScore+=2;
					wonHuman++;
				}
			}
			else{ // Sum is odd
				System.out.println("The sum is " + sum + " and is odd.");

				if(oddOrEven == 1){ // Player chose odds
					System.out.println("You scored!");
					playerScore+=2;
					wonHuman++;
				}
				else{ // Player chose evens
					System.out.println("Computer scored!");
					computerScore+=2;
					lostHuman++;
				}
			}

			if(fingers > compFingers){
				playerScore++;
				System.out.println("You got a bonus point for being closer to the sum");
			}else {
				computerScore++;
				System.out.println("The computer got a bonus point for being closer to the sum");
			}//**Here you need to add code which gives the bonus point.

			System.out.println();
			System.out.println();
			System.out.println("Player score = " + playerScore);
			System.out.println("Computer score = " + computerScore);
			System.out.println(lostHuman+" "+wonHuman);

			//**Here you need to close the loop I mentioned on line 19.
			if (playerScore >= 6 ){

				System.out.println("You have won; your score is " + playerScore);
				System.out.print("Do you want to play again? Enter yes or no: ");//**Here you need to ask the player if they want to continue playing again
				choice = reader.next();
				playerScore = 0;
				computerScore = 0;
				wonLostHuman.put(++game, Arrays.asList(wonHuman, lostHuman));
				
			} else if (computerScore >= 6){
				
				System.out.println("The computer has won; its score is " + computerScore);
				System.out.print("Do you want to play again? Enter yes or no: ");//**Here you need to ask the player if they want to continue playing again
				choice = reader.next();
				playerScore = 0;
				computerScore = 0;
				wonLostHuman.put(++game, Arrays.asList(wonHuman, lostHuman));
				
			}

			//**and update the 'choice' variable with the answer. If they enter 'n', the while loop will break
			//**and the game will end.

		} while (!choice.equals("no"));
		
		reader.close();
		
		System.out.println();
		System.out.println("Game Over. Thank you for playing. Goodbye!");
		System.out.println(wonLostHuman);
		//**Here you need to add code that iterates through the gameHistory array and prints out
		//**the details of each game.

	}

}
