package Game;

import java.util.ArrayList;
import java.util.Random;

public class QuestionBank {
	// So Daniel and Kito want to use a random question thing so right now assuming
	// ArrayList will be suitable to store questions
	// Not sure if we want a string solution, might be better for Fraction solution
	// We might be able to do map in this case

	private ArrayList<Question> questions;
	private ArrayList<String> solution;
	private int currentLevel;
	Random rand = new Random();
	
	public QuestionBank(int level) {
		this.currentLevel = level;
		initialize();
	}
	
	private void initialize() {
		questions = new ArrayList<Question>();
		solution = new ArrayList<String>();
		
		initializeQuestionBank();
		printQuestionBankContents();
	}
	
	private void initializeQuestionBank() {
		Question testQ1 = new Question("{FRACTION1} - {FRACTION2} = ", getRandomFraction(currentLevel), getRandomFraction(currentLevel));
		Question testQ2 = new Question("{FRACTION1} + {FRACTION2} = ", getRandomFraction(currentLevel), getRandomFraction(currentLevel));
		questions.add(testQ1);
		questions.add(testQ2);		
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
	
	public Question getRandomQuestion() {
		return questions.get(rand.nextInt(questions.size()));
	}
	
	public Fraction getRandomFraction(int level) {
		int initial = 4;
		int levelScaling = level * 2;
		int randNumerator = rand.nextInt(initial + levelScaling) + 1;
		int randDenominator = rand.nextInt(initial + levelScaling) + 1;
		return new Fraction(randNumerator, randDenominator);
	}
	
	public void generateQuestions(){
		questions.clear();
		solution.clear();
		//TODO: call solution and add in to arraylist
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
	
	// METHODS FOR TESTING PURPOSES
	public void printQuestionBankContents() {
		for (Question q : questions) {
			System.out.println(q);
		}
	}
}
