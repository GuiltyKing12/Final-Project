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
	
	public boolean equals(Fraction fraction) {
		return this.numerator == fraction.getNumerator() && this.denominator == fraction.getDenominator();
	}
	
	public boolean isGreaterThan(Fraction fraction) {
		return ((double) this.numerator / this.denominator) > ((double) fraction.getNumerator() / fraction.getDenominator());
	}
	
	public boolean isLessThan(Fraction fraction) {
		return ((double) this.numerator / this.denominator) < ((double) fraction.getNumerator() / fraction.getDenominator());
	}

	@Override
	public String toString() {
		return (numerator + " / " + denominator );
	}
}
