package Game;

import java.util.ArrayList;

public class QuestionBank {
	// So Daniel and Kito want to use a random question thing so right now assuming
	// ArrayList will be suitable to store questions
	// Not sure if we want a string solution, might be better for Fraction solution
	// We might be able to do map in this case

	private ArrayList<String> question;
	private ArrayList<String> solution;
	
	public QuestionBank() {
		question.add("Test");
		solution.add("test");
	}
	
	public String getQuestion() {
		return question.get(0);
	}
	
	public String getSoluton() {
		return solution.get(0);
	}
}
