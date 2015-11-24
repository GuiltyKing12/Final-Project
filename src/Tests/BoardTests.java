package Tests;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import Game.GameBoard;

public class BoardTests {
	GameBoard board;
	
	@BeforeClass
	public void setUp() {
		board = new GameBoard();
		
	}

	// Test board is correctly initialized from .csv file
	@Test
	public void testInitializeBoard() {
		fail("Not yet implemented");
	}
	
	// Test board dimensions
	@Test
	public void testBoardDimensions() {
		fail("Not yet implemented");
	}
	
	// Test potential solution/answer tile locations
	@Test
	public void testSolutionTileLocations() {
		fail("Not yet implemented");
	}

}
