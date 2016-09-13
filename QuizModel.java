package com.onlinequiz;

public class QuizModel {

	protected String question;
	protected String option1;
	protected String option2;
	protected String option3;
	protected String option4;
	protected String answer;
	
	public QuizModel(String q,String o1,String o2,String o3,String o4,String ca){
		this.question = q;
		this.option1  = o1;
		this.option2  = o2;
		this.option3  = o3;
		this.option4  = o4;
		
		this.answer = ca;
	}
	
	public String toString(){
		return ("\n"+"  "+question+"\n"+"A "+option1+"\n"+"B "+option2+"\n"+"C "+option3+"\n"+"D "+option4+"\n");
	}
	
	public QuizModel(){};
	
}
