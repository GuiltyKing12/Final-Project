package Game;

public class Question {
	private String rawText;
	private String finalText;
	private Fraction fraction1;
	private Fraction fraction2;
	
	public Question(String text, Fraction fraction1, Fraction fraction2) {
		this.rawText = text;
		this.fraction1 = fraction1;
		this.fraction2 = fraction2;
		formatText();
	}
	
	private void formatText() {
		int posOfFirstFraction = rawText.indexOf('1');
		int posOfSecondFraction = rawText.indexOf('2');
		String firstFractionText = fraction1.getNumerator() + "/" + fraction1.getDenominator();
		String secondFractionText = fraction2.getNumerator() + "/" + fraction2.getDenominator();
		rawText = rawText.replace("{FRACTION1}", firstFractionText);
		rawText = rawText.replace("{FRACTION2}", secondFractionText);
		finalText = rawText;
	}

	@Override
	public String toString() {
		return finalText;
	}
}
