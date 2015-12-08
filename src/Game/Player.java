package Game;

import java.awt.Color;
import java.awt.Graphics;

import com.sun.javafx.geom.Vec2d;

public class Player {
	private String name;
	private Vec2d position;
	private int row;
	private int col;
	private Color color;
	private int score;
	private int lives;
	
	public Player() {
		// TODO: Implementation
		this.name = "NULL";
		this.position = null;
		this.color = color.BLUE;
		this.score = 0;
		this.lives = 3;
		this.position = new Vec2d(12, 11);
	}
	
	public Player(Player player2) {
		this.name = player2.getName();
		this.position = player2.getPosition();
		this.color = player2.getColor();
		this.score = player2.getScore();
		this.position = player2.getPosition();
		this.lives = player2.getLives();
	}
	
	public void draw(Graphics g, int size) {
		g.setColor(color);
		g.fillOval((int) position.y*size, (int) position.x*size, size, size);
		
	}

	public Vec2d getPosition() {
		return position;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLives() {
		return lives;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setLives(int lives) {
		this.lives = lives;
	}

	public void setPosition(Vec2d position) {
		this.position = position;
	}
	
	public void move(Vec2d moveLocation) {
		this.position = moveLocation;
	}
	
}
