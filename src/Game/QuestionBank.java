package Game;

import java.util.ArrayList;
import java.util.Random;
import Game.QuestionType;

public class QuestionBank {
	// So Daniel and Kito want to use a random question thing so right now assuming
	// ArrayList will be suitable to store questions
	// Not sure if we want a string solution, might be better for Fraction solution
	// We might be able to do map in this case

	private ArrayList<Question> questions;
	private ArrayList<Question> arithmeticQuestions;
	private ArrayList<Question> wordQuestions;
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
		arithmeticQuestions = new ArrayList<Question>();
		wordQuestions = new ArrayList<Question>();
		
		initializeQuestionBank();
		printQuestionBankContents();
	}
	
	private void initializeQuestionBank() {
		initializeArithmeticQuestions();
		initializeWordQuestions();
		questions.addAll(arithmeticQuestions);
		questions.addAll(wordQuestions);
	}
	
	private void initializeArithmeticQuestions() {
		 arithmeticQuestions.add(new Question("What is {FRACTION1} - {FRACTION2}?", getRandomFraction(currentLevel, QuestionType.ARITHMETIC), getRandomFraction(currentLevel, QuestionType.ARITHMETIC)));
		 arithmeticQuestions.add(new Question("What is {FRACTION1} + {FRACTION2}?", getRandomFraction(currentLevel, QuestionType.ARITHMETIC), getRandomFraction(currentLevel, QuestionType.ARITHMETIC)));
		 arithmeticQuestions.add(new Question("What is {FRACTION1} - {FRACTION2} + {FRACTION3}?", getRandomFraction(currentLevel, QuestionType.ARITHMETIC), getRandomFraction(currentLevel, QuestionType.ARITHMETIC), getRandomFraction(currentLevel, QuestionType.ARITHMETIC)));
		 arithmeticQuestions.add(new Question("What is {FRACTION1} + {FRACTION2} - {FRACTION3}?", getRandomFraction(currentLevel, QuestionType.ARITHMETIC), getRandomFraction(currentLevel, QuestionType.ARITHMETIC),  getRandomFraction(currentLevel, QuestionType.ARITHMETIC)));	 
		 arithmeticQuestions.add(new Question("What is {FRACTION1} * {FRACTION2}?", getRandomFraction(currentLevel, QuestionType.ARITHMETIC), getRandomFraction(currentLevel, QuestionType.ARITHMETIC)));
		 arithmeticQuestions.add(new Question("Find the answer that is less than {FRACTION1}.", getRandomFraction(currentLevel, QuestionType.ARITHMETIC), getRandomFraction(currentLevel, QuestionType.ARITHMETIC)));
		 arithmeticQuestions.add(new Question("Find the answer that is greater than {FRACTION1}.", getRandomFraction(currentLevel, QuestionType.ARITHMETIC), getRandomFraction(currentLevel, QuestionType.ARITHMETIC)));
		 arithmeticQuestions.add(new Question("Find the answer that is equal to {FRACTION1}.", getRandomFraction(currentLevel, QuestionType.ARITHMETIC), getRandomFraction(currentLevel, QuestionType.ARITHMETIC)));
	}
	
	private void initializeWordQuestions() {
		wordQuestions.add(new Question("If you have a whole pizza and eat {FRACTION1} of it, how much of the pizza is left over?", getRandomFraction(currentLevel, QuestionType.WORD), getRandomFraction(currentLevel, QuestionType.WORD)));
		wordQuestions.add(new Question("Mrs. Smith baked 20 cookies. Mr. Smith ate {FRACTION1} of the cookies. How many cookies are left for the class?", getRandomFraction(currentLevel, QuestionType.WORD), getRandomFraction(currentLevel, QuestionType.WORD)));
		wordQuestions.add(new Question("If you have 20 dollars and give your friend {FRACTION1} of the total, how much money do you have left over?", getRandomFraction(currentLevel, QuestionType.WORD), getRandomFraction(currentLevel, QuestionType.WORD)));
		wordQuestions.add(new Question("If every day has 24 hours in it and you spend {FRACTION1} of your day playing video games, how much of the day do you have left to play 'MORE' video games?", getRandomFraction(currentLevel, QuestionType.WORD), getRandomFraction(currentLevel, QuestionType.WORD)));
		wordQuestions.add(new Question("Mr. Smith's house is 20 feet long and 30 feet wide. Mr. Bob's house is 2 times as long and {FRACTION1} as wide. What is the total area Mr. Bob's house?", getRandomFraction(currentLevel, QuestionType.WORD), getRandomFraction(currentLevel, QuestionType.WORD)));
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
	
	public Fraction getRandomFraction(int level, QuestionType type) {
		int initial = 4;
		int levelScaling = level * 2;		
		int randNumerator = rand.nextInt(initial + levelScaling) + 1;
		int randDenominator = rand.nextInt(initial + levelScaling) + 1;
		
		if (type == QuestionType.WORD) {
			while (randNumerator > randDenominator) {
				randNumerator = rand.nextInt(initial + levelScaling) + 1;
			}
		}
		
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
