package Game;

public class Fraction {
	static final double EPSILON = 0.0001;
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
	
	public void getCommonDenominator(Fraction fraction) {
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
	
	public void getCommonDenominator(Fraction fraction2, Fraction fraction3) {
		if (!hasCommonDenominator(this, fraction2)) { 
			this.getCommonDenominator(fraction2);		
		}
		
		if (!hasCommonDenominator(fraction2, fraction3)) {
			fraction2.getCommonDenominator(fraction3);

			if (!hasCommonDenominator(this, fraction2)) { 
				this.getCommonDenominator(fraction2);
			}
		}
	}
	
	public Fraction getRecipricol() {
		return new Fraction(denominator, numerator);
	}
	
	public double convertToDouble() {
		return (double) numerator / (double) denominator;
	}
	
	public int getWholeNumber() {
		return numerator / denominator;
	}
	
	public boolean equals(Fraction fraction) {
		if (this.value < fraction.getValue()) {
			return fraction.getValue() - this.value <= EPSILON;
		}
		
		return this.value - fraction.getValue() <= EPSILON;
	}
	
	public boolean canBeMadeWholeNumber() {
		return numerator % denominator == 0;
	}
	
	public boolean equals(double value) {
		return this.value - value <= EPSILON;
	}
	
	public boolean isGreaterThan(double value) {
		if (this.value == 0 && value == 0) {
			return false;
		}
		return this.value > value;
	}
	
	public boolean isLessThan(double value) {
		return this.value - value < 0;
	}

	@Override
	public String toString() {
		if (numerator % denominator == 0) {
			return String.valueOf(numerator/denominator);
		}
		return (numerator + "/" + denominator);
	}
}
