package Game;

public class Fraction {
	int numerator;
	int denominator;
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public int getNumerator() {
		//return this.numerator;
		return 0;
	}
	
	public int getDenominator() {
		//return this.denominator;
		return 0;
	}
	
	public double getValue() {
		//return ((double) numerator / (double) denominator);
		return 0;
	}

	@Override
	public String toString() {
		return (numerator + " / " + denominator );
	}
}
