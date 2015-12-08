package Tests;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import Game.BoardCell;
import Game.GameBoard;
import Game.GameEngine;

public class BoardTests {
	static GameBoard board;
	static GameEngine engine;
	
	@BeforeClass
	public static void setUp() {
		engine = new GameEngine();
		board = engine.getBoard();
	}

	// Test board is correctly initialized from .csv file
	@Test
	public void testInitializeBoard() {
		// TODO: Write test that checks certain cell locations for specifics (player location, item location, etc)
		//       to ensure board is being loaded in properly.
		BoardCell item_4_7 = board.getCellAt(4, 7);
		BoardCell item_14_20 = board.getCellAt(14, 20);
		BoardCell item_20_11 = board.getCellAt(20, 11);
		
		assertTrue(item_4_7.getInitial() == 'I');
		assertTrue(item_14_20.getInitial() == 'I');
		assertTrue(item_20_11.getInitial() == 'I');		
	}
	
	// Test board dimensions
	@Test
	public void testBoardDimensions() {
		int numRows = 25;					
		int numCols = 25;					
		
		assertEquals(numRows, board.getRows());
		assertEquals(numCols, board.getCols());
	}
	
	// Test potential solution/answer cell locations
	@Test
	public void testSolutionCellLocations() {
		// NOTE: Below testCell positions are all dependent on floorEasy's layout
		// NOTE: testCell_#_# = testCell_row#_col# (0-based)
		
		BoardCell testCell_1_1 = board.getCellAt(1, 1);
		BoardCell testCell_1_12 = board.getCellAt(1, 12);
		BoardCell testCell_1_23 = board.getCellAt(1, 23);
		BoardCell testCell_12_5 = board.getCellAt(12, 5);
		BoardCell testCell_12_20 = board.getCellAt(12, 20);
		BoardCell testCell_14_5 = board.getCellAt(14, 5);
		BoardCell testCell_20_3 = board.getCellAt(20, 3);
		
		assertTrue(testCell_1_1.getIsSolutionCell());
		assertTrue(testCell_1_12.getIsSolutionCell());
		assertTrue(testCell_1_23.getIsSolutionCell());
		assertTrue(testCell_12_5.getIsSolutionCell());
		assertTrue(testCell_12_20.getIsSolutionCell());
		assertTrue(testCell_14_5.getIsSolutionCell());
		assertTrue(testCell_20_3.getIsSolutionCell());
		
		assertTrue(board.getSolutionCells().contains(testCell_1_1));
		assertTrue(board.getSolutionCells().contains(testCell_1_12));
		assertTrue(board.getSolutionCells().contains(testCell_1_23));
		assertTrue(board.getSolutionCells().contains(testCell_12_5));
		assertTrue(board.getSolutionCells().contains(testCell_12_20));
		assertTrue(board.getSolutionCells().contains(testCell_14_5));
		assertTrue(board.getSolutionCells().contains(testCell_20_3));
	}

}
