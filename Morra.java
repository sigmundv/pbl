import java.util.Random;
import java.util.Scanner;

public class Morra {

				private int playerScore = 0; // Initialise player's score.
				private int computerScore = 0; // Initialise computer's score.
				private int saveScore[];
				private int wonHuman=0;
				private int lostHuman=0;
				private int oddOrEven;
				private int fingers;
				private int sum;
				private int compFingers;

public void Morra(){
				 //Constructor
				 oddOrEven=0;
				 fingers=0;
}


	// set  methods
			public void setOddOrEven(int oddOrEven){
			this.oddOrEven = oddOrEven;
		}

			public void setFingers(int fingers){
			this.fingers = fingers;
		}

                        public void setComputerScore(int computerScore){
                        this.computerScore= computerScore;
                                }
                        public void setPlayerScore(int playerScore){
                        this.playerScore= playerScore;
                                }
// compute method

public void compute() {


			Random r = new Random(); // Initialise the Random r variable.
			 compFingers = r.nextInt(10) + 1; // Computer fingers is a random number between 1 and 10.

                         System.out.println("--------------------------------------");
		System.out.println("Computer shows " + compFingers + " fingers."); // Show computer's choice.
                System.out.println("-----------------------------------------------");
					 sum = compFingers + fingers; // Calculate the sum.
					System.out.println();

					if(sum % 2 == 0){ // If sum is even (ie. if the sum divided by 2 gives no remainder)
						System.out.println("The sum is " + sum + " and is even.");

						if(oddOrEven == 1){ // Player chose odds
                                                        System.out.println();   
							System.out.println("Computer scored!******");
							computerScore+=2;
							lostHuman++;
						}
						else{ // Player chose evens
                                                    System.out.println();
							System.out.println("You scored!*******");
							playerScore+=2;
							wonHuman++;
						}
					}
					else{ // Sum is odd
						System.out.println("The sum is " + sum + " and is odd.");

						if(oddOrEven == 1){ // Player chose odds
                                                    System.out.println();
							System.out.println("You scored!*******");
							playerScore+=2;
							wonHuman++;
						}
						else{ // Player chose evens
                                                    System.out.println();
							System.out.println("Computer scored!*******");
							computerScore+=2;
							lostHuman++;
						}
					}

					if(fingers > compFingers){
						playerScore++;
                                                
						System.out.println("You got a bonus point for being closer to the sum");
					}else {
						computerScore++;
                                                System.out.println();
						System.out.println("The computer got a bonus point for being closer to the sum");
					}//**Here you need to add code which gives the bonus point.

					System.out.println();
					System.out.println("***************Round Score******************");
					System.out.println("Player has = " + playerScore + " points");
					System.out.println("Computer has = " + computerScore+ " points");
                                        System.out.println();
					System.out.println("Round Score : = " + "Computer has won " +lostHuman+ " Rounds  : You have won " +wonHuman+ " Rounds");



			


		}

					//get method
						public int getSum(){
									return sum;
							}
						public int getCompFingers(){
							return compFingers;
							}
                                                
                                                public int getPlayerScore() {
                        return playerScore;
    }
                                               

    public int getComputerScore() {
        return computerScore;
    }

			//**and update the 'choice' variable with the answer. If they enter 'n', the while loop will break
			//**and the game will end.






}


