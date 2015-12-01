package Game;

import java.util.ArrayList;

public class QuestionBank {
	// So Daniel and Kito want to use a random question thing so right now assuming
	// ArrayList will be suitable to store questions
	// Not sure if we want a string solution, might be better for Fraction solution
	// We might be able to do map in this case

	private ArrayList<Question> questions;
	private ArrayList<String> solution;
	
	public QuestionBank() {
		initialize();

	}
	
	private void initialize() {
		questions = new ArrayList<Question>();
		solution = new ArrayList<String>();
		
		initializeQuestionBank();
	}
	
	private void initializeQuestionBank() {
		Question testQ = new Question("testing first fraction 1 and second fraction 2", new Fraction(1, 2), new Fraction(2, 1));
		System.out.println(testQ.toString());
	}

	public String getQuestion() {
		return questions.get(0).toString();
	}
	
	public String getSoluton() {
		return solution.get(0).toString();
	}

	public boolean evaluateGuess() {
		return false;
	}

	public void generateQuestions(){
		questions.clear();
		solution.clear();
		//TODO: call solution and add in to arraylist
	}
	
	public Fraction addSolution(int numerator1,int denominator1,int numerator2,int denominator2){
		int newNumerator=numerator1*denominator2+denominator1*numerator2;
		int newDenominator=denominator1*denominator2;
		Fraction temp = new Fraction (newNumerator,newDenominator);
		return temp;
	}
	
	public Fraction minusSolution(int numerator1,int denominator1,int numerator2,int denominator2){
		int newNumerator=numerator1*denominator2-denominator1*numerator2;
		int newDenominator=denominator1*denominator2;
		Fraction temp = new Fraction (newNumerator,newDenominator);
		return temp;
	}
	
	public Fraction multiplySolution(int numerator1,int denominator1,int oneInt){
		int newNumerator=numerator1*oneInt;
		Fraction temp = new Fraction (newNumerator,denominator1);
		return temp;
	}
	
	//no need for divisionSolution
}
