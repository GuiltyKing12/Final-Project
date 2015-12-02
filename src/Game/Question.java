package Game;

public class Question {
	private String rawText;
	private String finalText;
	private Fraction fraction1;
	private Fraction fraction2;
	private Fraction fraction3;
	
	public Question(String text, Fraction fraction1, Fraction fraction2) {
		this.rawText = text;
		this.fraction1 = fraction1;
		this.fraction2 = fraction2;
		formatText();
	}
	
	public Question(String text, Fraction fraction1, Fraction fraction2, Fraction fraction3) {
		this.rawText = text;
		this.fraction1 = fraction1;
		this.fraction2 = fraction2;
		this.fraction3 = fraction3;
		formatText();
	}
	
	private void formatText() {
		String firstFractionText = fraction1.getNumerator() + "/" + fraction1.getDenominator();
		String secondFractionText = fraction2.getNumerator() + "/" + fraction2.getDenominator();
		rawText = rawText.replace("{FRACTION1}", firstFractionText);
		rawText = rawText.replace("{FRACTION2}", secondFractionText);
		
		if (fraction3 != null) {
			String thirdFractionText = fraction3.getNumerator() + "/" + fraction3.getDenominator();
			rawText = rawText.replace("{FRACTION3}", thirdFractionText);
		}
		
		finalText = rawText;
	}

	@Override
	public String toString() {
		return finalText;
	}
}
