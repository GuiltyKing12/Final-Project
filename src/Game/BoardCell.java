package Game;

import java.awt.Color;
import java.awt.Graphics;

public class BoardCell {
	private int row;					// Coordinate on the board
	private int col;
	private boolean isSolutionCell;		// Is this cell a potential solution cell?
	private char initial;				// Read from the boardConfig File
	private char secondary;				// Read from the boardConfig File
	private Fraction fraction;
	private boolean hasFraction;
	
	public BoardCell(char initial, int row, int col) {
		this.row = row;
		this.col = col;
		this.fraction = new Fraction();
		this.hasFraction = false;
		this.initial = initial;
		this.isSolutionCell = (initial == 'A') ? true : false;	// Sets isSolutionCell to true if (initial == 'A')
		this.secondary = '\0';
	}

	public void draw(Graphics g, int size, boolean writeFraction) {
		switch(initial) {
			case 'N': g.setColor(Color.BLACK);
					  break;
			case 'W': g.setColor(Color.YELLOW);
					  break;
			case 'A': g.setColor(Color.GREEN);
					  break;
			case 'I': g.setColor(Color.RED);
					  break;
		}
		g.fillRect(row*size, col*size, size, size);
		
		g.setColor(Color.GRAY);
		g.drawRect(row*size, col*size, size, size);
		
		if (hasFraction && writeFraction) {
			g.setColor(Color.BLACK);
			
			if (fraction.getNumerator() % fraction.getDenominator() == 0) {
				g.drawString(String.valueOf(fraction.getNumerator()/fraction.getDenominator()), (int)(row * size + size * 0.40), (int)(col * size  + size * 0.75));
			}
			else {
				g.drawString(String.valueOf(fraction.getNumerator()), (int)(row * size + size * 0.35), (int)(col * size  + size * 0.45));
				g.drawString("_" + "__", (int)(row * size + size * 0.15), (int)(col * size  + size * 0.5));
				g.drawString(String.valueOf(fraction.getDenominator()), (int)(row * size + size * 0.35), (int)(col * size  + size * 0.98));
			}
		}
	}
	
	public int getRow() {
		return row;
	}
	 
	public int getCol() {
		return col;
	}

	public void setPosition(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public boolean getIsSolutionCell() {
		return isSolutionCell;
	}
	
	public void setSolutionCell(boolean isSolutionCell) {
		this.isSolutionCell = isSolutionCell;
	}
	
	public char getInitial() {
		return initial;
	}

	public boolean getHasFraction() {
		return hasFraction;
	}

	public void setHasFraction(boolean hasFraction) {
		this.hasFraction = hasFraction;
	}

	public Fraction getFraction() {
		return fraction;
	}

	public void setFraction(Fraction fraction) {
		this.fraction = fraction;
	}

	public boolean isWalkway() {
		return initial == 'W';
	}

}
