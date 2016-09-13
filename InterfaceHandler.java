package com.onlinequiz;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class InterfaceHandler {
	
	ArrayList<InputQuestion> qList = new ArrayList<InputQuestion>();
	static ArrayList<QuizModel> Quiz = new ArrayList<QuizModel>();
	
	public static void main(String [] args){
		
		new InterfaceHandler().go();		
	}
	
	public void go(){
		populateQuiz();
		generateQuiz();
	}
	
	public void generateQuiz(){
		System.out.println("Generating Quiz...");
		System.out.println(Quiz.toString());
	}

	public void populateQuiz(){
		Boolean more = false;
		DBOps db = new DBOps();
		try {
			Connection conn = db.establishDBConnection();		
			
			String query ="SELECT* FROM Questions_Database where subject =? and difficulty_level=? ";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
		
			
			SelectQuestion t = new SelectQuestion();
			t.SelectQuestions();
			

			pstmt.setString(1, t.getSubject());
			pstmt.setString(2, t.getDifficultyLevel());
			ResultSet quest = pstmt.executeQuery();
			
	//		ResultSet quest = stmt.executeQuery(query);
			
			int count = 1;
			while(quest.next()){
				
				Quiz.add(new QuizModel(quest.getString("Question"),
						   quest.getString("option1"),quest.getString("option2"),
						   quest.getString("option3"),quest.getString("option4"),
						   quest.getString("answer")));
				count++;
				if (count>t.getNumberOfQuestions()) {
					break;
				}
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Do you want to manually add more Questions? ");
			String answer = br.readLine();
			if(answer.equals("y") || answer.equals("Y"))
				more = true;
			
			while(more){
				
				InputQuestion ques = new InputQuestion();
				Quiz.add(new QuizModel(ques.getQuestion(), ques.getOption1(), ques.getOption2(), ques.getOption3(), ques.getOption4(), ques.getAnswer()));
				ques.addToDB(ques, conn);
				System.out.print("Do you want to add another question? ");
				answer = br.readLine();
				System.out.println(answer);
				if(answer.equals("y") || answer.equals("Y"))
					more = true;
				else{
					more = false;
					//System.out.println("false");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
