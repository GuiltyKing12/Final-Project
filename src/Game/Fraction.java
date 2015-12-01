package Game;

public class Fraction {
	int numerator;
	int denominator;
	double value;
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		value = (double)numerator/denominator;
	}
	
	public int getNumerator() {
		//return this.numerator;
		return numerator;
	}
	
	public int getDenominator() {
		//return this.denominator;
		return denominator;
	}
	
	public double getValue() {
		return value;
		
	}

	@Override
	public String toString() {
		return (numerator + " / " + denominator );
	}
}
