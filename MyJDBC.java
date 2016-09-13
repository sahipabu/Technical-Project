package com.onlinequiz;

import java.sql.*;
import java.util.Scanner;

public class MyJDBC {
	
	private static int score=0;
	
	@SuppressWarnings("resource")
	public static String getAnswer(String answer){
		String ans = answer;
		if(ans.equals("A") || ans.equals("B") || ans.equals("C") || ans.equals("D") ){
			return ans;
		}else{
			Scanner reader1 = new Scanner(System.in);  // Reading from System.in
			System.out.println("Enter A/B/C/D : " );
			String ans1;
			ans1 = reader1.next();
			return getAnswer(ans1);
		}
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		
		int Ques_no = 0;
		try {	
			
			DBOps db = new DBOps();
			Connection conn = db.establishDBConnection(); //Establishing connection to database
			Statement stat1 = conn.createStatement();
			String query = "SELECT  * FROM (SELECT  * FROM   Questions_Database ORDER BY dbms_random.value) WHERE rownum <= 4"; //Create Statement,Prepared Statement,Callable Statement
			ResultSet rs = stat1.executeQuery(query); //Execute the query
			while(rs.next()){ //Giving the info about next row and moving to the next row.
				Ques_no = Ques_no+1;
				System.out.println((Ques_no)+"."+rs.getString(1)+" ");
				System.out.println("(a)" + rs.getString(2)+" ");
				System.out.println("(b)"+rs.getString(3)+" ");
				System.out.println("(c)"+rs.getString(4)+" ");
				System.out.println("(d)"+rs.getString(5)+" ");
				
				Scanner reader = new Scanner(System.in);  // Reading from System.in
				System.out.println("Enter A/B/C/D: ");
				String answer = reader.next();
				String final_ans = getAnswer(answer);
				System.out.println("Final_answer :"+ final_ans);
				if(final_ans.equals(rs.getString(6))){
					System.out.println("Right answer");
					score = score +1;
				}else{
					System.out.println("Wrong answer");
					System.out.println("Right Answer is : "+ rs.getString(6));
				}
			}
			//System.out.println("Connection = "+ conn);
		} catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Your score is : "+ score);
	}
}

//As soon as you execute a statement it is executed in database. you do not have control after that.
//executeUpdate returns the integer values of number rows has been updated
//boolean execute returns true or false based on the status.
