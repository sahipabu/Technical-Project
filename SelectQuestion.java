package com.onlinequiz;

//COMMENT
//COMMENT1

import java.util.*;

public class SelectQuestion {
	
	private String subject;
	private String difficultyLevel;
	private int numberOfQuestions ;
	
	public void SelectQuestions(){
		
		System.out.print("Please enter the Subject: ");
		Scanner reader = new Scanner(System.in);
		subject = reader.next();
		
		System.out.print("Difficulty_Level: ");
		difficultyLevel = reader.next();
		//from ravi
		System.out.print("Questions: ");
		numberOfQuestions = reader.nextInt();	
	}

	public String getSubject() {
		return subject;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	
		
}

