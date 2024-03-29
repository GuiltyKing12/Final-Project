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
	private int currentLevel;
	private Random rand;
	
	
	public QuestionBank(int level) {
		
		initialize(level);
	}
	
	public void initialize(int level) {
		this.currentLevel = level;
		questions = new ArrayList<Question>(); 
		arithmeticQuestions = new ArrayList<Question>();
		wordQuestions = new ArrayList<Question>();
		rand = new Random();
		initializeQuestionBank();
		//printQuestionBankContents();
	}
	
	private void initializeQuestionBank() {
		initializeArithmeticQuestions();
		initializeWordQuestions();
		questions.addAll(arithmeticQuestions);
		questions.addAll(wordQuestions);
	}
	
	private void initializeArithmeticQuestions() {
		 arithmeticQuestions.add(new Question("What is {FRACTION1} - {FRACTION2}?", QuestionType.SUBTRACT, currentLevel));
		 arithmeticQuestions.add(new Question("What is {FRACTION1} + {FRACTION2}?", QuestionType.ADD, currentLevel));
		 arithmeticQuestions.add(new Question("What is {FRACTION1} - {FRACTION2} + {FRACTION3}?", QuestionType.SUBADD, currentLevel));
		 arithmeticQuestions.add(new Question("What is {FRACTION1} + {FRACTION2} - {FRACTION3}?", QuestionType.ADDSUB, currentLevel));	 
		 arithmeticQuestions.add(new Question("What is {FRACTION1} * {FRACTION2}?", QuestionType.MULTIPLY, currentLevel));
		 arithmeticQuestions.add(new Question("Find the answer that is less than {FRACTION1}.", QuestionType.LESS, currentLevel));
		 arithmeticQuestions.add(new Question("Find the answer that is greater than {FRACTION1}.", QuestionType.GREATER, currentLevel));
		 arithmeticQuestions.add(new Question("Find the answer that is equal to {FRACTION1}.", QuestionType.EQUAL, currentLevel));
	}
	
	private void initializeWordQuestions() {
		wordQuestions.add(new Question("If you have a whole pizza and eat {FRACTION1} of it, how much of the pizza is left over?", QuestionType.WORD1, currentLevel));
		//wordQuestions.add(new Question("Mrs. Smith baked 20 cookies. Mr. Smith ate {FRACTION1} of the cookies. How many cookies are left for the class?", QuestionType.WORD2, currentLevel));
		wordQuestions.add(new Question("If you have 20 dollars and give your friend {FRACTION1} of the total, how much money do you have left over?", QuestionType.WORD3, currentLevel));
		wordQuestions.add(new Question("If every day has 24 hours in it and you spend {FRACTION1} of your day playing video games, how much of the day do you have left to play 'MORE' video games?", QuestionType.WORD4, currentLevel));
		wordQuestions.add(new Question("What portion of {FRACTION1} is left when you take away {FRACTION2} from it?", QuestionType.SUBTRACT, currentLevel));
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	public Question getRandomQuestion() {
		return questions.get(rand.nextInt(questions.size()));
	}
	
	public String getQuestion() {
		return questions.get(0).toString();
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
