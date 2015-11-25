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
		board.initialize();
	}
	
	// Test starting location on Board
	@Test
	public void testStartingLocation() {
		// assign player from game and see if player starts out in position (12, 12)
		player = board.getPlayer();
		assertEquals(12, player.getPosition().x);
		assertEquals(12, player.getPosition().y);
	}
	
	// Test initialization (name, score, etc...)
	@Test
	public void testInitializePlayer() {
		player.setScore(1);
		player.setName("Test");
		player.setPosition(new Vec2d(1,1));
		
		assertEquals("Test", player.getName());	// Checks to see if Player name set correctly
		assertEquals(1, player.getScore());		// Checks to see if score can be set and returned
		assertEquals(1, player.getPosition().x);// Checks to see if player x position has been set
		assertEquals(1, player.getPosition().y);// Checks to see if player y position has been set
		assertEquals(3, player.getLives());		// Checks to see if player has been set with three lives
	}
		
	// Test player movement
	@Test
	public void testPlayerMovement() {
		player = board.getPlayer();
		
		// checks to see if player moves down correctly
		player.move(new Vec2d(12, 13));
		assertEquals(12, player.getPosition().x);
		assertEquals(13, player.getPosition().y);
		
		// checks to see if player moves up correctly
		player.move(new Vec2d(12, 11));
		assertEquals(12, player.getPosition().x);
		assertEquals(11, player.getPosition().y);
		
		// checks to see if player moves left correctly
		player.move(new Vec2d(11, 12));
		assertEquals(11, player.getPosition().x);
		assertEquals(12, player.getPosition().y);
		
		// checks to see if player moves right correctly
		player.move(new Vec2d(13, 12));
		assertEquals(13, player.getPosition().x);
		assertEquals(12, player.getPosition().y);
		
		// to be added when more code is defined
		// checks to see if cannot move because of walls
		// checks to see if cannot move because of bounds
	}

}
