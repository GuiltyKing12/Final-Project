package Tests;



import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.javafx.geom.Vec2d;

import Game.GameBoard;
import Game.GameEngine;
import Game.Player;

public class PlayerTests {
	static Player player;
	static GameBoard board;
	static GameEngine engine;
	
	@BeforeClass
	public static void setUp() {
		
		engine = new GameEngine();
		player = new Player();
		engine.initializeGame();
		board = engine.getBoard();
	}
	
	// Test starting location on Board
	@Test
	public void testStartingLocation() {
		// assign player from game and see if player starts out in position (12, 12)
		player = new Player(board.getPlayer());
		assertEquals(12,  (int)(player.getPosition().x));
		assertEquals(11, (int)(player.getPosition().y));
	}
	
	// Test initialization (name, score, etc...)
	@Test
	public void testInitializePlayer() {
		player.setScore(1);
		player.setName("Test");
		player.setPosition(new Vec2d(1,1));
		
		assertEquals("Test", player.getName());	// Checks to see if Player name set correctly
		assertEquals(1, player.getScore());		// Checks to see if score can be set and returned
		assertEquals(1, (int)(player.getPosition().x));// Checks to see if player x position has been set
		assertEquals(1, (int)(player.getPosition().y));// Checks to see if player y position has been set
		assertEquals(3, player.getLives());		// Checks to see if player has been set with three lives
	}
		
	// Test player movement
	@Test
	public void testPlayerMovement() {
		player = new Player(board.getPlayer());
		
		// checks to see if player moves down correctly
		player.move(new Vec2d(12, 13));
		assertEquals(12, (int)(player.getPosition().x));
		assertEquals(13, (int)(player.getPosition().y));
		
		// checks to see if player moves up correctly
		player.move(new Vec2d(12, 11));
		assertEquals(12, (int)(player.getPosition().x));
		assertEquals(11, (int)(player.getPosition().y));
		
		// checks to see if player moves left correctly
		player.move(new Vec2d(11, 12));
		assertEquals(11, (int)(player.getPosition().x));
		assertEquals(12, (int)(player.getPosition().y));
		
		// checks to see if player moves right correctly
		player.move(new Vec2d(13, 12));
		assertEquals(13, (int)(player.getPosition().x));
		assertEquals(12, (int)(player.getPosition().y));
		
		// to be added when more code is defined
		// checks to see if cannot move because of walls
		// checks to see if cannot move because of bounds
	}

}
