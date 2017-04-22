import java.util.Random;
import java.util.Scanner;

public class Morra {

	private int playerScore = 0; // Initialise player's score.
	private int computerScore = 0; // Initialise computer's score.
	private int wonHuman = 0;
	private int lostHuman = 0;
	private int playerBonus = 0;
	private int computerBonus = 0;
	private int playerOddFingers = 0;
	private int playerEvenFingers = 0;
	private int computerOddFingers = 0;
	private int computerEvenFingers = 0;
	private int oddOrEven;
	private int fingers;
	private int compFingers;
	private int sum;

	public Morra(){
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

	public void setWonHuman(int wonHuman) {
		this.wonHuman = wonHuman;
	}


	public void setLostHuman(int lostHuman) {
		this.lostHuman = lostHuman;
	}


	public void setPlayerBonus(int playerBonus) {
		this.playerBonus = playerBonus;
	}


	public void setComputerBonus(int computerBonus) {
		this.computerBonus = computerBonus;
	}


	public void setPlayerOddFingers(int playerOddFingers) {
		this.playerOddFingers = playerOddFingers;
	}


	public void setPlayerEvenFingers(int playerEvenFingers) {
		this.playerEvenFingers = playerEvenFingers;
	}


	public void setComputerOddFingers(int computerOddFingers) {
		this.computerOddFingers = computerOddFingers;
	}


	public void setComputerEvenFingers(int computerEvenFingers) {
		this.computerEvenFingers = computerEvenFingers;
	}


	public void compute() {


		Random r = new Random(); // Initialise the Random r variable.
		compFingers = r.nextInt(10) + 1; // Computer fingers is a random number between 1 and 10.
		
		if (fingers % 2 == 0) {
			playerEvenFingers++;
		} else {
			playerOddFingers++;
		}
		
		if (compFingers % 2 == 0) {
			computerEvenFingers++;
		} else {
			computerOddFingers++;
		}

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
			playerBonus++;
			System.out.println("You got a bonus point for being closer to the sum");
		}else {
			computerScore++;
			computerBonus++;
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

	//get methods

	//returns sum to App class
	public int getSum() { 
		return sum;
	}
	//returns compfingers to app class
	public int getCompFingers() {
		return compFingers;
	}
	// returns player score
	public int getPlayerScore() {
		return playerScore;
	}


	public int getComputerScore() {// 
		return computerScore;
	}

	public int getWonHuman() {
		return wonHuman;
	}

	public int getLostHuman() {
		return lostHuman;
	}


	public int getPlayerBonus() {
		return playerBonus;
	}
	
	public int getComputerBonus() {
		return computerBonus;
	}

	public int getPlayerOddFingers() {
		return playerOddFingers;
	}


	public int getPlayerEvenFingers() {
		return playerEvenFingers;
	}


	public int getComputerOddFingers() {
		return computerOddFingers;
	}


	public int getComputerEvenFingers() {
		return computerEvenFingers;
	}

}


