import java.util.*;

public class MorraApp {
	public static void main (String args[]){
		Morra mymorra = new Morra();



			System.out.println("Welcome to Morra.");
				System.out.println("In this variation of the game, one player is going to be the “Odds” player and the other player is the “Evens” player." );

				Scanner reader = new Scanner(System.in);  // Reading from System.in

				String choice = "yes"; // This value will be used to decide when the game is over.

				int playerScore = 0; // Initialise player's score.
				int computerScore = 0; // Initialise computer's score.
				int wonHuman=0;
				int lostHuman=0;
				int sum=0;
				int compFingers=0;
				int fingers=0;
				int oddOrEven=0;
                                int fingerHistory[][] = new int [99][2];
                                int fingersPlayed [] = new int [2];
                                int round=0;


do {
                             
				System.out.println();
				System.out.println("Would you like to be odds or evens? 1 = odds 2 = evens");
				oddOrEven = reader.nextInt(); // Read users choice from console. If you don't select 1 or 2, the player will always be evens.
				mymorra.setOddOrEven(oddOrEven);

				System.out.println("How many fingers would you like to show? Enter 1-10");
				fingers = reader.nextInt(); // Read in fingers player is choosing.
				mymorra.setFingers(fingers);

				mymorra.compute();
				sum=mymorra.getSum();
				compFingers=mymorra.getCompFingers();
                                playerScore = mymorra.getPlayerScore();
                                computerScore = mymorra.getComputerScore();
                                
                                fingerHistory[round][0]= fingers;
                                fingerHistory[round][1]=compFingers;
                                round++;
                               
                              
                               if (playerScore >= 6 ){

				System.out.println("You have won; your score is " + playerScore);
				System.out.print("Do you want to play again? Enter yes or no: ");//**Here you need to ask the player if they want to continue playing again
				choice = reader.next();
				playerScore = 0;
				computerScore = 0;
				
				
			} else if (computerScore >= 6){
				
				System.out.println("The computer has won; its score is " + computerScore);
				System.out.print("Do you want to play again? Enter yes or no: ");//**Here you need to ask the player if they want to continue playing again
				choice = reader.next();
				playerScore = 0;
				computerScore = 0;
				
				
			}

}

while(!choice.equals("no"));//end game loop

System.out.println("****Game History *****");
System.out.println("***Results from the Rounds****");
            for (int i = 0; i < round; i++) {
                
                    System.out.println(i+1 + " = " + 
                            fingerHistory[i][0]+ " | " + 
                            fingerHistory[i][1]);
                
            }
System.out.println();
		System.out.println("Game Over. Thank you for playing. Goodbye!");
	}//end main method
}//class end

