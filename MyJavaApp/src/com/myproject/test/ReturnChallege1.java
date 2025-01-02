package com.myproject.test;

public class ReturnChallege1 {

	public static void main(String[] args) {

		boolean gameOver = true;
		int score = 800;
		int levelCompleted = 5;
		int bonus = 100;
		
		
	//	calculateScore(true, 800, levelCompleted, bonus);
		
		int finalScore = calculateScore(gameOver, score, levelCompleted, bonus);
		
		System.out.println("Your final score is :" + finalScore);
		System.out.println("Your 2nd final score is :" + calculateScore(true, 1000, 8, 100));
		
	}

	 public static int  calculateScore(boolean gameOver, int score, int levelCompleted, int bonus ) {

		int finalScore = score;

		if (gameOver) {

			finalScore += (levelCompleted * bonus);

			finalScore += 1000;

		}

		return finalScore;
	}
}
