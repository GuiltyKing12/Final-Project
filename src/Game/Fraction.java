package Game;

public class Fraction {
	int numerator;
	int denominator;
	double value;
	
	public Fraction() {
		this.numerator = 0;
		this.denominator = 0;
		this.value = 0.0;
	}
	
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
	
	public void setNumerator(int value) {
		numerator = value;
	}
	
	public void setDenominator(int value) {
		denominator = value;
	}
	
	public boolean hasCommonDenominator(Fraction fraction) {
		return this.denominator == fraction.getDenominator();
	}
	
	public boolean hasCommonDenominator(Fraction fraction1, Fraction fraction2) {
		return this.denominator == fraction1.getDenominator() && this.denominator == fraction2.getDenominator();
	}
	
	public void computeCommonDenominator(Fraction fraction) {
		if (!hasCommonDenominator(fraction)) {
			if (denominator % fraction.getDenominator() == 0) {
				int conversionRatio = denominator / fraction.getDenominator();
				fraction.setNumerator(fraction.getNumerator() * conversionRatio);
				fraction.setDenominator(fraction.getDenominator() * conversionRatio);
			}
			else if (fraction.getDenominator() % denominator == 0) {
				int conversionRatio = fraction.getDenominator() / denominator;
				numerator = numerator * conversionRatio;
				denominator = denominator * conversionRatio;
			}
			else {
				int commonDenominator = denominator * fraction.getDenominator();
				numerator = fraction.getDenominator() * numerator;
				fraction.setDenominator(commonDenominator);
				fraction.setNumerator(fraction.getNumerator() * denominator);
				denominator = commonDenominator;
			}
		}
	}
	
	public void computeCommonDenominator(Fraction fraction2, Fraction fraction3) {
		if (!hasCommonDenominator(fraction2, fraction3)) { 
			this.computeCommonDenominator(fraction2);
			
			if (!hasCommonDenominator(fraction2, fraction3)) {
				this.computeCommonDenominator(fraction3);
			}
		}
	}
	
	public Fraction getRecipricol() {
		return new Fraction(denominator, numerator);
	}
	
	public double convertToDouble() {
		return (double) numerator / (double) denominator;
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
		//String temp = String.valueOf(numerator) + " / " + String.valueOf(denominator);
		return (numerator + " / " + denominator);
	}
}
