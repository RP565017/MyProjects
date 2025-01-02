package com.myproject.test;

public class Main {

	public static void main(String[] args) {

		boolean gameOver = true;
		int score = 5000;
		int levelCompleted = 5;
		int bonus = 100; 
		
		if ( score <= 5000 && score <= 4000 && !gameOver ) {
			
			System.out.println("Your Score is 5000");
		} else if (score > 5000 || levelCompleted == 5){
			
			System.out.println("Your score is greater than 5000");
		} else if (bonus < 5000 || levelCompleted == 5){
			
			System.out.println("Your score is greater than 5000");
		}else {
			
			System.out.println("Got here");
		}
		

	}

}
