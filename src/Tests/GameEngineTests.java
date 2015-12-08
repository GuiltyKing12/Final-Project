package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import Game.GameBoard;
import Game.GameEngine;

public class GameEngineTests {
	static GameEngine engine;
	
	@BeforeClass
	public static void setUp() {
		engine = new GameEngine();
		
	}
	
	// Test initialization of game
	@Test
	public void testInitializeGame() {
		GameBoard board = engine.getBoard();
		// Tests to see if board correctly sets up CSV files
		ArrayList<String> files = board.getLoadFile();
		assertEquals("floorEasy.csv", files.get(0));
		assertEquals("floorMedium.csv", files.get(1));
		assertEquals("floorHard.csv", files.get(2));
		// Tests to see if board has correct dimensions
		assertEquals(25, board.getRows());
		assertEquals(25, board.getCols());
	}
	
	// Test advancing to next level
	@Test
	public void initializeGame() {
		// Set score so can advance
		engine.getBoard().getPlayer().setScore(5);
		assertEquals(5, engine.getBoard().getPlayer().getScore());
		
		// Level should now advance and score reset to 0
		engine.tryToAdvanceToNextLevel();
		assertEquals(0, engine.getBoard().getPlayer().getScore());
		
		
	}

	
}
