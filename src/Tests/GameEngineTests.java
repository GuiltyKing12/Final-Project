package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import Game.GameBoard;
import Game.GameEngine;

public class GameEngineTests {
	GameEngine engine;
	
	@BeforeClass
	public void setUp() {
		engine = new GameEngine();
		
	}
	
	// Test initialization of game
	@Test
	public void testInitializeGame() {
		GameBoard board = engine.getBoard();
		// Tests to see if board correctly sets up CSV files
		ArrayList<String> files = board.getLoadFile();
		assertEquals("CSV file 1", files.get(0));
		assertEquals("CSV file 2", files.get(1));
		assertEquals("CSV file 3", files.get(2));
		// Tests to see if board has correct dimensions
		assertEquals(25, board.getDimensions().x);
		assertEquals(25, board.getDimensions().y);
	}
	
	// Test advancing to next level
	@Test
	public void initializeGame() {
		// need to set score to whatever we decide is needed 
		engine.advanceNextLevel();
	}

	
}
