package studio8;

import java.util.Scanner;

public class Quiz {

	private Question[] questions;
	
	public Quiz(Question[] questions) {
		this.questions = questions;
	}
	
	private String getUserAnswer() {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your answer: ");
		String out = in.next();
		return out;
	}
	
	public int getTotalPoints() {
		int sum = 0;
		for(Question q : questions) {
			sum += q.getPoints();
		}
		return sum;
	}
	
	public void takeQuiz() {
		int pointsTotal = 0;
		for(Question q : questions) {
			q.displayPrompt();
			int i = q.checkAnswer(getUserAnswer());
			pointsTotal += i;
			System.out.println("Points earned: " + i);
			
		}
		System.out.println("Score: " + pointsTotal + "/" + getTotalPoints());
	}
	
	public static void main(String[] args) {
		Question q = new Question("What number studio is this?", "8", 2);

		String[] choices = {"seven", "nine", "eight", "six"};
		Question multipleChoice = new MultipleChoiceQuestion("What studio is this?", "3", 1, choices);

		choices = new String[] {"instance variables", "git", "methods", "eclipse"};
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", choices);

		choices = new String[] {"Manchester City", "Arsenal", "Manchester United", "Liverpool"};
		Question premLeague = new MultipleChoiceQuestion("Which team won the Premier League last season?", "1", 69, choices);
		
		
		choices = new String[] {"Joao Klauss", "Chicho Arango", "Jared Stroud", "Eduard Lowen"};
		Question stlCITY = new SelectAllQuestion("Which players play for STL CITY SC?", "14", choices);
		
		Question[] questions = {q, multipleChoice, selectAll, premLeague, stlCITY}; //create and add more questions!
		
		Quiz studio8quiz = new Quiz(questions);
		studio8quiz.takeQuiz();
	}
}
