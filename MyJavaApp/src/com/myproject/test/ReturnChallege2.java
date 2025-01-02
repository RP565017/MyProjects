package com.myproject.test;

public class ReturnChallege2 {

	public static void main(String[] args) {

		String playerName = "Ravi";

		int playerPosition = 2;

		int playerScore = 501;

		display(playerName, playerPosition);

		System.out.println("Player HighScore Poistion : " + calculateHighScore(playerScore));

	}

	private static int calculateHighScore(int playerScore) {

	//	int position;  Still U can use this variable 
		
		if (playerScore >= 1000) {

			return 1;
		} else if (playerScore >= 500 && playerScore < 1000) {

			return 2;
		} else if (playerScore >= 100 && playerScore < 500) {

			return 3;
		} else {
			return 4;
		}
		
	}

	public static void display(String playerName, int playerPosition) {

		System.out.println("Player Name is : " + playerName + "  playerPosition is : " + playerPosition);

	}
}
