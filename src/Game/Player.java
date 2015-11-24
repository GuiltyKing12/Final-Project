package Game;

import java.awt.Color;

import com.sun.javafx.geom.Vec2d;

public class Player {
	private String name;
	private Vec2d position;
	private Color color;
	private int score;
	
	public Player() {
		// TODO: Implementation
		this.name = "NULL";
		this.position = null;
		this.color = null;
		this.score = 0;
	}

	public Vec2d getPosition() {
		return position;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPosition(Vec2d position) {
		this.position = position;
	}
	
	
}
