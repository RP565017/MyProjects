package com.myproject.test;

public class MainChallege {

	public static void main(String[] args) {

		boolean gameOver = true;
		int score = 800;
		int levelCompleted = 5;
		int bonus = 100;
		
		int finalScore = score;
		
		calculateScore(true, 800, 5, 100);
		
		score = 1000;
		levelCompleted = 8;
		bonus = 100;

		finalScore = score;

		if (gameOver) {

			finalScore += (levelCompleted * bonus);

			System.out.println("Your final score is " + finalScore);

		}
	}

	 public static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus ) {

		int finalScore = score;

		if (gameOver) {

			finalScore += (levelCompleted * bonus);

			finalScore += 1000;

			System.out.println("Your final score is inside Method "  + "  " + finalScore);

		}


	}
}
