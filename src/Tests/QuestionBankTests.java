package Tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

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
		fail("Not yet implemented");
	}
	
	// Test "chosen solution" is properly set to the solution
	@Test
	public void testChosenSolution() {
		fail("Not yet implemented");
	}

	// Test to ensure questions mare solvable by correct answers
	@Test
	public void testQuestionsMatchAnswers() {
		fail("Not yet implemented");
	}
	
	// Test evaluateGuess(), check whether solution is correct/incorrect.
	@Test
	public void testEvaluateGuess() {
		assertTrue(questionBank.evaluateGuess());
	}
}
