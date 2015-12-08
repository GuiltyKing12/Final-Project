package Tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Game.Question;
import Game.QuestionBank;

public class QuestionBankTests {
	static QuestionBank questionBank;
	static int testLevel;
	
	@BeforeClass
	public static void setUp() {
		testLevel = 0;
		questionBank = new QuestionBank(testLevel);
	}
	
	// Test initialization of questionBank
	@Test
	public void testInitializeQuestionBank() {
		Question question = questionBank.getRandomQuestion();
		assertTrue(question != null);
	}
	
	// Test "chosen solution" is properly set to the solution
	@Test
	public void testChosenSolution() {
		Question question = questionBank.getRandomQuestion();
		assertTrue(question.getSolution() != null);
	}
}
