package com.myproject.test;

public class MainChallege1 {

	public static void main(String[] args) {

		boolean gameOver = true;
		int score = 800;
		int levelCompleted = 5;
		int bonus = 100;
		
		
	//	calculateScore(true, 800, levelCompleted, bonus);
		calculateScore(gameOver, score, levelCompleted, bonus);
		
		calculateScore(true, 1000, 8, 100);
		

	}

	 public static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus ) {

		int finalScore = score;

		if (gameOver) {

			finalScore += (levelCompleted * bonus);

			finalScore += 1000;

			System.out.println("Your final score is :" + finalScore);

		}


	}
}
