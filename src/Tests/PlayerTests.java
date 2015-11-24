package Tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Game.GameBoard;
import Game.Player;

public class PlayerTests {
	Player player;
	GameBoard board;
	
	@BeforeClass
	public void setUp() {
		board = new GameBoard();
		player = new Player();
	}
	
	// Test starting location on Board
	@Test
	public void testStartingLocation() {
		fail("Not yet implemented");
	}
	
	// Test initialization (name, score, etc...)
	@Test
	public void testInitializePlayer() {
		fail("Not yet implemented");
	}
		
	// Test player movement
	@Test
	public void testPlayerMovement() {
		fail("Not yet implemented");
	}

}
