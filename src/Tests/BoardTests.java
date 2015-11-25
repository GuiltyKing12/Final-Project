package Tests;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import Game.BoardCell;
import Game.GameBoard;

public class BoardTests {
	static GameBoard board;
	
	@BeforeClass
	public static void setUp() {
		board = new GameBoard();
	}

	// Test board is correctly initialized from .csv file
	@Test
	public void testInitializeBoard() {
		// TODO: Write test that checks certain cell locations for specifics (player location, item location, etc)
		//       to ensure board is being loaded in properly.
		fail("Not implemented yet");
	}
	
	// Test board dimensions
	@Test
	public void testBoardDimensions() {
		int numRows = 10;					// Change value to whatever we decide on
		int numCols = 10;					// Change value to whatever we decide on
		
		assertEquals(numRows, (int)(board.getDimensions().x));
		assertEquals(numCols, (int)(board.getDimensions().y));
	}
	
	// Test potential solution/answer cell locations
	@Test
	public void testSolutionCellLocations() {
		//TODO: We need to decide on fixed number of solutionCells (6 is a good number).
		// NOTE: Below testCell positions are all dependent on floorOne's layout
		// NOTE: testCell_#_# = testCell_row#_col# (0-based)
		
		BoardCell testCell_0_0 = new BoardCell();
		BoardCell testCell_0_5 = new BoardCell();
		BoardCell testCell_0_9 = new BoardCell();
		BoardCell testCell_5_2 = new BoardCell();
		BoardCell testCell_5_8 = new BoardCell();
		BoardCell testCell_8_1 = new BoardCell();
		
		assertTrue(testCell_0_0.getIsSolutionCell());
		assertTrue(testCell_0_5.getIsSolutionCell());
		assertTrue(testCell_0_9.getIsSolutionCell());
		assertTrue(testCell_5_2.getIsSolutionCell());
		assertTrue(testCell_5_8.getIsSolutionCell());
		assertTrue(testCell_8_1.getIsSolutionCell());
		
		assertTrue(board.getSolutionCells().contains(testCell_0_0));
		assertTrue(board.getSolutionCells().contains(testCell_0_5));
		assertTrue(board.getSolutionCells().contains(testCell_0_9));
		assertTrue(board.getSolutionCells().contains(testCell_5_2));
		assertTrue(board.getSolutionCells().contains(testCell_5_8));
		assertTrue(board.getSolutionCells().contains(testCell_8_1));
	}

}
