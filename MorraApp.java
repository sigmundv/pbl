import java.util.*;

public class MorraApp {
	
	public static void main (String args[]){
	
		Morra myMorra = new Morra(); // Instantiate a Morra game

		System.out.println("Welcome to Morra.");
		System.out.println("In this variation of the game, one player is going to be the “Odds” player and the other player is the “Evens” player." );

		Scanner reader = new Scanner(System.in);  // Reading from System.in

		String choice = "yes"; // This value will be used to decide when the game is over.

		int playerScore = 0; // Initialise player's score.
		int computerScore = 0; // Initialise computer's score.
		int wonHuman=0; // Initialise the number of rounds won by the human player
		int lostHuman=0; // Initialise the number of rounds LOST by the human player
		int compFingers=0; // Initialise the number of fingers the computer plays
		int fingers=0; // Initialise the number of fingers played by the human
		int oddOrEven=0; // Initialise the selection of odd/even
		int round=0; // Initialise a counter for the number of rounds played
		int game=0; // Initialise a counter for the number of GAMES played
		int computerBonus = 0;
		int computerEvenFingers = 0;
		int computerOddFingers = 0;
		int playerBonus = 0;
		int playerEvenFingers = 0;
		int playerOddFingers = 0;
		
		
		// Initialise an array for storing a history of fingers played
		// and another array for the history of rounds won/lost.
		// We deem a length of 99 to be sufficient for this purpose
		
		int fingerHistory[][] = new int [99][2];
		int wonLost[][]= new int [99][2];
		
		// Initialise two array lists for storing game history
		// We choose array list for flexibility and efficiency
		// and also to show another array like data structure
		
		List<List<Integer>> gameHistory = new ArrayList<>();
		List<Integer> roundHistory = new ArrayList<>();
		
		// We use a do-while loop to make sure that the game is always executed at least once
		
		do {
			
			myMorra.setComputerScore(computerScore);
			myMorra.setComputerBonus(computerBonus);
			myMorra.setComputerEvenFingers(computerEvenFingers);
			myMorra.setComputerOddFingers(computerOddFingers);
			myMorra.setPlayerScore(playerScore);
			myMorra.setPlayerBonus(playerBonus);
			myMorra.setPlayerEvenFingers(playerEvenFingers);
			myMorra.setPlayerOddFingers(playerOddFingers);
			myMorra.setLostHuman(lostHuman);
			myMorra.setWonHuman(wonHuman);
			
			System.out.println();
			System.out.println("Round "+ (round +1));
			System.out.println();
			
			
			// This do-while loop checks whether the user
			// entered and integer that's either 1 or 2
			
			do {
				System.out.println("Would you like to be odds or evens? 1 = odds 2 = evens");
				
				// This if-else block checks whether the user typed an integer
				// if the user typed an integer, save it to a variable,
				// otherwise don't do anything with the input and ask the user to type either 1 or 2
				
				if (reader.hasNextInt()) {
					
					oddOrEven = reader.nextInt();
				
				} else {
				
					reader.next();
					System.out.println("Please type either 1 or 2");
				
				}
			} while (oddOrEven < 1 || oddOrEven > 2);

					
			myMorra.setOddOrEven(oddOrEven); // Pass the read integer to the game class

			// Similarly to above this do-while loop checks whether
			// the number of fingers shown is between 1 and 10
			
			do {
				System.out.println("How many fingers would you like to show? Enter 1-10");
				
				// See above for further explanation of this if-else block
				
				if (reader.hasNextInt()) {
				
					fingers = reader.nextInt(); // Read in fingers player is choosing.
					
				} else {
					
					reader.next();
					System.out.println("Please type a number between 1 and 10");
					
				}
			} while (fingers <1 || fingers>10);


			myMorra.setFingers(fingers); // Pass the number of fingers chosen to the game class

			myMorra.compute(); // Do the scoring as defined in the game class
			
			compFingers=myMorra.getCompFingers(); // Get the number of fingers shown by the computer
			
			// Get the score from the game class so we can determine when to end the game
			
			playerScore = myMorra.getPlayerScore(); 
			computerScore = myMorra.getComputerScore();
			
			// Store the number of rounds won/lost in an array
			// to be used for printing game history
			
			wonLost[round][0] = myMorra.getWonHuman();
			wonLost[round][1] = myMorra.getLostHuman();

			// Store the number of fingers played by human/computer
			// in an array to the used for printing game history
			
			fingerHistory[round][0] = fingers;
			fingerHistory[round][1] = compFingers;
			
			round++; // Increment the round counter

			// This if-else-if block is ending the game if either
			// the human player or the computer player reach a score
			// of 6 or more

			if (playerScore >= 6 ){
				System.out.println("====================================================");
				System.out.println("You have won; your score is " + playerScore);
				System.out.println("====================================================");
				
				// The score of the human player is reset
				// in preparation for a possible second game
				
				playerScore = 0; 
				computerScore = 0;
				computerBonus = 0;
				computerEvenFingers = 0;
				computerOddFingers = 0;
				playerBonus = 0;
				playerEvenFingers = 0;
				playerOddFingers = 0;
				lostHuman = 0;
				wonHuman = 0;
				
				game++; // The game counter is incremented
				
				// Some game history is printed
				
				printRoundHistory(round, fingerHistory);
				printWonLost(round, wonLost);
				roundHistory.addAll(
						Arrays.asList(myMorra.getWonHuman(), myMorra.getLostHuman(), 
						myMorra.getPlayerOddFingers(), myMorra.getPlayerEvenFingers(), 
						myMorra.getComputerOddFingers(), myMorra.getComputerEvenFingers(),
						myMorra.getPlayerBonus(), myMorra.getComputerBonus()));
				gameHistory.add(roundHistory);
				roundHistory = new ArrayList<>();
				
				// Now we ask the user if they want to play again or not
				System.out.print("\nDo you want to play again? Enter yes or no: ");
				choice = reader.next();
				
				round = 0;
				

			} else if (computerScore >= 6) {
				System.out.println("====================================================");
				System.out.println("The computer has won the game; its score is " + computerScore);
				System.out.println("====================================================");
				
				playerScore = 0;
				computerScore = 0;
				computerBonus = 0;
				computerEvenFingers = 0;
				computerOddFingers = 0;
				playerBonus = 0;
				playerEvenFingers = 0;
				playerOddFingers = 0;
				lostHuman = 0;
				wonHuman = 0;
				
				game++;

				printRoundHistory(round, fingerHistory);
				printWonLost(round, wonLost);
				roundHistory.addAll(
						Arrays.asList(myMorra.getWonHuman(), myMorra.getLostHuman(), 
						myMorra.getPlayerOddFingers(), myMorra.getPlayerEvenFingers(), 
						myMorra.getComputerOddFingers(), myMorra.getComputerEvenFingers(),
						myMorra.getPlayerBonus(), myMorra.getComputerBonus()));
				gameHistory.add(roundHistory);
				roundHistory = new ArrayList<>();
				
				System.out.print("\nDo you want to play again? Enter yes or no: ");
				choice = reader.next();
				
				round = 0;
			
			}

		} while (!choice.equals("no")); //end game loop
		
		
		System.out.println();
		System.out.println("**** Game History *****");
		System.out.println();
		printGameHistory(gameHistory);
		System.out.println();
		System.out.println("No of games played  " + game);
		System.out.println();
		System.out.println("Game Over. Thank you for playing. Goodbye!");

	}//end main method

	public static void printRoundHistory(int round, int[][] fingerHistory){
		
		// This method prints out the contents of the fingerHistory array
		
		System.out.println("");
		System.out.printf("%5s | %7s | %18s\n","Round","Fingers","Computer's Fingers");
		
		for (int i = 0; i < round; i++) {

			System.out.printf(
					"%-5d | %-7d | %-18d\n",
					i+1, 
					fingerHistory[i][0],
					fingerHistory[i][1]);
		}
	}

	public static void printWonLost(int round, int[][] wonLost){
		
		// This method prints the number of rounds played
		// along with the number of rounds won/lost by the player
		
		System.out.println("");
		System.out.printf("%12s | %10s | %11s\n","Total Rounds","Player Won","Player Lost");
		System.out.printf("%-12d | %-10d | %-11d\n", round, wonLost[round-1][0], wonLost[round-1][1]);

	}
	
	public static void printGameHistory(List<List<Integer>> gameHistory) {
		
		int i = 0;
		for (List<Integer> game : gameHistory) {
			System.out.print("\n********* Game " + (++i) + " *********\n\n");
			System.out.printf("%12s | %12s | %15s\n", "", "Human Player", "Computer Player");
			
			System.out.printf("%-12s | %-12s | %-15s\n", "Rounds won", game.get(0), game.get(1));
			System.out.printf("%-12s | %-12s | %-15s\n", "Even numbers", game.get(3), game.get(5));
			System.out.printf("%-12s | %-12s | %-15s\n", "Odd numbers", game.get(2), game.get(4));
			System.out.printf("%-12s | %-12s | %-15s\n", "Bonus points", game.get(6), game.get(7));
			
		}
		
	}

} //class end

