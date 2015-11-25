package Game;

import java.awt.Color;

import com.sun.javafx.geom.Vec2d;

public class Player {
	private String name;
	private Vec2d position;
	private Color color;
	private int score;
	private int lives;
	
	public Player() {
		// TODO: Implementation
		this.name = "NULL";
		this.position = null;
		this.color = null;
		this.score = 0;
		this.lives = 0;
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
	
	public void setName(String name) {
		//this.name = name;
	}
	
	public void setScore(int score) {
		//this.score = score;
	}

	public void setPosition(Vec2d position) {
		this.position = position;
	}
	
	public void move(Vec2d moveLocation) {
		this.position = moveLocation;
	}
}
